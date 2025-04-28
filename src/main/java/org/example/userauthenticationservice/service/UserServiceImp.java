package org.example.userauthenticationservice.service;

import org.example.userauthenticationservice.exception.EntityNotFoundException;
import org.example.userauthenticationservice.model.User;
import org.example.userauthenticationservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepo userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User loginUser(User user) {

        //if user not found raise an exception

        return userRepository.findByEmailIdAndEncPassword(user.getEmailId(), user.getEncPassword()).orElseThrow(
                () -> new EntityNotFoundException("User with email id " + user.getEmailId() + " not found")
        );
    }
}
