package com.prashant.controller;

import com.prashant.model.User;
import com.prashant.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserRepository userRepository;

    // Constructor dependency injection
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getallUsers()  {
        List<User> users = userRepository.findAll();
        return users;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) throws Exception {
        User isExist = userRepository.findByEmail(user.getEmail());
        if(isExist != null)
            throw new Exception("User already exist with this email " + user.getEmail());

        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
        return "User deleted successfully";
    }
}
