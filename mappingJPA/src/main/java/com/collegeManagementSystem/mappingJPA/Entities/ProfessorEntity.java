package com.collegeManagementSystem.mappingJPA.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "professor",cascade = CascadeType.ALL)
    private Set<StudentEntity> students;

    @ManyToMany
    private Set<SubjectEntity> subjects;


}
