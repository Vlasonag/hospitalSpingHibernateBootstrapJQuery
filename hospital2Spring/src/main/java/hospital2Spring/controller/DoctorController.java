package hospital2Spring.controller;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import hospital2Spring.model.entity.Diagnosis;
import hospital2Spring.model.entity.Note;
import hospital2Spring.model.entity.Patient;
import hospital2Spring.model.entity.User;
import hospital2Spring.model.service.DiagnosisService;
import hospital2Spring.model.service.MakeFindEditDiagnosisService;
import hospital2Spring.model.service.NoteService;
import hospital2Spring.model.service.PatientService;
import hospital2Spring.model.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "doctor")
@PreAuthorize("hasRole('DOCTOR')")
public class DoctorController {
	
	@Autowired
	UserService userService;
	@Autowired
	PatientService patientService;
	@Autowired
	NoteService noteService;
	@Autowired
	MakeFindEditDiagnosisService makeFindEditDiagnosisService;
	
	public DoctorController(UserService userService, PatientService patientService, 
							MakeFindEditDiagnosisService makeFindEditDiagnosisService, NoteService noteService) {
		this.userService = userService;
		this.patientService = patientService;
		this.noteService = noteService;
		this.makeFindEditDiagnosisService = makeFindEditDiagnosisService;
	}
	
	@RequestMapping(value = "/diagnosis/make", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView makeDiagnosis(HttpServletRequest request, @RequestParam int room, @RequestParam String name, 
										@RequestParam String surname, @RequestParam String description, 
										@RequestParam String conclusion, @RequestParam String procedures, 
										@RequestParam String medicines, @RequestParam String operation,
										Authentication authentication) {
		
		ModelAndView mav;
		Patient patient = new Patient(room, name, surname);
		Diagnosis diagnosis = new Diagnosis(description, conclusion, procedures, medicines, operation);
		User user = userService.findUserByLogin(authentication.getName());
		if(makeFindEditDiagnosisService.isRoomBusy(room) == true) {
			mav = new ModelAndView("make_diagnosis_page");
			mav.addObject("msg1", "Room is busy");
			return mav;
		}
		makeFindEditDiagnosisService.savePatientWithDiagnosis(patient, diagnosis, user);
		
		mav = new ModelAndView("make_diagnosis_page");
		return mav;
	}
	
	@RequestMapping(value = "/diagnosis/find", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView findDiagnosis(HttpServletRequest request, @RequestParam int room, @RequestParam String name, 
										@RequestParam String surname, Authentication authentication) {
		
		ModelAndView mav;
		Patient patient = patientService.findPatientByRoomNameSurname(room, name, surname);
		User user = userService.findUserByLogin(authentication.getName());
		
		if(makeFindEditDiagnosisService.isPatientExistForDoctor(patient, user) == false 
				|| patientService.findPatientByRoomNameSurname(room, name, surname) == null) {
			
			mav = new ModelAndView("make_diagnosis_page");
			mav.addObject("msg", "Patient not found");
			return mav;
		}
		mav = new ModelAndView("make_diagnosis_page");
		mav.addObject("patient", patient);
		mav.addObject("diagnosis", patient.getDiagnosis());
		mav.addObject("msg", "Patient found, you can edit diagnosis");
		return mav;
	}
	
	
	@RequestMapping(value = "/diagnosis/edit", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ModelAndView editDiagnosis(HttpServletRequest request, @RequestParam String description, 
										@RequestParam String conclusion, @RequestParam String procedures, 
										@RequestParam String medicines, @RequestParam String operation, Authentication authentication) {
		
		ModelAndView mav;
		try{
			int room = Integer.parseInt(request.getParameter("room").toString());
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			Patient patient = patientService.findPatientByRoomNameSurname(room, name, surname);
			Diagnosis diagnosis = new Diagnosis(description, conclusion, procedures, medicines, operation);
			makeFindEditDiagnosisService.editDiagnosisForPatient(patient, diagnosis);
			patientService.savePatientWithDiagnosis(patient);
			mav = new ModelAndView("make_diagnosis_page");
			return mav;
		}
		catch (Exception e) {
			
			mav = new ModelAndView("make_diagnosis_page");	
			mav.addObject("msg", "Find patient first, then edit diagnosis");
			return mav;
		}
	}
	
	@RequestMapping(value = "/diagnosis", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView makeFindEditDiagnosisPage(HttpServletRequest request) {
		ModelAndView mav;
		mav = new ModelAndView("make_diagnosis_page");
		return mav;
	}
	
	@RequestMapping(value = "/operations", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView operationsPage(HttpServletRequest request) {
		ModelAndView mav;
		mav = new ModelAndView("operations_page");
		return mav;
	}
	@RequestMapping(value = "/operations/find", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView operationsFind(HttpServletRequest request, @RequestParam int room, @RequestParam String name, 
											@RequestParam String surname, Authentication authentication) {
		
		ModelAndView mav;
		Patient patient = patientService.findPatientByRoomNameSurname(room, name, surname);
		User user = userService.findUserByLogin(authentication.getName());
		
		if(makeFindEditDiagnosisService.isPatientExistForDoctor(patient, user) == false 
				|| patientService.findPatientByRoomNameSurname(room, name, surname) == null) {
			
			mav = new ModelAndView("operations_page");
			mav.addObject("msg", "Patient not found");
			return mav;
		}
		mav = new ModelAndView("operations_page");
		mav.addObject("patient", patient);
		mav.addObject("diagnosis", patient.getDiagnosis());
		return mav;
	}
	@RequestMapping(value = "/operations/find/note", method = {RequestMethod.POST, RequestMethod.GET})
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
			mav = new ModelAndView("redirect:/doctor/operations");
			return mav;
		}catch (Exception e) {
			mav = new ModelAndView("operations_page");	
			mav.addObject("msg", "Find patient first, then make note");
			return mav;
		}
	}
	
}
