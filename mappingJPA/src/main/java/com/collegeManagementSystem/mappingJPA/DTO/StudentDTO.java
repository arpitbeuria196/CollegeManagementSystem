package com.collegeManagementSystem.mappingJPA.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Set;

@Data
public class StudentDTO {
    private Long id;

    @NotBlank(message = "Name is Required")
    private String name;
    private Long professorId;
    private Set<Long> subjectIds;

}
