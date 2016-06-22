package com.rca.sample;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.rca.formvalidator.Form;
import com.rca.formvalidator.FormView;
import com.rca.formvalidator.Validate;
import com.rca.formvalidator.validator.CheckBoxValidator;
import com.rca.formvalidator.validator.EmailValidator;
import com.rca.formvalidator.validator.NotEmptyValidator;

/**
 * Created by Rafael C. Almeida on 15/06/16.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Form form;

    // Views
    private EditText etName;
    private TextInputLayout ilContentName;
    private Button btStart;
    private Button btClear;
    private EditText etEmail;
    private TextInputLayout ilContentEmail;
    private EditText etSurname;
    private FormView fvContetSurname;
    private FormView fvContentExample;
    private CheckBox cbExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setScreenComponents();
        setListeners();
        setValidation();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_start:

                start();
                break;

            case R.id.bt_clear:

                clearForm();
                break;
        }
    }

    //==============================================================================================
    // Métodos Privados
    //==============================================================================================

    private void clearForm() {

        form.closeAllErrors();
    }

    private void start() {

        if (form.validate()) {

            Toast.makeText(this, "Formulário é válido", Toast.LENGTH_LONG).show();
        }
    }

    private void setScreenComponents() {

        btClear = (Button) findViewById(R.id.bt_clear);
        btStart = (Button) findViewById(R.id.bt_start);
        etName = (EditText) findViewById(R.id.et_name);
        ilContentName = (TextInputLayout) findViewById(R.id.il_content_name);
        etSurname = (EditText) findViewById(R.id.et_surname);
        fvContetSurname = (FormView) findViewById(R.id.fv_content_surname);
        etEmail = (EditText) findViewById(R.id.et_email);
        ilContentEmail = (TextInputLayout) findViewById(R.id.il_content_email);
        fvContentExample = (FormView) findViewById(R.id.fv_content_example);
        cbExample = (CheckBox) findViewById(R.id.cb_example);
    }

    private void setListeners() {

        btStart.setOnClickListener(this);
        btClear.setOnClickListener(this);
    }

    private void setValidation() {

        form = new Form();

        // Validates
        Validate nameValidate = new Validate(etName, ilContentName);
        nameValidate.addValidator(new NotEmptyValidator(this, R.string.err_empty));
        etName.setOnFocusChangeListener(new OnFocusValidationListener(nameValidate));

        Validate surNameValidate = new Validate(etSurname, fvContetSurname);
        surNameValidate.addValidator(new NotEmptyValidator(this, R.string.err_empty));
        etSurname.setOnFocusChangeListener(new OnFocusValidationListener(surNameValidate));

        Validate emailValidate = new Validate(etEmail, ilContentEmail);
        emailValidate.addValidator(new NotEmptyValidator(this, R.string.err_empty));
        emailValidate.addValidator(new EmailValidator(this, R.string.err_email_invalid_format));
        etEmail.setOnFocusChangeListener(new OnFocusValidationListener(emailValidate));

        Validate checkBoxValidate = new Validate(cbExample, fvContentExample);
        checkBoxValidate.addValidator(new CheckBoxValidator(this, R.string.required_field));

        form.addValidate(nameValidate);
        form.addValidate(surNameValidate);
        form.addValidate(emailValidate);
        form.addValidate(checkBoxValidate);
    }
}
