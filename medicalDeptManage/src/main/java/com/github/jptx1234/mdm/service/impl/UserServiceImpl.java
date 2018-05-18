package com.github.jptx1234.mdm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jptx1234.mdm.dao.UserMapper;
import com.github.jptx1234.mdm.model.User;

@Service("userService")
public class UserServiceImpl implements com.github.jptx1234.mdm.service.UserService {

	private UserMapper userMapper;
	
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


	/**
	 * 根据ID查询
	 */
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

}
