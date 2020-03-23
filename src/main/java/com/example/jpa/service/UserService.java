package com.example.jpa.service;

import com.example.jpa.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity findById(String id);

    List<UserEntity> findAll();

    void save(UserEntity userEntity);
}
