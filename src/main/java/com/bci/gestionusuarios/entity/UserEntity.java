package com.bci.gestionusuarios.entity;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class UserEntity {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime created;
    private LocalDateTime lastLogin;
    private boolean isActive;
    @ElementCollection
    private List<Phone> phones;

}
