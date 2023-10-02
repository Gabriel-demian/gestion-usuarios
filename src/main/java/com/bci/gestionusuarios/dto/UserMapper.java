package com.bci.gestionusuarios.dto;

import com.bci.gestionusuarios.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserMapper {

    public static UserDto toDto(UserEntity user, String token){
        return UserDto.builder()
                .id(UUID.fromString(user.getId()))
                .created(user.getCreated())
                .lastLogin(LocalDateTime.now())
                .token(token)
                .isActive(user.isActive())
                .build();
    }

    public static UserEntity toEntity(UserDto dto){
        return UserEntity.builder()
                .id(String.valueOf(dto.getId()))
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .created(dto.getCreated())
                .lastLogin(dto.getLastLogin())
                .isActive(dto.isActive())
                .build();
    }

}
