package com.sha.microserviceusermanagement.service;

import com.sha.microserviceusermanagement.model.User;
import com.sha.microserviceusermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired // Dependency Injection
    private UserRepository userRepository;

    // To use this, we should create a bean
    @Autowired
    private PasswordEncoder passwordEncoder; // This is for to encode the user's password

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username).orElse( null);
    }

    @Override
    public List<String> findUsers(List<Long> idList) {
        return userRepository.findByIdList(idList);
    }

}
