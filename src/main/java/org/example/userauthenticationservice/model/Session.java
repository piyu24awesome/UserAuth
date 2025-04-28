package org.example.userauthenticationservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "session")
public class Session {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long sessionId;
    @Column(name  = "token", length = 10000)
    String token;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    User user;
}
