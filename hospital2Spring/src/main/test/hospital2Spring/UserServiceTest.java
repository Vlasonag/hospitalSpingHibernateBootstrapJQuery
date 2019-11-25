package hospital2Spring;

import hospital2Spring.model.entity.Patient;
import hospital2Spring.model.entity.User;
import hospital2Spring.model.repository.UserRepository;
import hospital2Spring.model.service.impl.UserServiceImpl;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@InjectMocks
	UserServiceImpl service;
	
	@Mock
	UserRepository repository;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void findUserByLogin() {
		String login = "Vlas";
		service.findUserByLogin(login);
		verify(repository, times(1)).findUserByLogin(login);
	}
	
	@Test
	public void findUserById() {
		int id = 1;
		service.findUserById(id);
		verify(repository, times(id)).findUserById(id);
	}
	
	@Test
	public void findAllDoctors() {
		List<User> list = new ArrayList<>();
		list.add(new User("Test", "Test", "Test", "Test", "doctor"));
		list.add(new User("Test", "Test", "Test", "Test", "doctor"));
		list.add(new User("Test", "Test", "Test", "Test", "doctor"));
		list.add(new User("Test", "Test", "Test", "Test", "doctor"));
		list.add(new User("Test", "Test", "Test", "Test", "doctor"));
		long size = list.stream().filter(var -> var.getRole().equals("doctor")).count();
		assertTrue(size == 5);

	}
	
	@Test
	public void save(){
		User user = new User("Test", "Test", "Test", "Test", "doctor");
		service.save(user);
		verify(repository, times(1)).save(user);
	}
}
