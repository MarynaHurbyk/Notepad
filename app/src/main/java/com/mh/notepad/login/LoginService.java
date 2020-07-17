package com.mh.notepad.login;

import android.widget.Toast;

import androidx.annotation.StringRes;

import com.mh.notepad.R;
import com.mh.notepad.record.Record;
import com.mh.notepad.record.RecordDAO;
import com.mh.notepad.user.User;
import com.mh.notepad.user.UserDAO;
import com.mh.notepad.user.UserException;

import java.util.ArrayList;

public class LoginService {

    UserDAO userDAO = new UserDAO();
    String dataException = "Error";

    User login(String login, String password) throws Exception {
        User user = userDAO.getUserByLogin(login);
        if (user == null || !user.getPassword().equals(password)) {
            throw new Exception(dataException);

        }
        return user;
    }

   public void register(String login, String password, String name) throws UserException {
        userDAO.createUser(login,password,name);
        ArrayList<Record> recordsList = new ArrayList();
        new RecordDAO().records.put(login,recordsList);
    }

}
