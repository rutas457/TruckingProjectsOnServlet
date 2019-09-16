package com.training.ServletLogin.dao.mapper;

import com.training.ServletLogin.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

public class UserMapper implements ObjectMapper<User> {


    @Override
    public Optional<User> extractFromResultSet(ResultSet rs) throws SQLException {
        User user = User.builder()
                .id(rs.getInt("id"))
                .email(rs.getString("email"))
                .name(rs.getString("name"))
                .password(rs.getString("password"))
                .surname(rs.getString("surname"))
                .roles(rs.getString("role"))
                .build();
        return Optional.of(user);
    }

    @Override
    public User makeUnique(Map<Long, User> cache,
                           User user) {
        cache.putIfAbsent(user.getId().longValue(), user);
        return cache.get(user.getId());
    }
}
