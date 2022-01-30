package com.n11.loanapplication.sms.service;

import com.n11.loanapplication.sms.dto.SmsRequest;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}
