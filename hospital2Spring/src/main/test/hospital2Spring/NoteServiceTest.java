package hospital2Spring;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import hospital2Spring.model.entity.Note;
import hospital2Spring.model.entity.Patient;
import hospital2Spring.model.entity.User;
import hospital2Spring.model.repository.NoteRepository;
import hospital2Spring.model.service.impl.NoteServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTest {
	
	@InjectMocks
	NoteServiceImpl service;
	
	@Mock
	NoteRepository repository;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void createNote() {
		Patient patient = new Patient(1, "Test", "Test");
		User user = new User("Test", "Test", "Test", "Test", "Test");
		Note note = new Note("Test", new Timestamp(1));
		service.createNote(note, patient, user);
		verify(repository, times(1)).save(note);
	}
	
	@Test
	public void findAllNotes() {
		List<Note> list = new ArrayList<Note>();
		list.add(new Note("Test1", new Timestamp(1)));
		list.add(new Note("Test2", new Timestamp(2)));
		assertEquals(list.get(0).getCommentary(), "Test1");
		assertEquals(list.get(1).getCommentary(), "Test2");
	}
}
