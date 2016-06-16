package com.rca.formvalidator.validator;

import android.content.Context;
import android.support.annotation.StringRes;

import com.rca.formvalidator.BaseValidator;

/**
 * Created by Rafael C. Almeida on 16/06/16.
 */
public class SpinnerValidator extends BaseValidator {

    public SpinnerValidator(Context context, @StringRes int errorRes) {

        super(context, errorRes);
    }

    public SpinnerValidator(Context context, String errorMessage) {

        super(context, errorMessage);
    }

    @Override
    public boolean isValid(String value) {

        return (!"-1".equals(value)) && (!"0".equals(value));
    }
}
