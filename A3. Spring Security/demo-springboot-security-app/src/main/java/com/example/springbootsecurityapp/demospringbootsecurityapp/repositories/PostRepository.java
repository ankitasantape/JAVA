package com.example.springbootsecurityapp.demospringbootsecurityapp.repositories;


import com.example.springbootsecurityapp.demospringbootsecurityapp.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
