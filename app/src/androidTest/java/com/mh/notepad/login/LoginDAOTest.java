package com.mh.notepad.login;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class LoginDAOTest {
    private String rightLogin = "Rio";
    private String rightPassword = "123";
    private String incorrectLogin = "Ridfs";
    private String incorrectPassword = "1223";

    @Test
    public void checkRightLogin() {
        boolean isValidLogin= new LoginDAO().login(rightLogin,rightPassword);
        assertEquals(true, isValidLogin);
    }

    @Test
    public void checkIncorrectLogin() {
        boolean isValidWithIncorrectrLogin= new LoginDAO().login(incorrectLogin,rightPassword);
        boolean isValidWithIncorrectrPassword= new LoginDAO().login(rightLogin,incorrectPassword);
        boolean isValidLogin= new LoginDAO().login(incorrectLogin,incorrectPassword);
        assertEquals(false, isValidWithIncorrectrLogin);
        assertEquals(false, isValidWithIncorrectrPassword);
        assertEquals(false, isValidLogin);
    }
}
