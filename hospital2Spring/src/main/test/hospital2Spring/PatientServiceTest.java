package hospital2Spring;

import java.util.ArrayList; 
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import hospital2Spring.model.entity.Diagnosis;
import hospital2Spring.model.entity.Patient;
import hospital2Spring.model.entity.User;
import hospital2Spring.model.repository.PatientRepository;
import hospital2Spring.model.service.impl.PatientServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {
	
	@InjectMocks
	PatientServiceImpl service;
	
	@Mock
	PatientRepository repository;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	@Test
	public void findPatientByRoomNameSurname() {
		int room = 420;
		String name = "Test";
		String surname = "Test";
		service.findPatientByRoomNameSurname(room, name, surname);
		verify(repository, times(1)).findPatientByRoomNameSurname(room, name, surname);
		
	}
	
	@Test
	public void setNewDoctor() {
		Patient patient = new Patient(1, "Test", "Test");
		User user = new User("Test", "Test", "Test", "Test", "Test");
		patient.setDoctor(user);
		assertEquals(patient.getDoctor(), user);
	}
	
	@Test
	public void getListOfPatientsInHospital() {
		List<Patient> list = new ArrayList<>();
		List<Patient> actualList = new ArrayList<>();
		list.add(new Patient(1, "Test", "Test", 1));
		list.add(new Patient(2, "Test", "Test", 1));
		list.add(new Patient(3, "Test", "Test", 0));
		list.stream().filter(var -> var.getInHospital() == 1).forEach(var -> actualList.add(var));
		assertEquals(actualList.size(), 2);
		
	}
	@Test
	public void dischargePatientById() {
		int id = 5;
		service.dischargePatientById(id);
		verify(repository, times(1)).dischargePatientById(id);
	}

	@Test
	public void savePatientWithDiagnosis() {
		Patient patient = new Patient(1, "Test", "Test");
		Diagnosis diagnosis = new Diagnosis("Test", "Test", "Test", "Test", "Test");
		patient.setDiagnosis(diagnosis);
		service.savePatientWithDiagnosis(patient);
		verify(repository, times(1)).save(patient);
	}
}
