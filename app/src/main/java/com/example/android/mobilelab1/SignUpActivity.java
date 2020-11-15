package com.example.android.mobilelab1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUpActivity extends AppCompatActivity {

    private final EmailValidator emailValidator = new EmailValidator();
    private final PasswordValidator passwordValidator = new PasswordValidator();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText email = findViewById(R.id.email);
        final EditText name = findViewById(R.id.name);
        final EditText password = findViewById(R.id.password);
        final EditText confirmPassword = findViewById(R.id.confirm_password);

        final TextInputLayout textInputLayoutName = findViewById(R.id.sign_up_text_input_name);
        final TextInputLayout textInputLayoutEmail = findViewById(R.id.sign_up_text_input_email);
        final TextInputLayout textInputLayoutPassword = findViewById(R.id.sign_up_text_input_password);
        final TextInputLayout textInputLayoutConfirmPassword = findViewById(R.id.sign_up_text_input_confirm_password);

        final Button button = findViewById(R.id.sign_up);


        Toolbar toolbar = findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button.setOnClickListener(v -> {
            boolean isAllCorrect = true;

            if (!emailValidator.validate(email.getText().toString())) {
                isAllCorrect = false;
                textInputLayoutEmail.setError("Email format is not correct");
            }
            if (!passwordValidator.validate(password.getText().toString())) {
                isAllCorrect = false;
                textInputLayoutPassword.setError("Password format is not correct");
            }
            if (!passwordValidator.validate(confirmPassword.getText().toString())) {
                isAllCorrect = false;
                textInputLayoutConfirmPassword.setError("Password format is not correct");
            }
            if (name.getText().toString().isEmpty()) {
                isAllCorrect = false;
                textInputLayoutName.setError("Name format is not correct");

            }

            if (isAllCorrect) {
                if (password.getText().toString().equals(confirmPassword.getText().toString())) {
                    textInputLayoutEmail.setError(null);
                    textInputLayoutPassword.setError(null);
                    textInputLayoutName.setError(null);
                    textInputLayoutConfirmPassword.setError(null);
                    showToast("All fields are validated");
                } else {
                    textInputLayoutConfirmPassword.setError("is not correct");
                    showToast("Passwords is not equals");
                }
            }
        });
    }

    private void showToast(String message) {
        Toast toast = Toast.makeText(getApplicationContext(),
                message,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (android.R.id.home == id) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
