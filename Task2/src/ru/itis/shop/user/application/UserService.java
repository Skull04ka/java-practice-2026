package ru.itis.shop.user.application;

import ru.itis.shop.user.domain.User;
import ru.itis.shop.user.repository.UserRepository;

import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(String email, String password, String profileDescription) {
        userRepository.save(new User(email, password, profileDescription));
    }

    public boolean signIn(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return user.get().getPassword().equals(password);
        } else {
            return false;
        }
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean updateDescription(Optional<User> user, String description) {
        if (!user.isPresent()) {
            return false;
        }
        User user1 = user.get();
        user1.setProfileDescription(description);
        userRepository.update(user1);
        return true;
    }
}
