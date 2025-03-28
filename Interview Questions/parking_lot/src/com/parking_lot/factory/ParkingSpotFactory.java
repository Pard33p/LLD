package com.parking_lot.factory;

import com.parking_lot.model.*;

public class ParkingSpotFactory {
    public static ParkingSpot createSpot(String spotId, VehicleType type) {
        switch (type) {
            case BIKE:
                return new BikeSpot(spotId);
            case CAR:
                return new CarSpot(spotId);
            case TRUCK:
                return new TruckSpot(spotId);
            default:
                throw new IllegalArgumentException("Invalid Vehicle Type");
        }
    }
}
