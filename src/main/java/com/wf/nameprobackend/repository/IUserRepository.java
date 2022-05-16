package com.wf.nameprobackend.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.wf.nameprobackend.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CosmosRepository<User, String> {
    User findUserByUserIDContaining(String userId);
}
