package com.n11.loanapplication.credit.service;

import com.n11.loanapplication.credit.dto.CreditResponseDto;
import com.n11.loanapplication.credit.dto.CreditSaveRequestDto;

import java.math.BigDecimal;

public interface CreditCalculate {

    CreditSaveRequestDto calculateCreditLimit(Long userId, BigDecimal salary , BigDecimal guarantee);

}
