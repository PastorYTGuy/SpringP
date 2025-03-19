package org.example;

import java.util.ArrayList;

public interface IUserRepository {
    User getUser(String login);
    ArrayList<User> getUsers();
    void save();
}
