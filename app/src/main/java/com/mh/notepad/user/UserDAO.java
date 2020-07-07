package com.mh.notepad.user;

import java.time.LocalDate;
import java.util.HashMap;

public class UserDAO {

    private HashMap<String, User> users = new HashMap<>();
    private String login;
    private String password;

    {
        try {
            createUser("Rio", "123", "Sara");
            createUser("Rob", "54", "jTp");
            createUser("Tim", "13", "Tom");
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    public void createUser(String login, String password, String name) throws UserException {
        if (getUserByLogin(login) != null) {
            throw new UserException("Error");
        }
        User user = new User();
        user.setId(users.size() + 1);
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setRegistrationDate(LocalDate.now());
        users.put(login, user);
    }

    public User getUserByLogin(String login) {
        return users.get(login);
    }

    public void updateUser(String login, String password, String name) {
        User user = getUserByLogin(login);
        user.setPassword(password);
        user.setName(name);
    }
}
