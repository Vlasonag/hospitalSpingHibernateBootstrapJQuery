package hospital2Spring.config;

import hospital2Spring.util.NoPasswordEnconder;
import hospital2Spring.model.repository.DiagnosisRepository;
import hospital2Spring.model.repository.NoteRepository;
import hospital2Spring.model.repository.PatientRepository;
import hospital2Spring.model.repository.UserRepository;
import hospital2Spring.model.service.DiagnosisService;
import hospital2Spring.model.service.MakeFindEditDiagnosisService;
import hospital2Spring.model.service.NoteService;
import hospital2Spring.model.service.PatientService;
import hospital2Spring.model.service.UserService;
import hospital2Spring.model.service.impl.DiagnosisServiceImpl;
import hospital2Spring.model.service.impl.MakeFindEditDiagnosisServiceImpl;
import hospital2Spring.model.service.impl.NoteServiceImpl;
import hospital2Spring.model.service.impl.PatientServiceImpl;
import hospital2Spring.model.service.impl.UserServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AppConfig {
	
	UserRepository userRepository;
	PatientRepository patientRepository;
	DiagnosisRepository diagnosisRepository;
	NoteRepository noteRepository;
	
	@Bean 
    public PasswordEncoder passwordEncoder() {
        return new NoPasswordEnconder();
    }
	
	@Bean
	public UserService userService() {
		return new UserServiceImpl(userRepository);
	}
	
	@Bean
	public PatientService patientService() {
		return new PatientServiceImpl(patientRepository);
	}
	
	@Bean
	public DiagnosisService dianosisService() {
		return new DiagnosisServiceImpl(diagnosisRepository);
	}
	
	@Bean
	public NoteService noteService() {
		return new NoteServiceImpl(noteRepository);
	}
	
	@Bean
	public MakeFindEditDiagnosisService makeFindEditDiagnosisService() {
		return new MakeFindEditDiagnosisServiceImpl(patientRepository);
	}
}
