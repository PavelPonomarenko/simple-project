package com.itdev.simpleproject.service.impl;

import com.itdev.simpleproject.dto.ResponseUserDto;
import com.itdev.simpleproject.repository.HobbyRepository;
import com.itdev.simpleproject.model.Hobby;
import com.itdev.simpleproject.repository.UserRepository;
import com.itdev.simpleproject.service.HobbyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Slf4j
public class HobbyServiceImpl implements HobbyService {

    private final HobbyRepository hobbyRepository;

    @Autowired
    public HobbyServiceImpl(HobbyRepository hobbyRepository) {
        this.hobbyRepository = hobbyRepository;
    }

    @Override
    public List <Hobby> getAll() {
        return hobbyRepository.findAll();
    }

    @Override
    public Hobby getOne(Long id) {
        Hobby hobby = hobbyRepository.getOne(id);
        if (hobby == null) {
            log.error("Service -> Hobby with id = " + id + " not exists");
            throw new EntityNotFoundException("Hobby with id = " + id + " not exists");
        }
        return hobby;
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
