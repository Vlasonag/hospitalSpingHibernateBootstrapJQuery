package hospital2Spring.controller;

import hospital2Spring.model.entity.Note;
import hospital2Spring.model.entity.Patient;
import hospital2Spring.model.entity.User;
import hospital2Spring.model.service.DiagnosisService;
import hospital2Spring.model.service.NoteService;
import hospital2Spring.model.service.PatientService;
import hospital2Spring.model.service.UserService;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("hasRole('DOCTOR') or hasRole('NURSE')")
public class NurseController {
	
	@Autowired
	UserService userService;
	PatientService patientService;
	NoteService noteService;
	
	public NurseController(UserService userService, PatientService patientService, 
			DiagnosisService diagnosisService, NoteService noteService) {
		this.userService = userService;
		this.patientService = patientService;
		this.noteService = noteService;
	}

	@RequestMapping(value = "/procedures_medicines", method = {RequestMethod.POST, RequestMethod.GET})
	@PreAuthorize("hasRole('DOCTOR') or hasRole('NURSE')")
	public ModelAndView operationsPage(HttpServletRequest request) {
		ModelAndView mav;
		mav = new ModelAndView("procedures_and_medicines_page");
		return mav;
	}
	
	@RequestMapping(value = "/procedures_medicines/find", method = {RequestMethod.POST, RequestMethod.GET})
	@PreAuthorize("hasRole('DOCTOR') or hasRole('NURSE')")
	public ModelAndView operationsFind(HttpServletRequest request, @RequestParam int room, @RequestParam String name, 
											@RequestParam String surname) {
		
		ModelAndView mav;
		Patient patient = patientService.findPatientByRoomNameSurname(room, name, surname);
		
		if(patientService.findPatientByRoomNameSurname(room, name, surname) == null) {
			
			mav = new ModelAndView("procedures_and_medicines_page");
			mav.addObject("msg", "Patient not found");
			return mav;
		}
		mav = new ModelAndView("procedures_and_medicines_page");
		mav.addObject("patient", patient);
		mav.addObject("diagnosis", patient.getDiagnosis());
		return mav;
	}
	
	@RequestMapping(value = "/procedures_medicines/find/note", method = {RequestMethod.POST, RequestMethod.GET})
	@PreAuthorize("hasRole('DOCTOR') or hasRole('NURSE')")
	public ModelAndView operationsNote(HttpServletRequest request, @RequestParam String commentary, Authentication auth) {
		
		ModelAndView mav;
		try{
			int room = Integer.parseInt(request.getParameter("room").toString());
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			
			User user = userService.findUserByLogin(auth.getName());
			Patient patient = patientService.findPatientByRoomNameSurname(room, name, surname);
			LocalDateTime now = LocalDateTime.now().minusHours(3);
			Timestamp sqlNow = Timestamp.valueOf(now);
			sqlNow.toInstant().minus(Duration.ofHours(3));
			Note note = new Note (commentary, sqlNow);
			noteService.createNote(note, patient, user);
			mav = new ModelAndView("redirect:/procedures_medicines");
			return mav;
		}catch (Exception e) {
			mav = new ModelAndView("procedures_and_medicines_page");	
			mav.addObject("msg", "Find patient first, then make note");
			return mav;
		}
	}
}
