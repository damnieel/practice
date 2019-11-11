package com.cvc.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvc.springboot.domain.User;
import com.cvc.springboot.mapper.UserMapper;
import com.cvc.springboot.service.UserService;

@Service
public class UserImpl implements UserService{

	@Autowired
    private UserMapper userMapper;

	@Override
	public User findUser() {
		return userMapper.getOne(1l);
	}
	

}
