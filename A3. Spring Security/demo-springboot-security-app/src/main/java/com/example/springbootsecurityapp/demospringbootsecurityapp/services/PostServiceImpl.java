package com.example.springbootsecurityapp.demospringbootsecurityapp.services;

import com.example.springbootsecurityapp.demospringbootsecurityapp.dto.PostDTO;
import com.example.springbootsecurityapp.demospringbootsecurityapp.entities.PostEntity;
import com.example.springbootsecurityapp.demospringbootsecurityapp.entities.User;
import com.example.springbootsecurityapp.demospringbootsecurityapp.exceptions.ResourceNotFoundException;
import com.example.springbootsecurityapp.demospringbootsecurityapp.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public PostDTO getPostById(Long postId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        log.info("user {}", user);

        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));
        return modelMapper.map(postEntity, PostDTO.class);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        postEntity.setAuthor(user);
        PostEntity saved = postRepository.save(postEntity);
        PostDTO postDTO = modelMapper.map(saved, PostDTO.class);
        return postDTO;

    }

}
