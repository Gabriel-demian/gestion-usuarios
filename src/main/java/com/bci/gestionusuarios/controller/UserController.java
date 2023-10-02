package com.bci.gestionusuarios.controller;

import com.bci.gestionusuarios.dto.UserDto;
import com.bci.gestionusuarios.dto.UserMapper;
import com.bci.gestionusuarios.entity.UserEntity;
import com.bci.gestionusuarios.service.UserService;
import com.bci.gestionusuarios.service.impl.TokenServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private TokenServiceImpl tokenService;

    @PostMapping("/sign-up")
    public UserDto signUp(@RequestBody UserDto user) {

        String token = "";
        //TODO 1 Usuario.getEmail usuario ya existe?

        //TODO 2 si no existe crearlo
        UserEntity newUser = userService.createUser(UserMapper.toEntity(user));

        return UserMapper.toDto(newUser, tokenService.toToken(newUser));
    }

    @GetMapping("/login")
    public UserDto login(Principal principal) {
        UserEntity user = userService.getUserById(UUID.fromString(principal.getName())).get();
        //TODO cargar atri

        return UserMapper.toDto(user, tokenService.toToken(user));
    }

}
