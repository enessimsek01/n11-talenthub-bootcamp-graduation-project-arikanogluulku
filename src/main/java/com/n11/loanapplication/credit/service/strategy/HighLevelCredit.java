package com.n11.loanapplication.credit.service.strategy;

import com.n11.loanapplication.credit.dto.CreditSaveRequestDto;
import com.n11.loanapplication.credit.service.CreditCalculate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

import static com.n11.loanapplication.credit.enums.CreditResultType.APPROVE;

public class HighLevelCredit implements CreditCalculate {

    private static final Logger logger = LoggerFactory.getLogger(HighLevelCredit.class);

    @Override
    public CreditSaveRequestDto calculateCreditLimit(Long userId, BigDecimal salary, BigDecimal guarantee) {
        BigDecimal creditLimit = salary.multiply(BigDecimal.valueOf(4));
        if(guarantee!=null){
            creditLimit = creditLimit.add(guarantee.multiply(BigDecimal.valueOf(0.5)));

        }
        CreditSaveRequestDto creditSaveRequestDto = CreditSaveRequestDto.builder()
                .userId(userId)
                .creditResultType(APPROVE)
                .creditLimit(creditLimit)
                .build();

        logger.info("High Level Credit Calculated : {}",creditSaveRequestDto);
        return creditSaveRequestDto;
    }
}
