package com.mh.notepad.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mh.notepad.AplicationData;
import com.mh.notepad.R;
import com.mh.notepad.record.RecordActivity;
import com.mh.notepad.user.RegistrationActivity;
import com.mh.notepad.user.User;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickSubbmit(View view) {
        EditText loginField = findViewById(R.id.loginField);
        EditText passwordField = findViewById(R.id.passwordField);
        String fieldRequaredError = getResources().getString(R.string.validation_field_requared);

        if (TextUtils.isEmpty(loginField.getText())) {
            loginField.setError(fieldRequaredError);
            return;
        }
        if (TextUtils.isEmpty(passwordField.getText())) {
            passwordField.setError(fieldRequaredError);
            return;
        }

        String login = loginField.getText().toString();
        String password = passwordField.getText().toString();

        try {
            User user = new LoginService().login(login, password);
            AplicationData.user= user;

            Intent intent = new Intent(this, RecordActivity.class);
            startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToRegister(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
}

