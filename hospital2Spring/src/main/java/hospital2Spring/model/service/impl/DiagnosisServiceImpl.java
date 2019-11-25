package hospital2Spring.model.service.impl;

import hospital2Spring.model.repository.DiagnosisRepository;
import hospital2Spring.model.service.DiagnosisService;

import org.springframework.beans.factory.annotation.Autowired;

public class DiagnosisServiceImpl implements DiagnosisService{
	@Autowired
	DiagnosisRepository diagnosisRepository;
	
	public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository) {
		this.diagnosisRepository = diagnosisRepository;
	}
	@Override
	public void setNewDoctor(int doctor_id, int patient_id) {
		diagnosisRepository.setNewDoctor(doctor_id, patient_id);
	}
}
