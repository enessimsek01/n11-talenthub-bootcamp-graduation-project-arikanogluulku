package com.n11.loanapplication.credit.service.impl;

import com.n11.loanapplication.credit.service.CreditScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class CreditScoreServiceImpl implements CreditScoreService {

    private static final Logger logger = LoggerFactory.getLogger(CreditScoreServiceImpl.class);

    @Override
    public Long calculateCreditScore(String tcNo) {
        Long lastThreeDigitsIdentificationNumber = Long.valueOf(tcNo.substring(tcNo.length() - 3));
        long creditScore =lastThreeDigitsIdentificationNumber+100;

        logger.info("Credit Score Calculated : {}",creditScore);

        return creditScore;

    }
}
