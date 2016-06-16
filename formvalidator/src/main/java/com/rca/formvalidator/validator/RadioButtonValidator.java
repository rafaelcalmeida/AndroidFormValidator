package com.rca.formvalidator.validator;

import android.content.Context;
import android.support.annotation.StringRes;

import com.rca.formvalidator.BaseValidator;

/**
 * Created by Rafael C. Almeida on 16/06/16.
 */
public class RadioButtonValidator extends BaseValidator {

    public RadioButtonValidator(Context context, @StringRes int errorRes) {

        super(context, errorRes);
    }

    public RadioButtonValidator(Context context, String errorMessage) {

        super(context, errorMessage);
    }

    @Override
    public boolean isValid(String value) {

        return !("-1").equals(value);
    }
}
