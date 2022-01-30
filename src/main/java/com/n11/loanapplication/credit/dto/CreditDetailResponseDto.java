package com.n11.loanapplication.credit.dto;

import com.n11.loanapplication.credit.enums.CreditResultType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class CreditDetailResponseDto {
    private String name;
    private String surname;
    private LocalDate dateOfBirthday;
    private String identificationNumber;
    private String phone;
    private BigDecimal salary;
    private CreditResultType creditResultType;
    private BigDecimal creditLimit;
}
