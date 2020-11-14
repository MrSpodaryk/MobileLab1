package com.example.android.mobilelab1;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

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
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean isAllCorrect = true;

                if (!new EmailValidator().test(email.getText().toString())) {
                    isAllCorrect = false;
                    email.setError("Email format is not correct");
                }
                if (!new PasswordValidator().test(password.getText().toString())) {
                    isAllCorrect = false;
                    password.setError("Password format is not correct");
                }
                if (isAllCorrect) {
                    showToast();
                }
            }
        });

    }

    public void showToast() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "All fields are validated",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void startSignUpActivity(View v) {
        startActivity(new Intent(this, SignUpActivity.class));
    }
}
