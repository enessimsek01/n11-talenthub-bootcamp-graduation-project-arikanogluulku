package com.n11.loanapplication.credit.service.strategy;
import com.n11.loanapplication.credit.dto.CreditSaveRequestDto;
import com.n11.loanapplication.credit.service.CreditCalculate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

import static com.n11.loanapplication.credit.enums.CreditResultType.APPROVE;

public class IntermetiateLevelCredit implements CreditCalculate {

    private static final Logger logger = LoggerFactory.getLogger(IntermetiateLevelCredit.class);

    @Override
    public CreditSaveRequestDto calculateCreditLimit(Long userId, BigDecimal salary, BigDecimal guarantee) {
        BigDecimal creditLimit = BigDecimal.valueOf(20000);
        if (guarantee != null) {
            creditLimit = creditLimit.add(guarantee.multiply(BigDecimal.valueOf(0.20)));
        }
        CreditSaveRequestDto creditSaveRequestDto = CreditSaveRequestDto.builder()
                .userId(userId)
                .creditResultType(APPROVE)
                .creditLimit(creditLimit)
                .build();

        logger.info("Intermetiate Level Credit Calculated : {}",creditSaveRequestDto);
        return creditSaveRequestDto;
    }
}
