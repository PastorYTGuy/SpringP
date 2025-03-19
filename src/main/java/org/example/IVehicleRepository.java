package org.example;

public interface IVehicleRepository {
    boolean rentVehicle(String id);

    boolean returnVehicle(String id);

    Vehicle getVehicle(String id);

    void save();


}
