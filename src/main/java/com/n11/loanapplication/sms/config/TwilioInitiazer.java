package com.n11.loanapplication.sms.config;


import com.twilio.Twilio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class TwilioInitiazer {

    private final TwilioConfiguration twilioConfiguration;

    public TwilioInitiazer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        log.info("Twilio initialized... with account sid {}" , twilioConfiguration.getAccountSid());
    }

}
