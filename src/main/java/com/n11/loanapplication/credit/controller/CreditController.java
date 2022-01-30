package com.n11.loanapplication.credit.controller;

import com.n11.loanapplication.credit.dto.CreditDetailResponseDto;
import com.n11.loanapplication.credit.dto.CreditResponseDto;
import com.n11.loanapplication.credit.service.CreditService;
import com.n11.loanapplication.user.dto.UserRequestDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/credits")
@RequiredArgsConstructor
@CrossOrigin
public class CreditController {

    private final CreditService creditService;

    @ApiOperation(value = "create a credit application(unregistered users)")
    @PostMapping()
    public ResponseEntity<CreditResponseDto> createUserAndCreditApplication(@Valid @RequestBody UserRequestDto userRequestDto){
        CreditResponseDto creditResponseDto = creditService.createUserAndCreditApplication(userRequestDto);
        return ResponseEntity.status(201).body(creditResponseDto);
    }


    @ApiOperation(value = "inquiry a credit application")
    @GetMapping("/inquiry")
    public ResponseEntity<CreditDetailResponseDto> inquiryCreditApplication(@RequestParam (name = "dateOfBirthday") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate dateOfBirthday ,
                                                                            @RequestParam String identificationNumber) {
        CreditDetailResponseDto creditDetailResponseDto= creditService.inquiryCreditApplication(identificationNumber,dateOfBirthday);
        return ResponseEntity.status(200).body(creditDetailResponseDto);
    }
}
