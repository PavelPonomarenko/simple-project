package com.itdev.simpleproject.service;

import com.itdev.simpleproject.dto.ResponseUserDto;
import com.itdev.simpleproject.model.User;
import com.itdev.simpleproject.model.UserTelDetail;

import java.util.List;

public interface UserTelDetailService {

    List<UserTelDetail> getAll();

    UserTelDetail getOne(Long id);

    void deleteOne(Long id);

    UserTelDetail save(UserTelDetail telDetailil);

    UserTelDetail update(Long id, UserTelDetail telDetailil);
}
