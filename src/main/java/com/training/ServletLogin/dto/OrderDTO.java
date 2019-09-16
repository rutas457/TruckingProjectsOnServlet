package com.training.ServletLogin.dto;

import com.training.ServletLogin.entity.enumerated.CargoType;

public class OrderDTO {
    private String cargoName;
    private String fromCity;
    private String toCity;

    private String shippingStart;
    private String shippingEnd;

    private CargoType cargoType;
    private int weight;

    public OrderDTO() {
    }


    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getShippingStart() {
        return shippingStart;
    }

    public void setShippingStart(String shippingStart) {
        this.shippingStart = shippingStart;
    }

    public String getShippingEnd() {
        return shippingEnd;
    }

    public void setShippingEnd(String shippingEnd) {
        this.shippingEnd = shippingEnd;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static OrderDTO.Builder builder() {
        return new OrderDTO().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public OrderDTO.Builder cargoName(String cargoName) {
            OrderDTO.this.cargoName = cargoName;
            return this;
        }

        public OrderDTO.Builder from(String from) {
            OrderDTO.this.fromCity = from;

            return this;
        }

        public OrderDTO.Builder to(String to) {
            OrderDTO.this.toCity = to;
            return this;
        }

        public OrderDTO.Builder shippingStart(String shippingStart) {
            OrderDTO.this.shippingStart = shippingStart;
            return this;
        }

        public OrderDTO.Builder shippingEnd(String shippingEnd) {
            OrderDTO.this.shippingEnd = shippingEnd;
            return this;
        }


        public OrderDTO.Builder cargoType(CargoType cargoType) {
            OrderDTO.this.cargoType = cargoType;
            return this;
        }

        public OrderDTO.Builder weight(Integer weight) {
            OrderDTO.this.weight = weight;
            return this;
        }

        public OrderDTO build() {
            return OrderDTO.this;
        }

    }
}
