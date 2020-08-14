package com.devin.service;

import com.devin.domain.User;

public interface UserService {
    public User findUser(Long id);
    public void changeName(String username);
}
