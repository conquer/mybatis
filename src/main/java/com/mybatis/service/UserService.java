package com.mybatis.service;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.dao.UserDao;
import com.mybatis.data.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xionggp on 17/4/1.
 */
@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean addUser(JSONObject user) {
        try {
            userDao.addUser(user);
            return true;
        } catch (Exception e) {
            LOG.error("addUser", e);
        }

        return false;
    }

    public List<User> getUsers(String username) {
        return userDao.getUserByName(username);
    }

    public boolean updateUser(JSONObject user) {
        try {
            userDao.updateUser(user);
            return true;
        } catch (Exception e) {
            LOG.error("updateUser", e);
        }

        return false;
    }

}
