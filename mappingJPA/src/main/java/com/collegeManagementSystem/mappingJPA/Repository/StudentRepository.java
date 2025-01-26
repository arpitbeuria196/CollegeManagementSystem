package com.collegeManagementSystem.mappingJPA.Repository;


import com.collegeManagementSystem.mappingJPA.Entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
