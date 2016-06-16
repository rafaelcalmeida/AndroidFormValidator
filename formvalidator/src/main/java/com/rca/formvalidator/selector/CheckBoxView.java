package com.rca.formvalidator.selector;

import android.view.View;
import android.widget.CheckBox;

import com.rca.formvalidator.interfaces.TypeInterface;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public final class CheckBoxView implements TypeInterface {

    @Override
    public boolean isTypeView(View view) {

        return (view instanceof CheckBox);
    }

    @Override
    public String getValue(View view) {

        return String.valueOf(((CheckBox) view).isChecked());
    }
}
