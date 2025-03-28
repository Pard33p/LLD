package com.parking_lot.service;

import java.util.ArrayList;
import java.util.List;

import com.parking_lot.model.*;

public class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingFloor> floors;

    private ParkingLot() {
        floors = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public ParkingSpot findParkingSpot(VehicleType type) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.findAvailableSpot(type);
            if (spot != null) {
                return spot;
            }
        }
        return null;
    }
}
