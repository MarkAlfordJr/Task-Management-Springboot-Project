package com.example.Task_Management_Project.dto;

import com.example.Task_Management_Project.enums.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private Category category;
    private Boolean isCompleted;// custom name for the JSON body
    // private UserDTO user; DON'T NEED THIS BECAUSE OF THE BACKREFERENCING IN THE RELATIONSHIP
}
