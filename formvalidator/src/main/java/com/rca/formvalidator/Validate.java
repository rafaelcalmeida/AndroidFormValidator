package com.rca.formvalidator;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.view.View;

import com.rca.formvalidator.interfaces.FormViewInterface;
import com.rca.formvalidator.interfaces.ValidateInterface;
import com.rca.formvalidator.interfaces.ValidateListener;
import com.rca.formvalidator.selector.ViewSelector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public final class Validate implements ValidateInterface {

    private List<BaseValidator> validators;
    private ValidateListener validateListener;
    private ViewSelector viewSelector;

    // Views
    private View view;
    private FormViewInterface formViewInterface;
    private TextInputLayout textInputLayout;

    public Validate(@NonNull View view, @NonNull TextInputLayout textInputLayout) {

        this.view = view;
        this.textInputLayout = textInputLayout;
        this.validators = new ArrayList(0);
        viewSelector = new ViewSelector();
    }

    public Validate(@NonNull View view, @NonNull FormView formViewInterface) {

        this.view = view;
        this.formViewInterface = formViewInterface;
        this.validators = new ArrayList(0);
        viewSelector = new ViewSelector();
    }

    public Validate(@NonNull View view, @NonNull ValidateListener validateListener) {

        this.view = view;
        this.validators = new ArrayList(0);
        viewSelector = new ViewSelector();
        this.validateListener = validateListener;
    }

    public void addValidator(@NonNull BaseValidator validator) {

        if (validator != null) {

            validators.add(validator);
        }
    }

    @Override
    public boolean isValid() {

        for (BaseValidator validator : validators) {

            if (!validate(validator)) {

                return false;
            }
        }

        return true;
    }

    @Override
    public void closeError() {

        closeError(textInputLayout);
        closeError(formViewInterface);
    }

    @Override
    public void clearValidators() {

        validators.clear();
    }

    public static void closeError(TextInputLayout textInputLayout) {

        if (textInputLayout != null) {

            textInputLayout.setErrorEnabled(false);
            textInputLayout.setError(null);
        }
    }

    public static void closeError(FormViewInterface formViewInterface) {

        if (formViewInterface != null) {

            formViewInterface.closeError();
        }
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================

    private boolean validate(BaseValidator validator) {

        String value = viewSelector.getValue(view);

        if (validator.isValid(value)) {

            setValidField();
            return true;
        }

        setInvalidField(validator);
        return false;
    }

    private void setInvalidField(BaseValidator validator) {

        if (validateListener != null) {

            validateListener.onInvalid(this);

        } else {

            if (textInputLayout != null) {

                textInputLayout.setError(validator.getErrorMessage());
            }

            if (formViewInterface != null) {

                formViewInterface.setError(validator.getErrorMessage());
            }
        }
    }

    private void setValidField() {

        if (validateListener != null) {

            validateListener.onValid(this);

        } else {

            if (textInputLayout != null) {

                textInputLayout.setErrorEnabled(false);
                textInputLayout.setError(null);
            }

            if (formViewInterface != null) {

                formViewInterface.closeError();
            }
        }
    }
}