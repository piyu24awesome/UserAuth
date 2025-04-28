package org.example.userauthenticationservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name ="user")
public class User  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long userId;

    String emailId;
    String encPassword;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true )
    List<Session> sessionList;

}
