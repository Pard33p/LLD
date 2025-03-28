package com.parking_lot.strategy;

public class HourlyPricingPaymentStrategy implements PaymentStrategy {

    private double ratePerHour;

    public HourlyPricingPaymentStrategy(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculateFee(long duration) {
        double hours = Math.ceil(duration / (1000.0 * 60 * 60));
        return hours * ratePerHour;
    }

}
