package com.rca.formvalidator.selector;

import android.view.View;
import android.widget.EditText;

import com.rca.formvalidator.interfaces.TypeInterface;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public class EditTextView implements TypeInterface {

    @Override
    public boolean isTypeView(View view) {

        return (view instanceof EditText);
    }

    @Override
    public String getValue(View view) {

        return ((EditText) view).getText().toString();
    }
}
