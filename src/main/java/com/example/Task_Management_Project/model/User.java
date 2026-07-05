package com.example.Task_Management_Project.model;

import com.example.Task_Management_Project.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.ArrayList;
import java.util.List;

// Data Model to go into the db, spring loads it up
@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // now id is unique, spring will take care of it

    // @Column(name = "user's emails") this customizes columns
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // this must be the one-to-many relationship.
    // user will have MANY Tasks object to its ONE object
    @JsonManagedReference(value = "user's-tasks") // prevents circular referencing in the relationship
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // change to one user, changes all its tasks.
    private List<Task> tasks = new ArrayList<>();
}
