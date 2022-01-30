package com.n11.loanapplication.credit.service;

import com.n11.loanapplication.credit.enums.CreditLevel;
import com.n11.loanapplication.credit.service.strategy.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditCalculateFactory {

    public static CreditCalculate getInstance(CreditLevel creditLevel) {
        switch (creditLevel) {
            case LOW_LEVEL_CREDIT:
                return new LowLevelCredit();
            case INTERMEDITATE_LEVEL_CREDIT:
                return new IntermetiateLevelCredit();
            case NORMAL_LEVEL_CREDIT:
                return new NormalLevelCredit();
            case HIGH_LEVEL_CREDIT:
                return new HighLevelCredit();
            case NEGATIVE_CREDIT:
                return new NegativeCredit();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
