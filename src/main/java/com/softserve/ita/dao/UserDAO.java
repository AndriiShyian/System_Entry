package com.softserve.ita.dao;

import com.softserve.ita.model.User;

public interface UserDAO {
    User getUserById(int id);
    boolean getUserByLoginAndPassword(String login, String password);
    boolean registerUser(String login, String password, String repeatedPassword);
}
