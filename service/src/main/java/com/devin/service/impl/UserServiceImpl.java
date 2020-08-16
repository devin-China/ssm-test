package com.devin.service.impl;

import com.devin.dao.UserMapper;
import com.devin.domain.User;
import com.devin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User findUser(Long id) {
        User user = userMapper.findUser(id);
        return user;
    }
}
