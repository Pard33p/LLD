package com.parking_lot.service;

import com.parking_lot.model.*;
import com.parking_lot.strategy.*;

public class PaymentService {
    public static double processPayment(Ticket ticket, PaymentStrategy strategy) {
        long exitTime = System.currentTimeMillis();
        long duration = exitTime - ticket.getEntryTime();
        return strategy.calculateFee(duration);
    }
}
