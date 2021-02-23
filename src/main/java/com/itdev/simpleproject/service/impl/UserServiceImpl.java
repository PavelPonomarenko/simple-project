package com.itdev.simpleproject.service.impl;

import com.itdev.simpleproject.dto.ResponseUserDto;
import com.itdev.simpleproject.model.User;
import com.itdev.simpleproject.repository.UserRepository;
import com.itdev.simpleproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List getAll() {
        List<User> userList = userRepository.findAll();
        List<ResponseUserDto> responseUserDtos = new ArrayList<>();
        for (User user : userList) {
            responseUserDtos.add(ResponseUserDto.FromUserToDto(user));
        }
        return responseUserDtos;
    }

    @Override
    public ResponseUserDto getOne(Long userId) {
        User user = userRepository.getOne(userId);
        if (user == null) {
            throw new EntityNotFoundException("User with id = " + userId + " not exists");
        }
        return ResponseUserDto.FromUserToDto(user);
    }

    @Override
    public void deleteOne(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("User with id = " + userId + " not exists");
        }
        userRepository.deleteById(userId);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseUserDto update(Long userId, User newUser) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    userRepository.save(user);
                    return ResponseUserDto.FromUserToDto(user);
                })
                .orElseGet(() -> {
                    newUser.setId(userId);
                    User user1 = userRepository.save(newUser);
                    return ResponseUserDto.FromUserToDto(user1);
                });
    }
}
