package com.devin.service.Impl;

import com.devin.dao.UserMapper;
import com.devin.domain.User;
import com.devin.service.UserService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User findUser(Long id) {
        User user = userMapper.findUser(id);
        return user;
    }

    public void changeName(String username) {
        userMapper.changeName(username);
//        int a = 1/0;     测试事务管理是否起作用
    }
}
