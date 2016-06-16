package com.rca.formvalidator.interfaces;

import com.rca.formvalidator.Validate;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public interface ValidateListener {

    void onValid(Validate validate);

    void onInvalid(Validate validate);
}