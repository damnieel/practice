package com.cvc.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.cvc.common.domain.User;
import com.cvc.common.service.UserService;
import com.cvc.provider.mapper.UserMapper;

@Service(version = "1.0.0")
public class UserImpl implements UserService{
	@Autowired
    private UserMapper userMapper;

    @Override
    public User findUser() {
        return userMapper.getOne(1l);
    }
}
