package com.n11.loanapplication.credit.service;

import org.springframework.stereotype.Service;

@Service
public interface CreditScoreService {
    Long calculateCreditScore(String identificationNumber);
}
