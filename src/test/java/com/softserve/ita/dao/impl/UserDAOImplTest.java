package com.softserve.ita.dao.impl;

import com.softserve.ita.dao.UserDAO;
import com.softserve.ita.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserDAOImplTest {

    @Test
    public void testGetUserById() {
        UserDAO dao = new UserDAOImpl();
        User user = new User(1,"admin","admin");
        Assert.assertEquals(user,dao.getUserById(1));
    }
}