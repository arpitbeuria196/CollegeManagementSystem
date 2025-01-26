package com.collegeManagementSystem.mappingJPA.Entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorEntity professor;

    @ManyToMany(mappedBy = "subjects")
    private Set<StudentEntity> students;
}
