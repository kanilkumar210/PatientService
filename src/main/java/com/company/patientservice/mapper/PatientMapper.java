package com.company.patientservice.mapper;

import java.time.LocalDate;

import com.company.patientservice.dto.PatientRequestDTO;
import com.company.patientservice.dto.PatientResponseDTO;
import com.company.patientservice.model.Patient;

public class PatientMapper {

	public static PatientResponseDTO convertToPatientResponseDTO(Patient patient) {

		PatientResponseDTO responseDTO = new PatientResponseDTO();

		responseDTO.setAddress(patient.getAddress());
		responseDTO.setDateOfBirth(patient.getDateOfBirth().toString());
		responseDTO.setEmail(patient.getEmail());
		responseDTO.setId(patient.getId());
		responseDTO.setName(patient.getName());
		responseDTO.setRegistrationDate(patient.getRegistrationDate().toString());

		return responseDTO;
	}

	public static Patient convertToEntity(PatientRequestDTO patientRequestDTO) {

		Patient patient = new Patient();
		patient.setName(patientRequestDTO.getName());
		patient.setAddress(patientRequestDTO.getAddress());
		patient.setEmail(patientRequestDTO.getEmail());
		patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
		patient.setRegistrationDate(LocalDate.parse(patientRequestDTO.getRegistrationDate()));
		return patient;
	}
}
