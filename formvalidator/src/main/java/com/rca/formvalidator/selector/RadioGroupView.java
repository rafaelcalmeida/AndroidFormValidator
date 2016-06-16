package com.rca.formvalidator.selector;

import android.view.View;
import android.widget.RadioGroup;

import com.rca.formvalidator.interfaces.TypeInterface;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public final class RadioGroupView implements TypeInterface {

    @Override
    public boolean isTypeView(View view) {

        return (view instanceof RadioGroup);
    }

    @Override
    public String getValue(View view) {

        return String.valueOf(((RadioGroup) view).getCheckedRadioButtonId());
    }
}
