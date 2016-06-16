package com.rca.formvalidator.selector;

import android.support.annotation.NonNull;
import android.view.View;

import com.rca.formvalidator.interfaces.TypeInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public final class ViewSelector {

    private static List<TypeInterface> typeInterfaceList;

    public ViewSelector() {

        if (typeInterfaceList == null) {

            setupItems();
        }
    }

    public String getValue(View view) {

        for (TypeInterface typeInterface : typeInterfaceList) {

            if (typeInterface.isTypeView(view)) {

                return typeInterface.getValue(view);
            }
        }

        launchInvalidViewException(view);
        return null;
    }

    public void addTypeView(@NonNull TypeInterface typeInterface) {

        if (typeInterface != null) {

            typeInterfaceList.add(typeInterface);
        }
    }

    public void removeTypeView(@NonNull TypeInterface typeInterface) {

        typeInterfaceList.remove(typeInterface);
    }

    public void removeTypeView(int position) {

        if (!typeInterfaceList.isEmpty()) {

            int pos = (position < 0) ? 0 : position >= typeInterfaceList.size() ? (position - 1) : position;
            typeInterfaceList.remove(pos);
        }
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================

    private void setupItems() {

        typeInterfaceList = new ArrayList(0);

        typeInterfaceList.add(new EditTextView());
        typeInterfaceList.add(new CheckBoxView());
        typeInterfaceList.add(new RadioGroupView());
        typeInterfaceList.add(new SpinnerView());
        typeInterfaceList.add(new ButtonView());
    }

    private void launchInvalidViewException(View view) {

        String sView = "View " + view == null ? "" : view.getClass() + ")";
        throw new RuntimeException(sView + ", Verifique como implementar a validação para views customizadas!");
    }
}
