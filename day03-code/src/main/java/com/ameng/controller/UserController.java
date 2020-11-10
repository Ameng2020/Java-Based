package com.ameng.controller;


import com.ameng.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ameng
 * @since 2020-11-10
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;


}
