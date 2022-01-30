package com.n11.loanapplication.credit.service.strategy;

import com.n11.loanapplication.credit.dto.CreditSaveRequestDto;
import com.n11.loanapplication.credit.enums.CreditResultType;
import com.n11.loanapplication.credit.service.CreditCalculate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.math.BigDecimal;

public class NegativeCredit implements CreditCalculate {
    private static final Logger logger = LoggerFactory.getLogger(NegativeCredit.class);
    @Override
    public CreditSaveRequestDto calculateCreditLimit(Long userId, BigDecimal salary, BigDecimal guarantee) {
        logger.info("Negative Credit !");
        return CreditSaveRequestDto.builder()
                .userId(userId)
                .creditLimit(BigDecimal.valueOf(0))
                .creditResultType(CreditResultType.REJECTION).build();
    }
}
