package com.parking_lot.model;

public class BikeSpot extends ParkingSpot {
    public BikeSpot(String spotId) {
        super(spotId, VehicleType.BIKE);
    }
}
