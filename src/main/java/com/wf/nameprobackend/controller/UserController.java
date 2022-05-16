package com.wf.nameprobackend.controller;

import com.azure.storage.blob.BlobContainerClient;
import com.wf.nameprobackend.entity.User;
import com.wf.nameprobackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private BlobController blobController;


    @GetMapping(value = "user", produces = "application/json; charset=UTF-8")
    public User getUser(@RequestParam String  uID) {
        return  iUserService.getUser(uID);
    }

    @GetMapping(value = "users", produces = "application/json; charset=UTF-8")
    public Page<User> getTopUsers() {
        Pageable top10 = PageRequest.of(0, 10);
        return iUserService.getTopUsers();
    }

    @GetMapping(value = "upload", produces = "application/json; charset=UTF-8")
    public String uploadFileToStorage(@RequestParam String uri,@RequestParam String fileName) {
        try {
            BlobContainerClient containerClient= blobController.blobControl();
            String url = blobController.uploadFile(containerClient,uri,fileName);
            //blobController.downloadBlob(containerClient,localPath,fileName);

            return url;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
