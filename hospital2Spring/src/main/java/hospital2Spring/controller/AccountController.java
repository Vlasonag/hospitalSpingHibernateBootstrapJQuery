package hospital2Spring.controller;



import hospital2Spring.model.service.DiagnosisService;
import hospital2Spring.model.service.NoteService;
import hospital2Spring.model.service.PatientService;
import hospital2Spring.model.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController  implements ErrorController{
	
	@Autowired
	UserService userService;
	PatientService patientService;
	DiagnosisService diagnosisService;
	NoteService noteService;
	
	public AccountController(UserService userService, PatientService patientService, 
			DiagnosisService diagnosisService, NoteService noteService) {
		this.userService = userService;
		this.patientService = patientService;
		this.diagnosisService = diagnosisService;
		this.noteService = noteService;
	}
	
	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView startPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("login_page");
		return mav;
	}
	
	@RequestMapping(value = "/main", method = {RequestMethod.POST, RequestMethod.GET})
	@PreAuthorize("isAuthenticated()")
	public ModelAndView mainPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("main_page");
		return mav;
	}
	
	@RequestMapping(value = "/journal", method = {RequestMethod.POST, RequestMethod.GET})
	@PreAuthorize("isAuthenticated()")
	public ModelAndView journalPage(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("journal_page");
		mav.addObject("currentPage", 1);
		return mav;
	}
	
	@RequestMapping("error")
    public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	     
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	     
	        if(statusCode == HttpStatus.FORBIDDEN.value()) {
	            return "forbidden_page";
	        }
	        else {
	        	return "error_page";
	        }
	    }
	    return "error";
    }

	@Override
    public String getErrorPath() {
        return "/error";
    }
	
	
}
