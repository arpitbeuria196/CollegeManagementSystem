package com.collegeManagementSystem.mappingJPA.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdmissionRecordDTO {
    private Long id;

    @NotNull(message = "Fees are required")
    private Double fees;

    @NotNull(message = "Student ID is required")
    private Long studentId;
}
