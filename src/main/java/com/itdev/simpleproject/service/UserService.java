package com.itdev.simpleproject.service;

import com.itdev.simpleproject.dto.ResponseUserDto;
import com.itdev.simpleproject.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List getAll();

    ResponseUserDto getOne(Long userId);

    void deleteOne(Long userId);

    User save(User user);

    ResponseUserDto update(Long userId, User user);

}
