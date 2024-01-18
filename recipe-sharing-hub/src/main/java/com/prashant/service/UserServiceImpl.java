package com.prashant.service;

import com.prashant.model.User;
import com.prashant.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User findUserById(Long userId) throws Exception {
        Optional<User> opt = userRepository.findById(userId);
        if(opt.isPresent())
            return opt.get();

        throw new Exception("User not found with id: " + userId);
    }
}
