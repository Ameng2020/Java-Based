package com.ameng.Test.Use_Mapper;


import com.ameng.entity.User;
import com.ameng.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @program: Java-Basic
 * @description: mapper操作
 * @author: Ameng
 * @create: 2020-11-10
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void Insert(){

        User user = new User();
        user.setName("王三");
        user.setAge(25);
        user.setEmail("wangsan@163.com");
        //返回的是一个影响数
        int rows = userMapper.insert(user);
        System.out.println("影响数："+rows);
    }
}
