package com.wf.nameprobackend.service;

import com.wf.nameprobackend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface IUserService {
    User getUser(String userId);
    Page<User> getTopUsers();

}
