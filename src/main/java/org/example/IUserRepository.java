package org.example;

import java.util.ArrayList;
import java.util.List;

public interface IUserRepository {
    User getUser(String login);
    List<User> getUsers();
    void save();
    void add_user(User user);
    void delete_user(String login);
}
