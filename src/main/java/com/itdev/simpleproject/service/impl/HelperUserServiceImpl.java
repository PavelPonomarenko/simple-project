package com.itdev.simpleproject.service.impl;

import com.itdev.simpleproject.dto.ResponseUserWithDetailsDto;
import com.itdev.simpleproject.model.User;
import com.itdev.simpleproject.repository.HobbyRepository;
import com.itdev.simpleproject.repository.UserRepository;
import com.itdev.simpleproject.service.HelperUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelperUserServiceImpl implements HelperUserService {

    private final HobbyRepository hobbyRepository;
    private final UserRepository userRepository;

    @Autowired
    public HelperUserServiceImpl(HobbyRepository hobbyRepository, UserRepository userRepository) {
        this.hobbyRepository = hobbyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List <ResponseUserWithDetailsDto> getAllUserWithDetails() {
//        ResponseUserWithDetailsDto userWithDetailsDto = new ResponseUserWithDetailsDto();
//        List <ResponseUserWithDetailsDto> result = new ArrayList <>();
        List <User> userList = userRepository.findAll();
        userList.forEach(System.out::println);


        return null;
    }
}
