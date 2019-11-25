package hospital2Spring.model.service.impl;


import java.util.List;

import hospital2Spring.model.entity.Patient;
import hospital2Spring.model.repository.PatientRepository;
import hospital2Spring.model.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;

public class PatientServiceImpl implements PatientService{
	
	@Autowired
	PatientRepository patientRepository;
	
	public PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public Patient findPatientByRoomNameSurname(int room, String name, String surname) {
		return patientRepository.findPatientByRoomNameSurname(room, name, surname);
	}

	@Override
	public void setNewDoctor(Patient patient) {
		patientRepository.save(patient);
	}

	@Override
	public List<Patient> getListOfPatientsInHospital() {
		return patientRepository.getListOfPatientsInHospital();
	}

	@Override
	public void dischargePatientById(int id) {
		patientRepository.dischargePatientById(id);
	}


	@Override
	public void savePatientWithDiagnosis(Patient patient) {
		patientRepository.save(patient);
		
	}

}
