package org.example;

import java.util.Optional;

public class User {
    //posiada pola login, password,role, oraz pole reprezentujące wypożyczony
    //samochód. Jakie to powinno być pole?

    private String login;
    private String password;
    private String role;
    private Vehicle rented_car;
    private String rented_vehicle_id;

    public User(String login, String password, String role, String init_vehicle_id) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.rented_vehicle_id = init_vehicle_id;
        this.rented_car = null;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Vehicle getRented_car_id() {
        return rented_car;
    }

    public void rent_vehicle(String carID, IVehicleRepository vehicle_repo){
        if(this.rented_car != null){
            System.out.println("You have a car already!");
            return;
        }
        if(vehicle_repo.rentVehicle(carID)){ //jeżeli rentVehicle zwróci True to automatycznie ustawi jako rented
            //jeśli rentVehicle zwróci false to nic nie ustawi i nie możemy auta pobrać
            this.rented_car = vehicle_repo.getVehicle(carID);
            this.rented_vehicle_id = carID;
            System.out.println("You got yourself a brand new: " + carID);
        }
    }

    public void return_vehicle(IVehicleRepository vehicle_repo){
        vehicle_repo.returnVehicle(this.rented_car.getId());
        this.rented_car = null;
    }

    public void restoreRentedVehicle(IVehicleRepository vehicleRepository) {
        //TA METODA JESZCZE DO ZMIANY!!!! po wczytaniu użytkownika i serwera i zalogowaniu się
        //dopiero powinniśmy robić restore bo mamy dostęp do repozytorium
        if (this.rented_vehicle_id != null) {
            this.rented_car = vehicleRepository.getVehicle(this.rented_vehicle_id);
        }
    }

    public String show_all_data() {
        if (rented_car != null) {
            String result = String.format("Login: %s, Password: %s, Role: %s\nRented Car: %s", login, password, role, rented_car.toString());
        }
        else{
            String result = String.format("Login: %s, Password: %s, Role: %s\nRented Car: No car rented at the moment", login, password, role);
        }
        return null;
    }

    public String toCSV() {
        return login + ";" + password + ";" + role + ";" + (rented_vehicle_id == null ? "" : rented_vehicle_id);
    }

}
