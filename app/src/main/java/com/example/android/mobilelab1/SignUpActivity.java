package com.example.android.mobilelab1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText email = findViewById(R.id.email);
        final EditText name = findViewById(R.id.name);
        final EditText password = findViewById(R.id.password);
        final EditText confirmPassword = findViewById(R.id.confirm_password);

        Toolbar toolbar = findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Button button = findViewById(R.id.sign_up);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
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
                if (!new PasswordValidator().test(confirmPassword.getText().toString())) {
                    isAllCorrect = false;
                    confirmPassword.setError("Password format is not correct");
                }
                if (name.getText().toString().isEmpty()) {
                    isAllCorrect = false;
                    name.setError("Name format is not correct");
                }

                if (isAllCorrect) {
                    if (password.getText().toString().equals(confirmPassword.getText().toString())) {
                        showToast("All fields are validated");
                    } else {
                        confirmPassword.setError("is not correct");
                        showToast("Passwords is not equals");
                    }
                }
            }
        });
    }

    public void showToast(String s) {
        Toast toast = Toast.makeText(getApplicationContext(),
                s,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (android.R.id.home == id){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
