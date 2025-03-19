package org.example;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{

    protected List<User> all_users;

    @Override
    public User getUser(String login) {
        return null;
    }

    @Override
    public ArrayList<User> getUsers() {
        return null;
    }

    @Override
    public void save() {

    }
}
