package com.itdev.simpleproject.service.impl;

import com.itdev.simpleproject.model.UserTelDetail;
import com.itdev.simpleproject.service.UserTelDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTelDetailServiceimpl implements UserTelDetailService {
    @Override
    public List<UserTelDetail> getAll() {
        return null;
    }

    @Override
    public UserTelDetail getOne(Long id) {
        return null;
    }

    @Override
    public void deleteOne(Long id) {

    }

    @Override
    public UserTelDetail save(UserTelDetail telDetail) {
        return null;
    }

    @Override
    public UserTelDetail update(Long id, UserTelDetail telDetail) {
        return null;
    }
}
