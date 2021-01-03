package com.toa.springsecuritydemo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toa.springsecuritydemo.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByUserName(String userName);
}
