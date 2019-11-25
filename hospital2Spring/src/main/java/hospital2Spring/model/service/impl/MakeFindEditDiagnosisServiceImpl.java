package hospital2Spring.model.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import hospital2Spring.model.entity.Diagnosis;
import hospital2Spring.model.entity.Patient;
import hospital2Spring.model.entity.User;
import hospital2Spring.model.repository.PatientRepository;
import hospital2Spring.model.service.MakeFindEditDiagnosisService;

public class MakeFindEditDiagnosisServiceImpl implements MakeFindEditDiagnosisService{
	
	@Autowired
	PatientRepository patientRepository;
	
	public MakeFindEditDiagnosisServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	@Override
	public void savePatientWithDiagnosis(Patient patient, Diagnosis diagnosis, User user) {
		patient.setInHospital(1);
		patient.setDoctor(user);
		diagnosis.setDoctor(user);
		diagnosis.setPatient(patient);
		patient.setDiagnosis(diagnosis);
		patientRepository.save(patient);
		
	}

	@Override
	public boolean isRoomBusy(int room) {
		 List<Patient> listOfPatients = patientRepository.getListOfPatientsInHospital();
		 return listOfPatients.stream().anyMatch(var -> var.getRoom() == room);
	}
	
	@Override 
	public boolean isPatientExistForDoctor(Patient patient, User user) {
		Set<Patient> listOfPatients = user.getListOfDiagnosisedPatients();
		return listOfPatients.stream().anyMatch(var -> var == patient);
	}

	@Override
	public void editDiagnosisForPatient(Patient patient, Diagnosis diagnosis) {
		Diagnosis newDiagnosis = patient.getDiagnosis();
		newDiagnosis.setConclusion(diagnosis.getConclusion());
		newDiagnosis.setDescription(diagnosis.getDescription());
		newDiagnosis.setMedicines(diagnosis.getMedicines());
		newDiagnosis.setOperations(diagnosis.getOperations());
		newDiagnosis.setProcedures(diagnosis.getProcedures());
	}
	
}
