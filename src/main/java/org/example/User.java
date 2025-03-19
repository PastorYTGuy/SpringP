package org.example;

public class User {
    //posiada pola login, password,role, oraz pole reprezentujące wypożyczony
    //samochód. Jakie to powinno być pole?

    private String login;
    private String password;
    private String role;
    private Vehicle rented_car;


    public String show_all_data() {
        if (rented_car != null) {
            String result = String.format("Login: %s, Password: %s, Role: %s\nRented Car: %s", login, password, role, rented_car.toString());
        }
        else{
            String result = String.format("Login: %s, Password: %s, Role: %s\nRented Car: No car rented at the moment", login, password, role);
        }
        return null;
    }

}
