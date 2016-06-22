package com.rca.formvalidator;

import android.support.design.widget.TextInputLayout;

import com.rca.formvalidator.interfaces.FormViewInterface;

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

    public void closeError(Validate validate) {

        if (validate != null) {

            validate.closeError();
        }
    }

    public void closeError(TextInputLayout textInputLayout) {

        Validate.closeError(textInputLayout);
    }

    public void closeError(FormViewInterface formViewInterface) {

        Validate.closeError(formViewInterface);
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