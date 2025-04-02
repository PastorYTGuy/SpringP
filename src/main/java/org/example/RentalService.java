package org.example;

import java.util.Collections;
import java.util.Date;
import java.util.List;

class RentalService {
    private final VehicleRepository vehicleRepository;
    private final RentalRepository rentalRepository;

    public RentalService(VehicleRepository vehicleRepository, RentalRepository rentalRepository) {
        this.vehicleRepository = vehicleRepository;
        this.rentalRepository = rentalRepository;
    }

    public boolean rentVehicle(String userId, String vehicleId) {
        List<Vehicle> vehicles = vehicleRepository.load(Vehicle.class);
        Vehicle vehicle = vehicles.stream().filter(v -> v.getId().equals(vehicleId) && !v.isRented()).findFirst().orElse(null);
        if (vehicle == null) return false;
        vehicle.setRented(true);
        rentalRepository.save(Collections.singletonList(new Rental(userId, vehicleId, new Date())));
        vehicleRepository.save(vehicles);
        return true;
    }

    public boolean returnVehicle(String vehicleId) {
        List<Vehicle> vehicles = vehicleRepository.load(Vehicle.class);
        Vehicle vehicle = vehicles.stream().filter(v -> v.getId().equals(vehicleId)).findFirst().orElse(null);
        if (vehicle == null || !vehicle.isRented()) return false;
        vehicle.setRented(false);
        vehicleRepository.save(vehicles);
        return true;
    }
}
