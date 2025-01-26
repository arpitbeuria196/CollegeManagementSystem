package com.collegeManagementSystem.mappingJPA.Entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorEntity professor;

    @ManyToMany
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<SubjectEntity> subjects;
}
