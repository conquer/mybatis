package com.mybatis.dao;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.data.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xionggp on 17/3/31.
 */
@Repository
public interface UserDao extends BaseSimpleDao {

    void addUser(JSONObject user);

    void updateUser(JSONObject user);

    List<User> getUserByName(String username);
}
