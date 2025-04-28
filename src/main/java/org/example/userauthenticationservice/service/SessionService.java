package org.example.userauthenticationservice.service;

import org.example.userauthenticationservice.model.Session;
import org.example.userauthenticationservice.model.User;

public interface SessionService {

   public Session createSession(User user);
   public Session deleteSession(long sessionId);
}
