package com.example.android.mobilelab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private final EmailValidator emailValidator = new EmailValidator();
    private final PasswordValidator passwordValidator = new PasswordValidator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);


        final EditText email = findViewById(R.id.sign_in_email);
        final EditText password = findViewById(R.id.sign_in_password);
        final Button button = findViewById(R.id.sign_in);
        final TextView textView = findViewById(R.id.textView);
        final TextInputLayout textInputLayoutEmail = findViewById(R.id.sign_in_text_input_email);
        final TextInputLayout textInputLayoutPassword = findViewById(R.id.sign_in_text_input_password);


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
            if (isAllCorrect) {
                textInputLayoutEmail.setError(null);
                textInputLayoutPassword.setError(null);
                showToast("All fields are validated");
            }
        });

        textView.setOnClickListener(v -> {
            startActivity(new Intent(this, SignUpActivity.class));
        });

    }

    public void showToast(String message) {
        Toast toast = Toast.makeText(getApplicationContext(),
                message,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
