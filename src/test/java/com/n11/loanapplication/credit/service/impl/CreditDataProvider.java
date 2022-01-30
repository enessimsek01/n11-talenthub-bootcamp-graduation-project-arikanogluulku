package com.n11.loanapplication.credit.service.impl;

import com.n11.loanapplication.credit.dto.CreditDetailResponseDto;
import com.n11.loanapplication.credit.dto.CreditResponseDto;
import com.n11.loanapplication.credit.dto.CreditSaveRequestDto;
import com.n11.loanapplication.credit.enums.CreditResultType;
import com.n11.loanapplication.credit.model.Credit;
import com.n11.loanapplication.user.service.impl.UserDataProvider;

import java.math.BigDecimal;

import static com.n11.loanapplication.user.service.impl.UserDataProvider.*;

public class CreditDataProvider {
    public static Credit getCredit(){
        Credit credit = Credit.builder()
                .id(100L)
                .user(getUser())
                .creditResultType(CreditResultType.APPROVE)
                .creditLimit(BigDecimal.valueOf(100000))
                .build();
        return credit;
    }
    public static CreditResponseDto getCreditResponseDto(){
        CreditResponseDto creditResponseDto = CreditResponseDto.builder()
                .creditResultType(CreditResultType.APPROVE)
                .creditLimit(BigDecimal.valueOf(100000))
                .build();
        return creditResponseDto;
    }
    public static CreditSaveRequestDto getCreditSaveRequestDto(){
        CreditSaveRequestDto creditSaveRequestDto = CreditSaveRequestDto.builder()
                .id(100L)
                .creditResultType(CreditResultType.APPROVE)
                .creditLimit(BigDecimal.valueOf(100000))
                .build();
        return creditSaveRequestDto;
    }
    public static CreditDetailResponseDto getCreditDetailResponseDto(){
        CreditDetailResponseDto creditDetailResponseDto = CreditDetailResponseDto.builder()
                .name(getUser().getName())
                .surname(getUser().getSurname())
                .dateOfBirthday(getUser().getDateOfBirthday())
                .identificationNumber(getUser().getIdentificationNumber())
                .phone(getUser().getPhone())
                .salary(getUser().getSalary())
                .creditResultType(CreditResultType.APPROVE)
                .creditLimit(BigDecimal.valueOf(100000))
                .build();
        return creditDetailResponseDto;
    }
}
