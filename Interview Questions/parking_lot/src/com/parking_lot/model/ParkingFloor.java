package com.parking_lot.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private String floorId;
    private List<ParkingSpot> spots;

    public ParkingFloor(String floorId) {
        this.floorId = floorId;
        spots = new ArrayList<>();
    }

    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public ParkingSpot findAvailableSpot(VehicleType type) {
        for (ParkingSpot spot : spots) {
            if (spot.getVehicleType() == type && spot.isAvailable()) {
                return spot;
            }
        }
        return null;
    }

    public String getFloorId() {
        return floorId;
    }
}
