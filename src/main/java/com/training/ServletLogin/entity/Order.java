package com.training.ServletLogin.entity;

import com.training.ServletLogin.entity.enumerated.CargoType;
import com.training.ServletLogin.entity.enumerated.OrderStatus;

import java.time.LocalDate;

public class Order {

    private static final int tonPerKm = 2;

    private Long id;

    private String cargoName;

    private Route route;
    private Long price;

    private OrderStatus state;

    private CargoType cargoType;

    private Integer weight;
    private LocalDate shippingStart;
    private LocalDate shippingEnd;

    private Boolean paid;

    private User user;

    public long calculateOrderPrice() {
        return Double.valueOf(route.getDistanceInKm() * weight * tonPerKm * cargoType.getPriceCoefficient()).longValue();
    }
}