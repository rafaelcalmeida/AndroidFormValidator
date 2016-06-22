package com.rca.sample;

import android.support.annotation.NonNull;
import android.view.View;

import com.rca.formvalidator.Validate;

/**
 * Created by rafael on 22/06/16.
 */
public class OnFocusValidationListener implements View.OnFocusChangeListener {

    private Validate validate;

    public OnFocusValidationListener(@NonNull Validate validate) {

        this.validate = validate;
    }

    @Override
    public void onFocusChange(View view, boolean hasFocus) {

        if (hasFocus) {

            validate.closeError();

        } else {

            validate.isValid();
        }
    }
}
