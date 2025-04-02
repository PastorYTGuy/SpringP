package org.example;

class UserRepository extends JsonRepository<User> {
    public UserRepository() { super("users.json"); }
}
