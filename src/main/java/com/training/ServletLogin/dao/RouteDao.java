package com.training.ServletLogin.dao;

import com.training.ServletLogin.entity.Order;
import com.training.ServletLogin.entity.Route;

import java.util.Optional;

public interface RouteDao extends GenericDao<Order> {

    Optional<Route> findByStartCityAndEndCity(String startCity, String endCity);
}

