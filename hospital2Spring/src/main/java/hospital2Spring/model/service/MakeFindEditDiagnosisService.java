package hospital2Spring.model.service;

import org.springframework.stereotype.Service;

import hospital2Spring.model.entity.Diagnosis;
import hospital2Spring.model.entity.Patient;
import hospital2Spring.model.entity.User;
@Service
public interface MakeFindEditDiagnosisService {
	
	void savePatientWithDiagnosis(Patient patient, Diagnosis diagnosis, User user);
	
	boolean isRoomBusy(int room);
	
	boolean isPatientExistForDoctor(Patient patient, User user);
	
	void editDiagnosisForPatient(Patient patient, Diagnosis diagnosis);
	
}
