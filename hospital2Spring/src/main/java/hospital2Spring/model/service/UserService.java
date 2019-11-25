package hospital2Spring.model.service;

import java.util.List;


import org.springframework.stereotype.Service;

import hospital2Spring.model.entity.User;
@Service
public interface UserService {
	User findUserByLogin(String login);
	
	User findUserById(int id);
	
	List<User> findAllDoctors();
	
	void save(User user);
}
