package com.bci.gestionusuarios.controller;

import com.bci.gestionusuarios.dto.UserDto;
import com.bci.gestionusuarios.dto.UserMapper;
import com.bci.gestionusuarios.entity.UserEntity;
import com.bci.gestionusuarios.exception.InvalidEmailFormatException;
import com.bci.gestionusuarios.exception.UserNotFoundException;
import com.bci.gestionusuarios.service.UserService;
import com.bci.gestionusuarios.service.impl.TokenServiceImpl;
import com.bci.gestionusuarios.util.Validation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private TokenServiceImpl tokenService;

    @PostMapping("/sign-up")
    public UserDto signUp(@RequestBody UserDto user) {
        if(!Validation.isEmailValid(user.getEmail())){
            throw new InvalidEmailFormatException("User", "email", user.getEmail());
        }

        if(!Validation.isPasswordValid(user.getPassword())){
            throw new InvalidEmailFormatException("User", "password", user.getPassword());
        }

        //TODO 1 Usuario.getEmail usuario ya existe?

        //TODO 2 si no existe crearlo
        UserEntity newUser = userService.createUser(UserMapper.toEntity(user));

        return UserMapper.toDto(newUser, tokenService.toToken(newUser));
    }

    @GetMapping("/login")
    public UserDto login(Principal principal) {
        Optional<UserEntity> userOptional = userService.getUserById(UUID.fromString(principal.getName()));
        if (userOptional.isPresent()){
            return UserMapper.toDto(userOptional.get(), tokenService.toToken(userOptional.get()));
        }else {
            throw new UserNotFoundException("User", "ID", principal.getName());
        }
    }

}
