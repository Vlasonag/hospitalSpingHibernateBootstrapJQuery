package hospital2Spring;

import hospital2Spring.model.repository.DiagnosisRepository;
import hospital2Spring.model.service.impl.DiagnosisServiceImpl;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DiagnosisServiceTest {
	
	@InjectMocks
	DiagnosisServiceImpl service;
	
	@Mock
	DiagnosisRepository repository;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void setNewDoctor() {
		int doctor_id = 1;
		int patient_id = 1;	
		service.setNewDoctor(doctor_id, patient_id);
		verify(repository, times(1)).setNewDoctor(doctor_id, patient_id);
	}
}
