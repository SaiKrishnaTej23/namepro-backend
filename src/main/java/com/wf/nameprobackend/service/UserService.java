package com.wf.nameprobackend.service;


import com.wf.nameprobackend.entity.User;
import com.wf.nameprobackend.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User getUser(String userId) {
        return userRepository.findUserByUserIDContaining(userId);
    }

    @Override
    public Page<User> getTopUsers() {
        return userRepository.findAll(PageRequest.of(0,10));
    }
}
