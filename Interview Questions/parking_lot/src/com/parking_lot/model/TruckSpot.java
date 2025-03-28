package com.parking_lot.model;

public class TruckSpot extends ParkingSpot {
    public TruckSpot(String spotId) {
        super(spotId, VehicleType.TRUCK);
    }
}
