package com.company.patientservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.patientservice.dto.PatientRequestDTO;
import com.company.patientservice.dto.PatientResponseDTO;
import com.company.patientservice.exception.EmailAlreadyExistsException;
import com.company.patientservice.exception.PatientNotFoundException;
import com.company.patientservice.mapper.PatientMapper;
import com.company.patientservice.model.Patient;
import com.company.patientservice.repo.IPatientRepository;

@Service
public class PatientServiceImpl {

	@Autowired
	private IPatientRepository patientRepo;

	public List<PatientResponseDTO> getPatients() {
		return patientRepo.findAll().stream().map(PatientMapper::convertToPatientResponseDTO).toList();
	}

	public PatientResponseDTO createPatient(PatientRequestDTO patientDTO) {

		if (patientRepo.existsByEmail(patientDTO.getEmail())) {
			throw new EmailAlreadyExistsException(
					"A patient with this email " + "already exists" + patientDTO.getEmail());
		}

		return PatientMapper.convertToPatientResponseDTO(patientRepo.save(PatientMapper.convertToEntity(patientDTO)));
	}

	public PatientResponseDTO updatePatient(int id, PatientRequestDTO patientRequestDto) {

		Patient patient = patientRepo.findById(id)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));

		if (patientRepo.existsByEmail(patient.getEmail())) {
			throw new EmailAlreadyExistsException(
					"A patient with this email " + "already exists" + patientRequestDto.getEmail());
		}

		patient.setName(patientRequestDto.getName());
		patient.setAddress(patientRequestDto.getAddress());
		patient.setEmail(patientRequestDto.getEmail());
		patient.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBirth()));

		return PatientMapper.convertToPatientResponseDTO(patientRepo.save(patient));
	}

	public String deletePatient(int id) {

		if (patientRepo.findById(id).isEmpty()) {
			throw new PatientNotFoundException("Patient not found with ID: " + id);
		}

		return "Patient deleted successfully with id: " + id;
	}

}
