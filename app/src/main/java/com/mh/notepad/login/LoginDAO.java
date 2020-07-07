package com.mh.notepad.login;

public class LoginDAO {

    boolean login(String login, String password) {
        String rightLogin = "Rio";
        String rightPassword = "123";
        return (rightLogin.equals(login) && rightPassword.equals(password));
    }
}
