package org.example;

class VehicleRepository extends JsonRepository<Vehicle> {
    public VehicleRepository() { super("vehicles.json"); }
}
