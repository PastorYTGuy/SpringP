package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleShop implements IVehicleRepository{

    protected List<Vehicle> lista_pojazdow;
    private final String savefile;
    VehicleShop(String filename) {
        this.savefile = filename;
        this.lista_pojazdow = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String result;
            while ((result = reader.readLine()) != null) {
                String[] splitter = result.split(";");
                if (splitter.length == 6) { // Car format
                    lista_pojazdow.add(new Car(splitter[1], splitter[2], Integer.parseInt(splitter[3]), Integer.parseInt(splitter[4]), Boolean.parseBoolean(splitter[5])));
                } else if (splitter.length == 7) { // Motorcycle format
                    lista_pojazdow.add(new Motorcycle(splitter[1], splitter[2], splitter[3], Integer.parseInt(splitter[4]), Integer.parseInt(splitter[5]), Boolean.parseBoolean(splitter[6])));
                }
            }
        } catch (IOException e) {
            System.out.println("błąd w pobieraniu elementów z pliku");
            e.printStackTrace();
        }

    }


    @Override
    public boolean rentVehicle(String id) {
        Vehicle v = getVehicle(id);
        if (v != null && !v.isRented()) {
            v.rent();
            save();
            return true;
        }
        return false;
    }

    @Override
    public boolean returnVehicle(String id) {
        Vehicle v = getVehicle(id);
        if (v != null && v.isRented()) {
            v.return_it();
            save();
            return true;
        }
        return false;
    }

    private Vehicle clone_veh(Vehicle veh){
        if(veh instanceof Car){
            return new Car(veh.brand, veh.model, veh.year, veh.price, veh.rented);
        }
        else{
            return new Motorcycle(((Motorcycle) veh).category, veh.brand, veh.model, veh.year, veh.price, veh.rented);
        }
    }

    @Override
    public Vehicle getVehicle(String id) {
        for (Vehicle vehicle : this.lista_pojazdow) {
            if (vehicle.getId().equals(id)) {
                return clone_veh(vehicle);
            }
        }
        return null;
    }

    public void addVehicle(Vehicle vehicle) {
        this.lista_pojazdow.add(vehicle);
        save();
    }


    @Override
    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.savefile))) {
            for (Vehicle vehicle : this.lista_pojazdow) {
                writer.write(vehicle.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Błąd zapisu w VehicleShop");
            e.printStackTrace();
        }
    }
}
