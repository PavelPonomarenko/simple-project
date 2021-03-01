package com.itdev.simpleproject.dto;

import com.itdev.simpleproject.model.Hobby;
import com.itdev.simpleproject.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ResponseUserWithDetailsDto {


    private Long id;
    private String firstName;
    private String lastName;
    private String hobby;


    public static ResponseUserWithDetailsDto FromUserHobbyToDto(User user, Hobby hobbyUser) {
        ResponseUserWithDetailsDto userHobbyDto = new ResponseUserWithDetailsDto();
        userHobbyDto.setId(user.getId());
        userHobbyDto.setFirstName(user.getFirstName());
        userHobbyDto.setLastName(user.getLastName());
        userHobbyDto.setHobby(hobbyUser.getName());
        return userHobbyDto;
    }

}
