package com.company.patientservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.patientservice.model.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {

	boolean existsByEmail(String email);

//	boolean existsByEmailAndIdNot(String email, int id);
}
