package com.wf.nameprobackend.controller;

import com.wf.nameprobackend.entity.User;
import com.wf.nameprobackend.repository.IUserRepository;
import com.wf.nameprobackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/")
public class UserController {

    @Autowired
    private IUserService iUserService;


    @GetMapping(value = "user", produces = "application/json; charset=UTF-8")
    public User getUser(@RequestParam String  uID) {
     return  iUserService.getUser(uID);
    }

    @GetMapping(value = "users", produces = "application/json; charset=UTF-8")
    public Page<User> getTopUsers() {
        Pageable top10 = PageRequest.of(0, 10);
        return iUserService.getTopUsers();
    }

}
