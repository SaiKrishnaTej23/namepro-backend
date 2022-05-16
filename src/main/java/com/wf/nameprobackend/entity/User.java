package com.wf.nameprobackend.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Container(containerName = "NameUsers")
public class User {
    @Id
    private String id;
    private String userID;
    @PartitionKey
    private String legalFirstName;
    private String legalLastName;
    private String PreferredName;
    private String Phonetics;
    private String Pronunciation;
}
