package com.n11.loanapplication.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class SmsRequest {
    private  String phoneNumber;
    private  String message;
}
