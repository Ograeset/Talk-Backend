package com.ograeset.talkbackend.repository;

import com.ograeset.talkbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT s FROM User s WHERE s.userName = ?1")
    Optional<User> findUserByUserName(String username);

    @Query("SELECT s FROM User s WHERE s.userName = ?1")
    User findByUsername(String username);

    Optional<User> findUserByUsername(String username);
}