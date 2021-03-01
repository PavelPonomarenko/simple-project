package com.itdev.simpleproject.service;

import com.itdev.simpleproject.dto.ResponseUserDto;
import com.itdev.simpleproject.model.Hobby;
import com.itdev.simpleproject.model.User;

import java.util.List;


public interface HobbyService {

    List<Hobby> getAll();

    Hobby getOne(Long id);

    void deleteOne(Long id);

    Hobby save(Hobby hobby);


}
