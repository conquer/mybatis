package com.mybatis.dao;

import com.mybatis.data.generator.User;

import java.util.List;

/**
 * Created by xionggp on 17/4/14.
 */
public interface UserDao {

    List<User> getUserByName(String username);

    boolean insert(User user);

    boolean updateUser(User user);
}
