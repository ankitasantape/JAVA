package com.example.springbootsecurityapp.demospringbootsecurityapp.utils;

import com.example.springbootsecurityapp.demospringbootsecurityapp.dto.PostDTO;
import com.example.springbootsecurityapp.demospringbootsecurityapp.entities.User;
import com.example.springbootsecurityapp.demospringbootsecurityapp.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostSecurity {

    private final PostService postService;

    public boolean isOwnerOfPost(Long postId){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PostDTO post = postService.getPostById(postId);
        return post.getAuthor().getId().equals(user.getId());


    }
}
