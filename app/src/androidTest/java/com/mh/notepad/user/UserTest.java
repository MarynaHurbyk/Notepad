package com.mh.notepad.user;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class UserTest {
    private String rightLogin = "Rio";
    private String rightPassword = "123";
    private String incorrectLogin = "Ridfs";
    private String incorrectPassword = "1223";
    private UserDAO userDAO = new UserDAO();
    private String newPassword = "444";
    private String newName = "www";
    private String oldName = "Sara";

    @Test
    public void checkIfUserExists() {
        User user = userDAO.getUserByLogin(rightLogin);
        assertNotNull(user);
    }

    @Test
    public void checkIfUserNotExists() {
        User user = userDAO.getUserByLogin(incorrectLogin);
        assertEquals(null, user);
    }

    @Test
    public void checkIfRightPassword() {
        User user = userDAO.getUserByLogin(rightLogin);
        assertEquals(rightPassword, user.getPassword());
    }

    @Test(expected = UserException.class)
    public void createExistingUser() throws UserException {
        userDAO.createUser("Rio", "123", "Sara");
    }

    @Test
    public void updateUser() {
        User user = userDAO.getUserByLogin(rightLogin);
        assertEquals(rightPassword, user.getPassword());
        assertEquals(oldName, user.getName());

        userDAO.updateUser(rightLogin, newPassword, newName);
        assertEquals(newPassword, user.getPassword());
        assertEquals(newName, user.getName());
    }

}











