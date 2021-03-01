package com.itdev.simpleproject.repository;

import com.itdev.simpleproject.model.Hobby;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface HobbyRepository extends JpaRepository <Hobby, Long> {

    @Transactional (readOnly = true)
    @Query ("select distinct h FROM Hobby h order by h.id")
    List <Hobby> findAllHobbyWithUsers();

    @Override
    @Transactional (readOnly = true)
    @Query ("select h FROM Hobby h WHERE h.id=:id")
    Hobby getOne(@Param ("id") Long aLong);

    @Override
    @Transactional (readOnly = true)
    @Query ("select distinct h FROM Hobby h order by h.id")
    List <Hobby> findAll();
}
