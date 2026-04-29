package com.example.springbootsecurityapp.demospringbootsecurityapp.services;

import com.example.springbootsecurityapp.demospringbootsecurityapp.dto.PostDTO;

import java.util.List;

public interface PostService {
    public PostDTO getPostById(Long postId);
    public PostDTO createNewPost(PostDTO inputPost);
    public List<PostDTO> getAllPosts();
}
