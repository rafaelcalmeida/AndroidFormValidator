package com.rca.formvalidator.validator;

import android.content.Context;
import android.support.annotation.StringRes;
import android.text.TextUtils;

import com.rca.formvalidator.BaseValidator;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public final class NotEmptyValidator extends BaseValidator {

    public NotEmptyValidator(Context context, @StringRes int errorRes) {

        super(context, errorRes);
    }

    public NotEmptyValidator(Context context, String errorMessage) {

        super(context, errorMessage);
    }

    @Override
    public boolean isValid(String value) {

        return !TextUtils.isEmpty(value);
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================
}
