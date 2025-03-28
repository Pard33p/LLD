package com.parking_lot.model;

public abstract class ParkingSpot {
    protected String spotId;
    protected boolean isOccupied;
    protected VehicleType vehicleType;

    public ParkingSpot(String spotId, VehicleType type) {
        this.spotId = spotId;
        this.vehicleType = type;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void parkVehicle() {
        isOccupied = true;
    }

    public void unparkVehicle() {
        isOccupied = false;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getSpotId() {
        return spotId;
    }
}
