package com.rca.formvalidator.validator;

import android.content.Context;
import android.support.annotation.StringRes;
import android.util.Patterns;

import com.rca.formvalidator.BaseValidator;

import java.util.regex.Pattern;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public final class UrlValidator extends BaseValidator {

    public UrlValidator(Context context, @StringRes int errorRes) {

        super(context, errorRes);
    }

    public UrlValidator(Context context, String errorMessage) {

        super(context, errorMessage);
    }

    @Override
    public boolean isValid(String value) {

        return Pattern.compile(Patterns.WEB_URL.pattern()).matcher(value).matches();
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================
}
