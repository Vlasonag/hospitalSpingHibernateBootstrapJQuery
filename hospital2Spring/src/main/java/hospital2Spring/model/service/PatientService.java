package hospital2Spring.model.service;

import java.util.List; 

import org.springframework.stereotype.Service;

import hospital2Spring.model.entity.Patient;
@Service
public interface PatientService {
	
	Patient findPatientByRoomNameSurname(int room, String name, String surname);
	
	void setNewDoctor(Patient patient);
	
	List<Patient> getListOfPatientsInHospital();
	
	void dischargePatientById(int id);

	//void changeId(Patient patient);
	
	void savePatientWithDiagnosis(Patient patient);

	
}
