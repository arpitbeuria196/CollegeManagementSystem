package com.collegeManagementSystem.mappingJPA.Repository;


import com.collegeManagementSystem.mappingJPA.Entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.security.auth.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity,Long> {
}
