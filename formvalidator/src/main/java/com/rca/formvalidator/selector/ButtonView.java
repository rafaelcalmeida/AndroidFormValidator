package com.rca.formvalidator.selector;

import android.view.View;
import android.widget.Button;

import com.rca.formvalidator.interfaces.TypeInterface;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public final class ButtonView implements TypeInterface {

    @Override
    public boolean isTypeView(View view) {

        return (view instanceof Button);
    }

    @Override
    public String getValue(View view) {

        return ((Button) view).getText().toString();
    }
}
