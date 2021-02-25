package com.itdev.simpleproject.controller;

import com.itdev.simpleproject.dto.ResponseUserDto;
import com.itdev.simpleproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itdev.simpleproject.service.HobbyService;
import com.itdev.simpleproject.model.Hobby;

import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/hobbies")
public class HobbyRestController {

    private final HobbyService hobbyService;

    @Autowired
    public HobbyRestController(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Hobby>> getAllHobbies() {
        List<Hobby> hobbyList = hobbyService.getAll();
        if (hobbyList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(hobbyList, HttpStatus.OK);
    }

    @GetMapping("/{hobbyId}")
    public ResponseEntity<Hobby> getEmployeeById(@PathVariable(name = "hobbyId") Long hobbyId) {
        Hobby hobby = hobbyService.getOne(hobbyId);
        if (hobby == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(hobby, HttpStatus.OK);
    }

    @PostMapping("delete/{hobbyId}")
    public void deleteHobby(@PathVariable(name = "hobbyId") Long hobbyId) {
        hobbyService.deleteOne(hobbyId);
    }

    @PostMapping("/create/hobby")
    ResponseEntity createHobby(@RequestBody Hobby newHobby) {
        hobbyService.save(newHobby);
        return new ResponseEntity(HttpStatus.OK);
    }


}
