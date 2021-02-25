package com.itdev.simpleproject.repository;

import com.itdev.simpleproject.model.UserTelDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTelDetailReository extends JpaRepository<UserTelDetail, Long> {
}
