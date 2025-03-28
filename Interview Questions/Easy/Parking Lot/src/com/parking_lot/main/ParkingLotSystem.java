package com.parking_lot.main;

import com.parking_lot.factory.ParkingSpotFactory;
import com.parking_lot.model.ParkingFloor;
import com.parking_lot.model.Ticket;
import com.parking_lot.model.Vehicle;
import com.parking_lot.model.VehicleType;
import com.parking_lot.service.ParkingAttendant;
import com.parking_lot.service.ParkingLot;
import com.parking_lot.strategy.HourlyPricingPaymentStrategy;
import com.parking_lot.strategy.PaymentStrategy;

public class ParkingLotSystem {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = ParkingLot.getInstance();

        ParkingFloor floor1 = new ParkingFloor("F1");
        floor1.addSpot(ParkingSpotFactory.createSpot("S1", VehicleType.BIKE));
        floor1.addSpot(ParkingSpotFactory.createSpot("S2", VehicleType.CAR));
        floor1.addSpot(ParkingSpotFactory.createSpot("S3", VehicleType.TRUCK));

        parkingLot.addFloor(floor1);

        ParkingAttendant attendant = new ParkingAttendant();

        Vehicle bike = new Vehicle("BIKE124", VehicleType.BIKE);
        Vehicle car = new Vehicle("CAR1234", VehicleType.CAR);

        Ticket bikeTicket = attendant.parkVehicle(bike);
        Ticket carTicket = attendant.parkVehicle(car);

        // simulating parking duration.
        Thread.sleep(2000);

        PaymentStrategy hourlyStrategy = new HourlyPricingPaymentStrategy(10.0);
        double bikeFee = attendant.unparkVehicle(bikeTicket, hourlyStrategy);
        double carFee = attendant.unparkVehicle(carTicket, hourlyStrategy);

        System.out.println("Bike parking fee: Rs." + bikeFee);
        System.out.println("Car parking fee: Rs." + carFee);
    }
}
