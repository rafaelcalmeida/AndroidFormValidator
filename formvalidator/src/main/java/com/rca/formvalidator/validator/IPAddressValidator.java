package com.rca.formvalidator.validator;

import android.content.Context;
import android.support.annotation.StringRes;

import com.rca.formvalidator.BaseValidator;

import java.util.regex.Pattern;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public final class IPAddressValidator extends BaseValidator {

    private static final String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public IPAddressValidator(Context context, @StringRes int errorRes) {

        super(context, errorRes);
    }

    public IPAddressValidator(Context context, String errorMessage) {

        super(context, errorMessage);
    }

    @Override
    public boolean isValid(String value) {

        return Pattern.compile(IPADDRESS_PATTERN).matcher(value).matches();
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================
}
