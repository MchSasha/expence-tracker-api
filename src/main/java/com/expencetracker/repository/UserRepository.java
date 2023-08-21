package com.expencetracker.repository;


import com.expencetracker.entity.User;

public interface UserRepository {
    Integer create(String firstName, String lastName, String email, String password);

    User findByEmailAndPassword(String email, String password);

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
