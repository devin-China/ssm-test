package com.devin.service.impl;

import com.devin.dao.UserMapper;
import com.devin.domain.User;
import com.devin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Override
    public User findUser(Long id) {
        User user = userMapper.findUser(id);
        return user;
    }
}
