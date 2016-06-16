package com.rca.formvalidator.selector;

import android.view.View;
import android.widget.Spinner;

import com.rca.formvalidator.interfaces.TypeInterface;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public class SpinnerView implements TypeInterface {

    @Override
    public boolean isTypeView(View view) {

        return (view instanceof Spinner);
    }

    @Override
    public String getValue(View view) {

        return String.valueOf(((Spinner) view).getSelectedItemPosition());
    }
}
