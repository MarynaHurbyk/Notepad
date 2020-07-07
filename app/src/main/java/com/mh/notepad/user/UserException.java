package com.mh.notepad.user;

import com.mh.notepad.R;

public class UserException extends  Exception{

    public static final int USER_EXIST_EXCEPTOIN = R.string.user_exist_excaption;

    public UserException(String message) {
        super(message);
    }
}
