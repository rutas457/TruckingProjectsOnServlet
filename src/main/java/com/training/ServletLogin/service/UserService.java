package com.training.ServletLogin.service;

import com.training.ServletLogin.dao.DaoFactory;
import com.training.ServletLogin.dao.UserDao;
import com.training.ServletLogin.dto.UserDTO;
import com.training.ServletLogin.entity.User;

import java.util.List;
import java.util.Optional;

public class UserService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public Optional<User> findByEmail(String email) {
        try (UserDao dao = daoFactory.createStudentDao()) {
            return dao.findByEmail(email);
        }
    }

    public boolean save(UserDTO userDTO) {
        User user = User.builder()
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .surname(userDTO.getSurname())
                .password(userDTO.getPassword())
                .roles("USER")
                .build();
        try (UserDao dao = daoFactory.createStudentDao()) {
            return dao.create(user);
        }
    }

    public List<User> getAllStudents() {
        try (UserDao dao = daoFactory.createStudentDao()) {
            return dao.findAll();
        }
    }
}
