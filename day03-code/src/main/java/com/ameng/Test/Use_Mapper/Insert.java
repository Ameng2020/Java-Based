package com.ameng.Test.Use_Mapper;


import com.ameng.entity.User;
import com.ameng.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @program: Java-Basic
 * @description: mapper操作
 * @author: Ameng
 * @create: 2020-11-10
 **/

public class Insert {

    @Autowired
    UserMapper userMapper;


    public static void main(String[] args) {

    }


    public void select(){
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
}
