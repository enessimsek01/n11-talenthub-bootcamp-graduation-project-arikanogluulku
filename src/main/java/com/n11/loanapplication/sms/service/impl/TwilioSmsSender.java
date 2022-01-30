package com.n11.loanapplication.sms.service.impl;

import com.n11.loanapplication.sms.config.TwilioConfiguration;
import com.n11.loanapplication.sms.dto.SmsRequest;
import com.n11.loanapplication.sms.service.SmsSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TwilioSmsSender implements SmsSender {

    private final TwilioConfiguration twilioConfiguration;

    @Override
    public void sendSms(SmsRequest smsRequest) {
        PhoneNumber to = new PhoneNumber("+9"+smsRequest.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
        String message = smsRequest.getMessage();

        MessageCreator creator = Message.creator(
                to,
                from,
                message
        );
        creator.create();
        log.info("Send sms {}" + smsRequest.getMessage());
    }
}
