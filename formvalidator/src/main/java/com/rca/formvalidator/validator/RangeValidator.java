package com.rca.formvalidator.validator;

import android.content.Context;
import android.support.annotation.StringRes;

import com.rca.formvalidator.BaseValidator;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public final class RangeValidator extends BaseValidator {

    private double start;
    private double end;

    public RangeValidator(Context context, @StringRes int errorRes, double start, double end) {

        super(context, errorRes);
        this.start = start;
        this.end = end;
    }

    public RangeValidator(Context context, String errorMessage, double start, double end) {

        super(context, errorMessage);
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean isValid(String value) {

        if (value != null && value.length() > 0) {

            double dValue = Double.parseDouble(value);
            return dValue >= start && dValue <= end;
        }

        return false;
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================
}
