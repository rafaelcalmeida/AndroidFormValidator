package com.rca.formvalidator.validator;

import android.content.Context;
import android.support.annotation.StringRes;

import com.rca.formvalidator.BaseValidator;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public class NumericValidator extends BaseValidator {

    public NumericValidator(Context context, @StringRes int errorRes) {

        super(context, errorRes);
    }

    public NumericValidator(Context context, String errorMessage) {

        super(context, errorMessage);
    }

    @Override
    public boolean isValid(String value) {

        if (value == null || value.length() == 0) {

            return false;
        }

        for (int pos = 0; pos < value.length(); pos++) {

            if (!Character.isDigit(value.charAt(pos))) {

                return false;
            }
        }

        return true;
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================
}
