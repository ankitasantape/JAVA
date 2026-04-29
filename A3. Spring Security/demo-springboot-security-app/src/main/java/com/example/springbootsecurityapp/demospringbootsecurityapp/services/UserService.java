package com.example.springbootsecurityapp.demospringbootsecurityapp.services;

import com.example.springbootsecurityapp.demospringbootsecurityapp.dto.LoginDTO;
import com.example.springbootsecurityapp.demospringbootsecurityapp.dto.SignUpDTO;
import com.example.springbootsecurityapp.demospringbootsecurityapp.dto.UserDTO;
import com.example.springbootsecurityapp.demospringbootsecurityapp.entities.User;
import com.example.springbootsecurityapp.demospringbootsecurityapp.entities.enums.Permission;
import com.example.springbootsecurityapp.demospringbootsecurityapp.entities.enums.Role;
import com.example.springbootsecurityapp.demospringbootsecurityapp.exceptions.ResourceNotFoundException;
import com.example.springbootsecurityapp.demospringbootsecurityapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AbstractUserDetailsReactiveAuthenticationManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() ->
                        new BadCredentialsException("User not found with email: "
                                + username));
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: "
                        + userId));
    }

    public User getUserByEmail(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElse(null);
    }

    public UserDTO signUp(SignUpDTO signUpDTO) {
        Optional<User> user = userRepository.findByEmail(signUpDTO.getEmail());
        if(user.isPresent()){
            throw new BadCredentialsException("User already exists with email: " +
                    signUpDTO.getEmail());
        }

        User toBeCreatedUser = modelMapper.map(signUpDTO, User.class);
        toBeCreatedUser.setPassword(passwordEncoder.encode(toBeCreatedUser.getPassword()));

        User savedUser = userRepository.save(toBeCreatedUser);
        return modelMapper.map(savedUser, UserDTO.class);

    }

    public User save(User newUser){
        return userRepository.save(newUser);
    }

}
