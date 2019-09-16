package com.training.ServletLogin.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

public interface ObjectMapper<T> {

    Optional<T> extractFromResultSet(ResultSet rs) throws SQLException;

    T makeUnique(Map<Long, T> cache,
                 T teacher);
}
