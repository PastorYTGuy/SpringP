package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository implements IUserRepository{

    protected Map<String, User> all_users = new HashMap<>();
    private final String savefile;


    public UserRepository(String filename) {
        this.savefile = filename;
        File file = new File(savefile);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitter = line.split(";");
                if (splitter.length == 4) { // Format: login;passwordHash;role;rentedVehicleId
                    String login = splitter[0];
                    String password = splitter[1];
                    String role = splitter[2];
                    String rentedVehicleId = splitter[3].isEmpty() ? null : splitter[3];

                    User user = new User(login, password, role, rentedVehicleId);
                    all_users.put(login, user);
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas wczytywania użytkowników z pliku.");
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String login) {
        return all_users.get(login);
    }

    @Override
    public ArrayList<User> getUsers() {
        return new ArrayList<>(all_users.values());
    }

    @Override
    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.savefile))) {
            for (User user : all_users.values()) {
                writer.write(user.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Błąd zapisu użytkowników.");
            e.printStackTrace();
        }
    }

    @Override
    public void add_user(User user){
        this.all_users.put(user.getLogin(), user);
        save();
    }

    @Override
    public void delete_user(String login){
        this.all_users.remove(login);
        save();
    }
}
