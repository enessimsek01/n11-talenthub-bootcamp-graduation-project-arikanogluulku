package com.n11.loanapplication.gen.utilities;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class MessageConstants {
    public static final String CREDIT_APPLICATION_RESULT_SMS = "Dear %s , credit application result is %s . Limit : %s  ";

    public static String currencyFormat(BigDecimal n) {
        return NumberFormat.getCurrencyInstance().format(n);
    }
}
