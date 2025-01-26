package com.collegeManagementSystem.mappingJPA.Repository;

import com.collegeManagementSystem.mappingJPA.Entities.AdmissionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecordEntity,Long> {
}
