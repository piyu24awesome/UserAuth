package org.example.userauthenticationservice.service;

import org.example.userauthenticationservice.model.User;

public interface UserService {
    public User addUser(User user);


    public User loginUser(User user);
}
