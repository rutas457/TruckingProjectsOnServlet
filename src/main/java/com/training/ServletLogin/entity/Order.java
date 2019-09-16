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

    public static int getTonPerKm() {
        return tonPerKm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public OrderStatus getState() {
        return state;
    }

    public void setState(OrderStatus state) {
        this.state = state;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public LocalDate getShippingStart() {
        return shippingStart;
    }

    public void setShippingStart(LocalDate shippingStart) {
        this.shippingStart = shippingStart;
    }

    public LocalDate getShippingEnd() {
        return shippingEnd;
    }

    public void setShippingEnd(LocalDate shippingEnd) {
        this.shippingEnd = shippingEnd;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", cargoName='" + cargoName + '\'' +
                ", route=" + route +
                ", price=" + price +
                ", state=" + state +
                ", cargoType=" + cargoType +
                ", weight=" + weight +
                ", shippingStart=" + shippingStart +
                ", shippingEnd=" + shippingEnd +
                ", paid=" + paid +
                ", user=" + user +
                '}';
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

        public Order.Builder paid(Boolean isPaid) {
            Order.this.paid = isPaid;
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