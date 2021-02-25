package com.itdev.simpleproject.service.impl;

import com.itdev.simpleproject.model.Hobby;
import com.itdev.simpleproject.service.HobbyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyServiceImpl implements HobbyService {
    @Override
    public List<Hobby> getAll() {
        return null;
    }

    @Override
    public Hobby getOne(String name) {
        return null;
    }

    @Override
    public void deleteOne(String name) {

    }

    @Override
    public Hobby save(Hobby hobby) {
        return null;
    }
}
