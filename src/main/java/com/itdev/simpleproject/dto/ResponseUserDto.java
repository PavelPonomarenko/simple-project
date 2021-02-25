package com.itdev.simpleproject.dto;

import com.itdev.simpleproject.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public static ResponseUserDto FromUserToDto(User user) {
        ResponseUserDto userDto = new ResponseUserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
