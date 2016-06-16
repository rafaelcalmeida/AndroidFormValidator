package com.rca.formvalidator.validator;

import android.content.Context;
import android.support.annotation.StringRes;

import com.rca.formvalidator.BaseValidator;

import java.util.regex.Pattern;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public final class RegExpValidator extends BaseValidator {

    private Pattern pattern;

    public RegExpValidator(Context context, @StringRes int errorRes) {

        super(context, errorRes);
    }

    public RegExpValidator(Context context, String errorMessage) {

        super(context, errorMessage);
    }

    public void setPattern(Pattern pattern) {

        this.pattern = pattern;
    }

    @Override
    public boolean isValid(String value) {

        if (pattern != null) {

            return pattern.matcher(value).matches();
        }

        throw new RuntimeException("Você precisa configurar o Pattern");
    }
}
