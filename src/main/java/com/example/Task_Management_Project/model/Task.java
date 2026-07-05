package com.example.Task_Management_Project.model;

import com.example.Task_Management_Project.enums.Category;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;
    private Boolean isCompleted = false;

    @ManyToOne
    @JoinColumn(name = "users_id") // custom column name for this user object
    @JsonManagedReference(value = "user's-tasks") // custom name for the JSON body
    private User user;
}
