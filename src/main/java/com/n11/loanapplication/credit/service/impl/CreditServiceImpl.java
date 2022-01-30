package com.n11.loanapplication.credit.service.impl;

import com.n11.loanapplication.credit.dto.converter.CreditMapper;
import com.n11.loanapplication.credit.enums.CreditLevel;
import com.n11.loanapplication.credit.repository.CreditRepository;
import com.n11.loanapplication.credit.dto.CreditDetailResponseDto;
import com.n11.loanapplication.credit.dto.CreditResponseDto;
import com.n11.loanapplication.credit.dto.CreditSaveRequestDto;
import com.n11.loanapplication.credit.model.Credit;
import com.n11.loanapplication.credit.service.CreditCalculateFactory;
import com.n11.loanapplication.credit.service.CreditScoreService;
import com.n11.loanapplication.credit.service.CreditService;
import com.n11.loanapplication.gen.exception.CreditNotFound;
import com.n11.loanapplication.sms.dto.SmsRequest;
import com.n11.loanapplication.sms.service.impl.TwilioSmsSender;
import com.n11.loanapplication.user.dto.UserRequestDto;
import com.n11.loanapplication.user.dto.UserResponseDto;
import com.n11.loanapplication.user.service.UserService;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.n11.loanapplication.credit.enums.CreditLevel.*;
import static com.n11.loanapplication.gen.utilities.MessageConstants.CREDIT_APPLICATION_RESULT_SMS;
import static com.n11.loanapplication.gen.utilities.MessageConstants.currencyFormat;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final UserService userService;
    private final CreditScoreService creditScoreService;
    private final TwilioSmsSender twilioSmsSender;

    private static final Logger logger = LoggerFactory.getLogger(CreditServiceImpl.class);


    @Override
    public CreditResponseDto createUserAndCreditApplication(UserRequestDto userRequestDto) {
        UserResponseDto user = userService.getUserByIdentificationNumber(userRequestDto.getIdentificationNumber());
        if(user!=null){
            user = userService.updateByUserSalaryAndGuaranteeAndPhone(user.getId(),userRequestDto.getSalary(),
                    userRequestDto.getGuarantee(),userRequestDto.getPhone());
            logger.info("User updated in credit application. {} " , user);
        }
        else {
            user = userService.createUser(userRequestDto);
            logger.info("User created in credit application. {} " , user);

        }

        Long creditScore = creditScoreService.calculateCreditScore(user.getIdentificationNumber());
        BigDecimal salary = user.getSalary();
        CreditLevel creditLevel = null;

        //if-else block that finds what level it is for credit and directs it to that algorithm
        if(creditScore>500 && creditScore<1000 && salary.longValue()<5000){
            creditLevel = LOW_LEVEL_CREDIT;
        }else if(creditScore>500 && creditScore<1000 && salary.longValue()>5000 && salary.longValue()<10000){
            creditLevel = INTERMEDITATE_LEVEL_CREDIT;
        }else if(creditScore>500 && creditScore<1000 && salary.longValue()>=10000 ){
            creditLevel = NORMAL_LEVEL_CREDIT;
        }else if(creditScore>=1000){
            creditLevel = HIGH_LEVEL_CREDIT;
        }else{
            creditLevel = NEGATIVE_CREDIT;
        }

        CreditSaveRequestDto creditResult = CreditCalculateFactory.getInstance(creditLevel)
                .calculateCreditLimit(user.getId(),salary, user.getGuarantee());

        //sms is sent by twilio only to registered reliable numbers. To test, your number must be registered. you can contact us to test it.
        twilioSmsSender.sendSms(new SmsRequest(user.getPhone(),
                String.format(CREDIT_APPLICATION_RESULT_SMS,user.getName(),creditResult.getCreditResultType(),
                        currencyFormat(creditResult.getCreditLimit()))));

        return saveCredit(creditResult);
    }


    @Override
    public CreditResponseDto saveCredit(CreditSaveRequestDto creditSaveRequestDto) {
        Credit credit = CreditMapper.INSTANCE.convertToCredit(creditSaveRequestDto);
        credit = creditRepository.save(credit);
        CreditResponseDto creditResponseDto =  CreditMapper.INSTANCE.convertToCreditResponseDto(credit);

        logger.info("Credit Saved. {}",creditResponseDto);

        return creditResponseDto;
    }

    @Override
    public CreditDetailResponseDto inquiryCreditApplication(String identificationNumber, LocalDate dateOfBirthday) {
        CreditDetailResponseDto creditDetailResponseDto =
                creditRepository.getCreditApplicationDetailByIdentifitacionNumberAndBirthday(identificationNumber ,dateOfBirthday);
        if(creditDetailResponseDto!=null){
            logger.info("Credit Inquiry Result: {}",creditDetailResponseDto);
            return creditDetailResponseDto;

        }else{
            logger.warn("Credit Not Found : Identification Number -> {} - Date Of Birthday -> {}" ,identificationNumber,dateOfBirthday);
            throw  new CreditNotFound("There is no application with identification number :  " + identificationNumber+
                    " and date of birth : "+ dateOfBirthday);
        }
    }
}
