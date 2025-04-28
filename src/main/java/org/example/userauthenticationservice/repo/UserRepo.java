package org.example.userauthenticationservice.repo;

import org.example.userauthenticationservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User save(User user);
   Optional<User> findByEmailIdAndEncPassword(String emailId , String encPassword);
}
