package com.mh.notepad.login;

import com.mh.notepad.user.User;
import com.mh.notepad.user.UserDAO;

public class LoginService {

    UserDAO userDAO = new UserDAO();

    String login(String login, String password) throws Exception {
        User user = userDAO.getUserByLogin(login);
        if (user == null || !user.getPassword().equals(password)) {
            throw new Exception("eexg");
        }
        return user.getName();
    }
}
