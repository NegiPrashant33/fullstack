package com.prashant.service;

import com.prashant.model.User;

public interface UserService {
    public User findUserById(Long userId) throws Exception;
}
