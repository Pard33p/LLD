package com.parking_lot.service;

import com.parking_lot.model.*;
import com.parking_lot.strategy.*;

public class ParkingAttendant {
    private ParkingLot parkingLot;

    public ParkingAttendant() {
        this.parkingLot = ParkingLot.getInstance();
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = parkingLot.findParkingSpot(vehicle.getVehicleType());

        if (spot == null) {
            System.out.println("No available spot for : " + vehicle.getVehicleType());
            return null;
        }
        spot.parkVehicle();
        System.out.println("Vehicle parked: " + vehicle.getLicensePlate());
        return new Ticket(vehicle, spot);
    }

    public double unparkVehicle(Ticket ticket, PaymentStrategy strategy) {
        ticket.getSpot().unparkVehicle();
        return PaymentService.processPayment(ticket, strategy);
    }
}
