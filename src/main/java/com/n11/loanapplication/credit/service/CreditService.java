package com.n11.loanapplication.credit.service;

import com.n11.loanapplication.credit.dto.CreditDetailResponseDto;
import com.n11.loanapplication.credit.dto.CreditResponseDto;
import com.n11.loanapplication.credit.dto.CreditSaveRequestDto;
import com.n11.loanapplication.user.dto.UserRequestDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface CreditService {
    CreditResponseDto createUserAndCreditApplication(UserRequestDto userRequestDto);

    CreditResponseDto saveCredit(CreditSaveRequestDto creditSaveRequestDto);

    CreditDetailResponseDto inquiryCreditApplication(String identificationNumber , LocalDate dateOfBirthday);
}
