package com.rca.formvalidator;

import android.support.design.widget.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public class Form {

    private List<Validate> validateList;

    public Form() {

        this.validateList = new ArrayList(0);
    }

    public void addValidate(Validate validate) {

        if (validate != null) {

            validateList.add(validate);
        }
    }

    public boolean removeValidate(Validate validate) {

        if (validate != null && !validateList.isEmpty()) {

            return validateList.remove(validate);
        }

        return false;
    }

    public boolean validate() {

        boolean isValid = true;

        for (Validate validate : validateList) {

            isValid = isValid & validate.isValid();
        }

        return isValid;
    }

    public void closeError(TextInputLayout textInputLayout) {

        if (textInputLayout != null) {

            textInputLayout.setErrorEnabled(false);
            textInputLayout.setError(null);
        }
    }

    public void closeAllErrors() {

        for (Validate validate : validateList) {

            validate.closeError();
        }
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================
}