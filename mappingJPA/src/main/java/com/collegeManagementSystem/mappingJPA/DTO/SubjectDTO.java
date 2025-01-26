package com.collegeManagementSystem.mappingJPA.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Set;

@Data
public class SubjectDTO {
    private Long id;

    @NotBlank(message = "Title is Required")
    private String title;
    private Long professorId;
    private Set<Long> studentIds;
}
