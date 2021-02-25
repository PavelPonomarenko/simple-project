package com.itdev.simpleproject.repository;

import com.itdev.simpleproject.model.Hobby;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface HobbyRepository extends JpaRepository<Hobby, Long> {

}
