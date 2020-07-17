package com.mh.notepad.user;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.mh.notepad.R;
import com.mh.notepad.login.LoginActivity;
import com.mh.notepad.login.LoginService;


public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.registration_title));

    }

    public void onRegisterUser(View view) {
        EditText loginField = findViewById(R.id.loginField);
        EditText passwordField = findViewById(R.id.passwordField);
        EditText nameField = findViewById(R.id.nameField);
        String fieldRequaredError = getResources().getString(R.string.validation_field_requared);
        String fieldLengthError = getResources().getString(R.string.validation_field_length);

        if (TextUtils.isEmpty(loginField.getText())) {
            loginField.setError(fieldRequaredError);
            return;
        }
        if (TextUtils.isEmpty(passwordField.getText())) {
            passwordField.setError(fieldRequaredError);
            return;
        }

        if(passwordField.getText().toString().trim().length()<4){
            passwordField.setError(fieldLengthError);
            return;
        }

        if (TextUtils.isEmpty(nameField.getText())) {
            nameField.setError(fieldRequaredError);
            return;
        }

        String login = loginField.getText().toString();
        String password = passwordField.getText().toString();
        String name = nameField.getText().toString();

        try {
            new LoginService().register(login,password,name);

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
