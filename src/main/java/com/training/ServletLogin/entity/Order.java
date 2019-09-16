package com.training.ServletLogin.entity;

import com.sun.org.apache.xpath.internal.operations.Or;
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

    public static Order.Builder builder() {
        return new Order().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Order.Builder id(Long id) {
            Order.this.id = id;
            return this;
        }

        public Order.Builder cargoName(String cargoName) {
            Order.this.cargoName = cargoName;
            return this;
        }

        public Order.Builder route(Route route) {
            Order.this.route = route;

            return this;
        }

        public Order.Builder price(Long price) {
            Order.this.price = price;
            return this;
        }

        public Order.Builder state(OrderStatus state) {
            Order.this.state = state;

            return this;
        }

        public Order.Builder cargoType(CargoType cargoType) {
            Order.this.cargoType = cargoType;
            return this;
        }

        public Order.Builder weight(Integer weight) {
            Order.this.weight = weight;
            return this;
        }

        public Order.Builder shippingStart(LocalDate localDate) {
            Order.this.shippingStart = localDate;
            return this;
        }

        public Order.Builder shippingEnd(LocalDate localDate) {
            Order.this.shippingEnd = localDate;
            return this;
        }

        public Order.Builder user(User user) {
            Order.this.user = user;
            return this;
        }


        public Order build() {
            return Order.this;
        }

    }
}