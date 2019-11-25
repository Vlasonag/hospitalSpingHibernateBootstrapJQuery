package hospital2Spring.controller;

import hospital2Spring.model.entity.Note; 
import hospital2Spring.model.entity.Patient;
import hospital2Spring.util.NoteComparator;
import hospital2Spring.util.NoteDTO;
import hospital2Spring.model.entity.User;
import hospital2Spring.model.service.DiagnosisService;
import hospital2Spring.model.service.NoteService;
import hospital2Spring.model.service.PatientService;
import hospital2Spring.model.service.UserService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestControllerClass {
	
	@Autowired
	UserService userService;
	PatientService patientService;
	DiagnosisService diagnosisService;
	NoteService noteService;
	
	List<NoteDTO> currentList;
	int sorted = 0;
	
	
	public RestControllerClass(UserService userService, PatientService patientService, 
			DiagnosisService diagnosisService, NoteService noteService) {
		this.userService = userService;
		this.patientService = patientService;
		this.diagnosisService = diagnosisService;
		this.noteService = noteService;
	}
	
    @PostMapping("/journal/all") 
    public ResponseEntity<List<NoteDTO>> postAllNotes(@RequestBody NoteDTO obj){
    	List<NoteDTO> list = new ArrayList<>();
    	List<Note> listOfNotes = noteService.findAllNotes();
    	listOfNotes.stream().forEach(var -> list.add(
    			new NoteDTO(var.getId(),var.getUser().getName(), var.getUser().getSurname(), var.getUser().getId(), 
	    					var.getDiagnosis().getProcedures(), var.getDiagnosis().getMedicines(), 
	    					var.getDiagnosis().getOperations(), Timestamp.valueOf(var.getDate().toLocalDateTime().plusHours(6)), 
	    					var.getCommentary(), var.getDiagnosis().getPatient().getRoom(), 
	    					var.getDiagnosis().getPatient().getName(), var.getDiagnosis().getPatient().getSurname())));
    	currentList = list;
    	list.get(0).setNumberPerPage(5);
    	
    	list.get(0).setNumberOfPages((int)(Math.ceil(list.size() * 1.0/list.get(0).getNumberPerPage())));
    	
    	list.get(0).setCurrentPage(1);
    	return new ResponseEntity<List<NoteDTO>>(list, HttpStatus.OK);
    }
    
    @PostMapping("/journal/my") 
    public ResponseEntity<List<NoteDTO>> postMyNotes(Authentication authentication, @RequestBody NoteDTO obj){
    	User user = userService.findUserByLogin(authentication.getName());
    	List<NoteDTO> list = new ArrayList<>();
    	List<Note> listOfNotes = noteService.findAllNotes();
    	
    	listOfNotes.stream().filter(var -> var.getUser().getId() == user.getId()).forEach(var -> list.add(
    			new NoteDTO(var.getId(),var.getUser().getName(), var.getUser().getSurname(), var.getUser().getId(), 
    					var.getDiagnosis().getProcedures(), var.getDiagnosis().getMedicines(), 
    					var.getDiagnosis().getOperations(), Timestamp.valueOf(var.getDate().toLocalDateTime().plusHours(6)), 
    					var.getCommentary(), var.getDiagnosis().getPatient().getRoom(), 
    					var.getDiagnosis().getPatient().getName(), var.getDiagnosis().getPatient().getSurname())));
    	currentList = list;
    	return new ResponseEntity<List<NoteDTO>>(list, HttpStatus.OK);
    }
    @PostMapping("/journal/find/patient")  
    public ResponseEntity<List<NoteDTO>> getNotes(Authentication authentication, @RequestBody NoteDTO obj){
    	Patient patient = patientService.findPatientByRoomNameSurname(obj.getRoom(), obj.getWorker_name(), obj.getWorker_surname());
    	List<NoteDTO> list = new ArrayList<>();
    	List<Note> listOfNotes = noteService.findAllNotes();
    	
    	listOfNotes.stream().filter(var -> var.getDiagnosis().getId() == patient.getDiagnosis().getId()).forEach(var -> list.add(
    			new NoteDTO(var.getId(),var.getUser().getName(), var.getUser().getSurname(), var.getUser().getId(), 
    					var.getDiagnosis().getProcedures(), var.getDiagnosis().getMedicines(), 
    					var.getDiagnosis().getOperations(), Timestamp.valueOf(var.getDate().toLocalDateTime().plusHours(6)), 
    					var.getCommentary(), var.getDiagnosis().getPatient().getRoom(), 
    					var.getDiagnosis().getPatient().getName(), var.getDiagnosis().getPatient().getSurname())));
    	currentList = list;
    	return new ResponseEntity<List<NoteDTO>>(list, HttpStatus.OK);
    }
    
    @PostMapping("/journal/sort") 
    public ResponseEntity<List<NoteDTO>> getList(){
    	if(sorted == 0) {
    		currentList = currentList.stream().sorted(new NoteComparator()).collect(Collectors.toList());
    		sorted = 1;
    		return new ResponseEntity<List<NoteDTO>>(currentList, HttpStatus.OK);
    	}
    	else{
    		Collections.reverse(currentList);
    		sorted = 0;
    		return new ResponseEntity<List<NoteDTO>>(currentList, HttpStatus.OK);
    	}
    }
}