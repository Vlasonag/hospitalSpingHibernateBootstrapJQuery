package hospital2Spring;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hospital2Spring.model.entity.Diagnosis;
import hospital2Spring.model.entity.Patient;
import hospital2Spring.model.entity.User;
import hospital2Spring.model.repository.PatientRepository;
import hospital2Spring.model.service.impl.MakeFindEditDiagnosisServiceImpl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MakeFindEditDiagnosisServiceTest {
	
	@InjectMocks
	MakeFindEditDiagnosisServiceImpl service;
	
	@Mock
	PatientRepository repository;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	@Test
	public void savePatientWithDiagnosisTest(){
		Patient patient = new Patient(1, "Test", "Test");
		Diagnosis diagnosis = new Diagnosis("Test", "Test", "Test", "Test", "Test");
		User user = new User("Test", "Test", "Test", "Test", "Test");
		patient.setDoctor(user);
		diagnosis.setDoctor(user);
		diagnosis.setPatient(patient);
		patient.setDiagnosis(diagnosis);
		service.savePatientWithDiagnosis(patient, diagnosis, user);
		verify(repository, times(1)).save(patient);
	}
	@Test
	public void isRoomBusyTest(){
		int room = 420;
		service.isRoomBusy(room);
		List<Patient> list = new ArrayList<>();
		list.add(new Patient(421,"Test", "Test"));
		assertFalse(list.stream().anyMatch(var -> var.getRoom() == room));
		list.add(new Patient(420,"Test", "Test"));
		assertTrue(list.stream().anyMatch(var -> var.getRoom() == room));
	}
	@Test
	public void isPatientExistForDoctorTest(){
		Patient patient = new Patient(420,"Test", "Test");
		Set<Patient> list = new HashSet<>();
		list.add(patient);
		assertTrue(list.stream().anyMatch(var -> var == patient));
	}
	
	@Test
	public void editDiagnosisForPatientTest(){
		Diagnosis diagnosis = new Diagnosis("Test", "Test", "Test", "Test", "Test");
		Diagnosis newDiagnosis = new Diagnosis();
		newDiagnosis.setConclusion(diagnosis.getConclusion());
		newDiagnosis.setDescription(diagnosis.getDescription());
		newDiagnosis.setMedicines(diagnosis.getMedicines());
		newDiagnosis.setOperations(diagnosis.getOperations());
		newDiagnosis.setProcedures(diagnosis.getProcedures());
		assertEquals(newDiagnosis.getConclusion(), diagnosis.getConclusion());
		assertEquals(newDiagnosis.getDescription(), diagnosis.getDescription());
		assertEquals(newDiagnosis.getMedicines(), diagnosis.getMedicines());
		assertEquals(newDiagnosis.getOperations(), diagnosis.getOperations());
		assertEquals(newDiagnosis.getProcedures(), diagnosis.getProcedures());
		
	}
}
