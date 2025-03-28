package com.parking_lot.model;

public class CarSpot extends ParkingSpot {
    public CarSpot(String spotId) {
        super(spotId, VehicleType.CAR);
    }
}
