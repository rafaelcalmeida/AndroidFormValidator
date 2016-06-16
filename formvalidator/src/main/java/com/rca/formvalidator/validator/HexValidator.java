package com.rca.formvalidator.validator;

import android.content.Context;
import android.support.annotation.StringRes;

import com.rca.formvalidator.BaseValidator;

import java.util.regex.Pattern;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public class HexValidator extends BaseValidator {

    private static final String PATTERN = "^(#|)[0-9A-Fa-f]+$";

    public HexValidator(Context context, @StringRes int errorRes) {

        super(context, errorRes);
    }

    public HexValidator(Context context, String errorMessage) {

        super(context, errorMessage);
    }

    @Override
    public boolean isValid(String value) {

        return Pattern.compile(PATTERN).matcher(value).matches();
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================
}
