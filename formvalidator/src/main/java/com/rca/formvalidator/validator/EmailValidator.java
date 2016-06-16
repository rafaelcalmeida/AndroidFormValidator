package com.rca.formvalidator.validator;

import android.content.Context;
import android.support.annotation.StringRes;
import android.text.TextUtils;

import com.rca.formvalidator.BaseValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public final class EmailValidator extends BaseValidator {

    private String domainName = "";

    public EmailValidator(Context context, @StringRes int errorRes) {

        super(context, errorRes);
    }

    public EmailValidator(Context context, String errorMessage) {

        super(context, errorMessage);
    }

    @Override
    public boolean isValid(String value) {

        String expression = isNotEmpty(domainName) ? (".+@" + domainName) : ".+@.+\\.[a-z]+";

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================

    private boolean isNotEmpty(String text) {

        return !TextUtils.isEmpty(text);
    }
}
