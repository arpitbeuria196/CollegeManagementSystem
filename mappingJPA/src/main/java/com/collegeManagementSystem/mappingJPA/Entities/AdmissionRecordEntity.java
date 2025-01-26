package com.collegeManagementSystem.mappingJPA.Entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AdmissionRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double fees;

    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;
}
