package com.bci.gestionusuarios.service;

import com.bci.gestionusuarios.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserEntity createUser(UserEntity user);
    Optional<UserEntity> getUserById(UUID id);
    Optional<UserEntity> getUserByName(String email);
    Optional<UserEntity> getUserByEmail(String email);
    UserEntity updateUser(UserEntity user);
}
