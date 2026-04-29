package com.example.springbootsecurityapp.demospringbootsecurityapp.repositories;

import com.example.springbootsecurityapp.demospringbootsecurityapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
