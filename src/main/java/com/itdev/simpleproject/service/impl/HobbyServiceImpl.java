package com.itdev.simpleproject.service.impl;

import com.itdev.simpleproject.repository.HobbyRepository;
import com.itdev.simpleproject.model.Hobby;
import com.itdev.simpleproject.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class HobbyServiceImpl implements HobbyService {

    private final HobbyRepository hobbyRepository;

    @Autowired
    public HobbyServiceImpl(HobbyRepository hobbyRepository) {
        this.hobbyRepository = hobbyRepository;
    }

    @Override
    public List<Hobby> getAll() {
        return hobbyRepository.findAll();
    }

    @Override
    public Hobby getOne(Long id) {
        return hobbyRepository.getOne(id);
    }

    @Override
    public void deleteOne(Long id) {
        if (!hobbyRepository.existsById(id)) {
            throw new EntityNotFoundException("Hobby with id = " + id + " not exists");
        }
        hobbyRepository.deleteById(id);
    }

    @Override
    public Hobby save(Hobby hobby) {
        return hobbyRepository.save(hobby);
    }

}
