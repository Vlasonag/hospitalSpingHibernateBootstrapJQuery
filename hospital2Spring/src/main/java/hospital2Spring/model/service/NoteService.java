package hospital2Spring.model.service;

import java.util.List; 

import org.springframework.stereotype.Service;

import hospital2Spring.model.entity.Note;
import hospital2Spring.model.entity.Patient;
import hospital2Spring.model.entity.User;
@Service
public interface NoteService {

	void createNote(Note note, Patient patient, User user);
	
	List<Note> findAllNotes();
}
