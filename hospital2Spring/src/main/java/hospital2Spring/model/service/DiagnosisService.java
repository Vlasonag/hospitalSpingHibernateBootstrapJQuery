package hospital2Spring.model.service;

import org.springframework.stereotype.Service;

@Service
public interface DiagnosisService {

	void setNewDoctor(int doctor_id, int patient_id);

}
