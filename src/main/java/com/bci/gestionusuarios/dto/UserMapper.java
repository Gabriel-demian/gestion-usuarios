package com.bci.gestionusuarios.dto;

import com.bci.gestionusuarios.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserMapper {

    public static UserDto toDto(UserEntity user, String token){
        return UserDto.builder()
                .id(UUID.fromString(user.getId()))
                .created(user.getCreated())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .lastLogin(LocalDateTime.now())
                .token(token)
                .isActive(user.isActive())
                .phones(user.getPhones())
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
                .phones(dto.getPhones())
                .build();
    }

    public static ResponseDto toResponse(UserEntity userDto, String token){
        return ResponseDto.builder()
                .id(UUID.fromString(userDto.getId()))
                .created(userDto.getCreated())
                .lastLogin(userDto.getLastLogin())
                .token(token)
                .isActive(userDto.isActive())
                .build();
    }

}
