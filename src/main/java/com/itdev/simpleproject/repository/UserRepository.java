package com.itdev.simpleproject.repository;

import com.itdev.simpleproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository <User, Long> {

    @Query ("SELECT u FROM User u WHERE u.email=?1")
    Optional <User> findUserByEmail(String email);

    @Query ("SELECT u FROM User u inner join fetch u.hobbies as hobby ")
    List <User> findAllWithNobbies();

}
