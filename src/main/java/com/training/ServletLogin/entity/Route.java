package com.training.ServletLogin.entity;

import java.util.Objects;

public class Route {
    private Long id;

    private String startCity;

    private String endCity;

    private int distanceInKm;

    public Route() {
    }

    public Route(Long id, String startCity, String endCity, int distanceInKm) {
        this.id = id;
        this.startCity = startCity;
        this.endCity = endCity;
        this.distanceInKm = distanceInKm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public int getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(int distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return distanceInKm == route.distanceInKm &&
                Objects.equals(id, route.id) &&
                Objects.equals(startCity, route.startCity) &&
                Objects.equals(endCity, route.endCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startCity, endCity, distanceInKm);
    }

}