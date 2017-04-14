package com.mybatis.dao.impl;

import com.mybatis.dao.UserDao;
import com.mybatis.data.generator.User;
import com.mybatis.data.generator.UserExample;
import com.mybatis.data.generator.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xionggp on 17/4/14.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByName(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public boolean insert(User user) {
        try {
            userMapper.insert(user);
            return true;
        } catch (Exception e) {
            LOG.error("addUser", e);
        }

        return false;
    }

    @Override
    public boolean updateUser(User user) {
        try {
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUsernameEqualTo(user.getUsername());
            userMapper.updateByExampleSelective(user, userExample);
            return true;
        } catch (Exception e) {
            LOG.error("updateUser", e);
        }

        return false;
    }
}
