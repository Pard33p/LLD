package com.parking_lot.model;

public class Ticket {
    private static int ticketCounter = 1;
    private String ticketId;
    private long entryTime;
    private ParkingSpot spot;
    private Vehicle vehicle;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = "T" + ticketCounter++;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = System.currentTimeMillis();
    }

    public long getEntryTime() {
        return entryTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
