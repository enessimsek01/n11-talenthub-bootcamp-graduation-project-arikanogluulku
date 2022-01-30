package com.n11.loanapplication.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.n11.loanapplication.gen.utilities.StringPatternConstanst.*;
import static com.n11.loanapplication.gen.utilities.ValidMessageConstants.*;

@Builder
@EqualsAndHashCode
@Data
public class UserRequestDto {
    @ApiModelProperty(notes = "User ID" , hidden = true)
    private Long id;

    @ApiModelProperty(notes = "User name" , example = "James" , required = true)
    @NotBlank(message = NOT_BLANK_MESSAGE)
    @Size(min = 3 , max = 20 , message = SIZE_VALID)
    private String name;

    @ApiModelProperty(notes = "User surname" ,example = "Gosling", required = true)
    @NotBlank(message = NOT_BLANK_MESSAGE)
    @Size(min = 3 , max = 20 , message = SIZE_VALID)
    private String surname;

    @ApiModelProperty(notes = "User's date of birth" ,example = "1955-05-19", required = true , value = "1998-01-01")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
    @NotNull(message = NOT_NULL_MESSAGE )
    private LocalDate dateOfBirthday;

    @ApiModelProperty(notes = "User's identification number" , example = "12121212121",  required = true , value = "11111111111")
    @NotBlank(message = NOT_NULL_MESSAGE)
    @Pattern(regexp = IDENTIFICATION_NUMBER_REGEX , message = IDENDIFICATION_NUMBER_VALID_MESSAGE)
    private String identificationNumber;

    @ApiModelProperty(notes = "User's phone number" , required = true , example = "05555555555", value = "05555555555")
    @NotBlank(message = NOT_NULL_MESSAGE)
    @Pattern(regexp = PHONE_NUMBER_REGEX, message = PHONE_VALID_MESSAGE )
    private String phone ;

    @ApiModelProperty(notes = "User's salary" ,  example = "15000", required = true)
    @Min(value = 0 )
    @NotNull(message = NOT_NULL_MESSAGE)
    private BigDecimal salary;

    @ApiModelProperty(notes = "The amount of guarantee for the loan(optional)" ,  example = "100000", required = false)
    @Min(value = 0 )
    @NotNull(message = NOT_NULL_MESSAGE)
    private BigDecimal guarantee;
}
