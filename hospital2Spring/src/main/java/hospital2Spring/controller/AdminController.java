package hospital2Spring.controller;

import java.util.List; 

import hospital2Spring.model.entity.Patient;
import hospital2Spring.model.entity.User;
import hospital2Spring.model.service.PatientService;
import hospital2Spring.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
	
	@Autowired
	UserService userService;
	@Autowired
	PatientService patientService;
	
	public AdminController(UserService userService, PatientService patientService) {
		this.userService = userService;
		this.patientService = patientService;
	}
	
	@RequestMapping(value = "/change_doctor", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView changeDoctorPage(HttpServletRequest request) {
		ModelAndView mav ;
		List<User> listOfDoctors = userService.findAllDoctors();
		mav = new ModelAndView("change_doctor");
		mav.addObject("listOfDoctors", listOfDoctors);
		return mav;
	}
	
	@RequestMapping(value = "/change_doctor/change", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView changeDoctor(HttpServletRequest request, @RequestParam int room, @RequestParam String name, 
																@RequestParam String surname, @RequestParam String doctor_id) {
		
		int doc_id = Integer.parseInt(doctor_id);
		ModelAndView mav = new ModelAndView("redirect:/admin/change_doctor");
		Patient patient = patientService.findPatientByRoomNameSurname(room, name, surname);
		User user = userService.findUserById(doc_id);
		patient.setDoctor(user);
		patient.getDiagnosis().setDoctor(user);
		patientService.setNewDoctor(patient);
		return mav;
	}
	
	@RequestMapping(value = "/discharge", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView dischargePatientPage(HttpServletRequest request) {
		ModelAndView mav;
		List<Patient> listOfPatients = patientService.getListOfPatientsInHospital();
		mav = new ModelAndView("discharge_page");
		mav.addObject("listOfPatients", listOfPatients);
		return mav;
	}
	
	@RequestMapping(value = "/discharge/patient", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView dischargePatient(HttpServletRequest request, @RequestParam int patient_id) {
		
		patientService.dischargePatientById(patient_id);
		ModelAndView mav = new ModelAndView("redirect:/admin/discharge");
		return mav;
	}
	
	@RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView createPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("creation_page");
		return mav;
	}
	
	@RequestMapping(value = "/create/worker", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView createWorker(HttpServletRequest request, @RequestParam String login, @RequestParam String password,
			@RequestParam String name, @RequestParam String surname, @RequestParam String ROLE) {
		
		User user = new User(login, password, name, surname, ROLE);
		userService.save(user);
		ModelAndView mav = new ModelAndView("redirect:/admin/create");
		return mav;
	}
}
