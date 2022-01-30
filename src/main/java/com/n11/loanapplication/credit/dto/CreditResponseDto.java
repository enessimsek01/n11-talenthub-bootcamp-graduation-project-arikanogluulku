package com.n11.loanapplication.credit.dto;

import com.n11.loanapplication.credit.enums.CreditResultType;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
@Builder
public class CreditResponseDto {
    private BigDecimal creditLimit;
    @Enumerated(EnumType.STRING)
    private CreditResultType creditResultType;
}
