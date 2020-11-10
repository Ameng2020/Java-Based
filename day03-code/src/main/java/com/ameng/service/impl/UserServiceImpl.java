package com.ameng.service.impl;

import com.ameng.entity.User;
import com.ameng.mapper.UserMapper;
import com.ameng.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ameng
 * @since 2020-11-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
