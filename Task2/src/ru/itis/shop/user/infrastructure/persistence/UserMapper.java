package ru.itis.shop.user.infrastructure.persistence;

import ru.itis.shop.user.domain.User;

public class UserMapper {

    public User fromLine(String line) {
        String[] arr = line.split("\\|");

        return new User(arr[0], arr[1], arr[2], arr[3]);
    }
    public String toLine(User user) {
        return user.getId() + "|" +
                user.getEmail() + "|" +
                user.getPassword() + "|" +
                user.getProfileDescription();
    }

}
