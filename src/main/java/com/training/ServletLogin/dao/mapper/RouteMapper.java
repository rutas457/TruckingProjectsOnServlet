package com.training.ServletLogin.dao.mapper;

import com.training.ServletLogin.entity.Route;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

public class RouteMapper implements ObjectMapper<Route> {


    @Override
    public Optional<Route> extractFromResultSet(ResultSet rs) throws SQLException {
        return Optional.of(new Route(
                rs.getLong("id"),
                rs.getString("start_city"),
                rs.getString("end_city"),
                rs.getInt("distance_in_km")
        ));
    }

    @Override
    public Route makeUnique(Map<Long, Route> cache,
                            Route route) {
        cache.putIfAbsent(route.getId(), route);
        return cache.get(route.getId());
    }
}
