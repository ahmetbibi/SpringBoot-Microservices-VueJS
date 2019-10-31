package com.sha.microserviceusermanagement.model;

import lombok.Data;

import javax.persistence.*;

@Data // This annotation from lombok make getter and setter methods ready, yo don't need to define them
@Entity
@Table(name = "user")
public class User {

    @Id
    //Generation Types:
    //Auto: Default one. It does not take any specific action.
    //Identity: Auto increment.
    //Sequence: Oracle or Posgresql creates variable to auto increment.
    //Table: Hibernate uses a database table to simulate a sequence.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY is to make it auto incremented
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;
}