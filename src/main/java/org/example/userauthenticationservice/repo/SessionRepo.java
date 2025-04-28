package org.example.userauthenticationservice.repo;

import org.example.userauthenticationservice.model.Session;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepo extends JpaRepository<Session, Long> {

    Session save(Session session);

    void deleteById(long sessionId);

    Optional<Session> findBySessionId(long sessionId);
}
