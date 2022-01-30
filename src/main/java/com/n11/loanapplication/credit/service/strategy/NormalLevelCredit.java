package com.n11.loanapplication.credit.service.strategy;

import com.n11.loanapplication.credit.dto.CreditSaveRequestDto;
import com.n11.loanapplication.credit.service.CreditCalculate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.n11.loanapplication.credit.enums.CreditResultType.*;

public class NormalLevelCredit implements CreditCalculate {

    private static final Logger logger = LoggerFactory.getLogger(NormalLevelCredit.class);

    @Override
    public CreditSaveRequestDto calculateCreditLimit(Long userId, BigDecimal salary, BigDecimal guarantee) {
        BigDecimal creditLimit = salary.multiply(BigDecimal.valueOf(4))
                                        .divide(BigDecimal.valueOf(2), RoundingMode.CEILING);
        if(guarantee!=null){
            creditLimit = creditLimit.add(guarantee.multiply(BigDecimal.valueOf(0.25)));
        }
        CreditSaveRequestDto creditSaveRequestDto = CreditSaveRequestDto.builder()
                .userId(userId)
                .creditResultType(APPROVE)
                .creditLimit(creditLimit)
                .build();

        logger.info("Normal Level Credit Calculated : {}",creditSaveRequestDto);
        return creditSaveRequestDto;
    }
}
