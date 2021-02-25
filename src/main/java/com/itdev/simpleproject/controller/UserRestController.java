package com.itdev.simpleproject.controller;

import com.itdev.simpleproject.dto.ResponseUserDto;
import com.itdev.simpleproject.model.User;
import com.itdev.simpleproject.service.UserService;
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

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseUserDto>> getAllUsers() {
        List<ResponseUserDto> users = userService.getAll();
        if (users == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable(name = "userId") Long userId) {
        ResponseUserDto userDto = userService.getOne(userId);
        if (userDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("delete/{userId}")
    public void deleteUser(@PathVariable(name = "userId") Long userId) {
        userService.deleteOne(userId);
    }

    @PostMapping("/create/newUser")
    ResponseEntity createUser(@RequestBody User newUser) {
        userService.save(newUser);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.update(id, user);
    }

}
