package com.training.ServletLogin.dao;

import com.training.ServletLogin.entity.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User> {

    Optional<User> findByEmail(String email);
}
