package com.mybatis.service;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.dao.UserDao;
import com.mybatis.dao.impl.UserDaoImpl;
import com.mybatis.data.generator.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xionggp on 17/4/1.
 */
@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public boolean addUser(JSONObject user) {
        return userDao.insert(getUser(user));
    }

    public List<User> getUsers(String username) {
        return userDao.getUserByName(username);
    }

    public boolean updateUser(JSONObject user) {
        return userDao.updateUser(getUser(user));
    }

    public User getUser(JSONObject data) {
        User user = new User();
        user.setUsername(data.getString("username"));
        user.setPassword(data.getString("password"));
        user.setAddress(data.getString("address"));
        user.setCardId(data.getString("cardId"));
        user.setEducation(data.getString("education"));
        user.setGender(data.getString("gender"));
        return user;
    }

}
