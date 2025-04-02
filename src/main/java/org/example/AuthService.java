package org.example;

import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String login, String password, String role) {
        List<User> users = userRepository.load(User.class);
        if (users.stream().anyMatch(u -> u.getLogin().equals(login))) return null;
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User newUser = new User(login, hashedPassword, role, null);
        users.add(newUser);
        userRepository.save(users);
        return newUser;
    }

    public User login(String login, String password) {
        List<User> users = userRepository.load(User.class);
        return users.stream()
                .filter(u -> u.getLogin().equals(login) && BCrypt.checkpw(password, u.getPasswordHash()))
                .findFirst()
                .orElse(null);
    }
}

