package com.rca.formvalidator.interfaces;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public interface ValidateInterface {

    boolean isValid();

    void closeError();

    void clearValidators();
}
