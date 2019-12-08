package hospital2Spring.model.service.impl;

import java.util.List;  


import hospital2Spring.model.entity.Note;
import hospital2Spring.model.entity.Patient;
import hospital2Spring.model.entity.User;
import hospital2Spring.model.repository.NoteRepository;
import hospital2Spring.model.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;

public class NoteServiceImpl implements NoteService{
	@Autowired
	NoteRepository noteRepository;
	
	
	public NoteServiceImpl(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	@Override
	public void createNote(Note note, Patient patient, User user) { 
		note.setDiagnosis(patient.getDiagnosis());
		note.setUser(user); 
		noteRepository.save(note);
		noteRepository.saveRelation(patient.getId(), user.getId());
		
	}

	public List<Note> findAllNotes() {
		return noteRepository.findAllNotes();
	}
}
