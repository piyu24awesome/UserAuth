package org.example.userauthenticationservice.service;

import org.example.userauthenticationservice.exception.EntityNotFoundException;
import org.example.userauthenticationservice.mapper.MapperUtil;
import org.example.userauthenticationservice.model.Session;
import org.example.userauthenticationservice.model.User;
import org.example.userauthenticationservice.repo.SessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    UserService userService;

    @Autowired
    SessionRepo sessionRepo;

    @Override
    public Session createSession(User user) {
        User validatedUser = userService.loginUser(user);
        Session s = new Session();
        s.setUser(validatedUser);
        s.setToken(UUID.randomUUID().toString());
        return sessionRepo.save(s);
    }

    @Override
    public Session deleteSession(long sessionId) {

        //find the session
        Session validatedSession = sessionRepo.findBySessionId(sessionId).orElseThrow(
                () -> new EntityNotFoundException("Session with id " + sessionId + " not found")
        );

        //delete the session
        sessionRepo.deleteById(validatedSession.getSessionId());
        //return the session
        return validatedSession;
    }
}
