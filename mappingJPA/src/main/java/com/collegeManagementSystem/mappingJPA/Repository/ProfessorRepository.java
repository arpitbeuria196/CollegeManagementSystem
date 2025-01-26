package com.collegeManagementSystem.mappingJPA.Repository;


import com.collegeManagementSystem.mappingJPA.Entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity,Long> {
}
