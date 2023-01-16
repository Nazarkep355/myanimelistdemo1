package com.example.myanimelistdemo1.repos;

import com.example.myanimelistdemo1.entity.Title;
import com.example.myanimelistdemo1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends JpaRepository<User,Long> {

    @Query("select u from User u where u.email = ?1")
    Optional<User> findByEmail(String email);
    Optional<User> findByName(String name);
}
