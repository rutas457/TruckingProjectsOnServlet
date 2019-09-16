package com.training.ServletLogin.entity.enumerated;

public enum CargoType {
    FRAGILE(1.2),
    FOOD(1.3),
    DANGEROUS(2),
    STANDARD(1);

    private double priceCoefficient;

    CargoType(double priceCoefficient) {
        this.priceCoefficient = priceCoefficient;
    }

    public double getPriceCoefficient() {
        return priceCoefficient;
    }

    public void setPriceCoefficient(double priceCoefficient) {
        this.priceCoefficient = priceCoefficient;
    }
}
