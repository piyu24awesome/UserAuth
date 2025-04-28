package org.example.userauthenticationservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    /*
    @Column(nullable = false, updatable = false)
    Instant createdAt;

    @Column(nullable = false)
    Instant updatedAt;


    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }

     */
}
