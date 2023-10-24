package com.bci.gestionusuarios.repository;

import com.bci.gestionusuarios.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);
    Optional<UserEntity> findByName(String name);
}
