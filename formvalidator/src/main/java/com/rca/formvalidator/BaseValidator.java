package com.rca.formvalidator;

import android.content.Context;
import android.support.annotation.StringRes;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public abstract class BaseValidator {

    private Context context;
    private int errorRes;
    private String errorMessage;

    public BaseValidator(Context context, @StringRes int errorRes) {

        this.context = context;
        this.errorRes = errorRes;
        this.errorMessage = context.getString(errorRes);
    }

    public BaseValidator(Context context, String errorMessage) {

        this.context = context;
        this.errorMessage = errorMessage;
    }

    public final Context getContext() {
        return context;
    }

    public int getErrorRes() {
        return errorRes;
    }

    public String getErrorMessage() {

        return errorMessage;
    }

    public abstract boolean isValid(String value);

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================
}
