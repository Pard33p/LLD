package com.parking_lot.strategy;

public interface PaymentStrategy {
    double calculateFee(long duration);
}
