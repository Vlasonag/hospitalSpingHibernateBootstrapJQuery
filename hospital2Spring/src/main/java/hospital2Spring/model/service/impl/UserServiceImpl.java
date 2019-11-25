package hospital2Spring.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hospital2Spring.model.entity.User;
import hospital2Spring.model.repository.UserRepository;
import hospital2Spring.model.service.UserService;

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findUserByLogin(String login) {
		return userRepository.findUserByLogin(login);
	}

	@Override
	public User findUserById(int id) {
		return userRepository.findUserById(id);
	}

	@Override
	public List<User> findAllDoctors() {
		return userRepository.findAllDoctors();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}
}
