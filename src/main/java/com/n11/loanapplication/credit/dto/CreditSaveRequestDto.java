package com.n11.loanapplication.credit.dto;

import com.n11.loanapplication.credit.enums.CreditResultType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@Builder
@EqualsAndHashCode
public class CreditSaveRequestDto {
   private Long id;
   private Long userId;
   private BigDecimal creditLimit;
   private CreditResultType creditResultType;
}
