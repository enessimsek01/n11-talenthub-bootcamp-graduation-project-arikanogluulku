package com.n11.loanapplication.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@EqualsAndHashCode
public class UserResponseDto {
    private Long id;

    private String name;

    private String surname;

    private LocalDate dateOfBirthday;

    private String identificationNumber;

    private String phone ;

    private BigDecimal salary;

    private BigDecimal guarantee;

}
