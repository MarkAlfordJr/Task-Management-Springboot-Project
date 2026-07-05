package com.example.Task_Management_Project.dto;

import com.example.Task_Management_Project.enums.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

// returns User Object JSON from model after every API request
@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // exclude the JSONignored fields through serialization
public class UserDTO {
    private Long id; // now id is unique, spring will take care of it
    private String email;
    private String password;
    private Role role;
    private List<TaskDTO> tasks;
}
