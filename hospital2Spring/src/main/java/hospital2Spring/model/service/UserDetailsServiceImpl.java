package hospital2Spring.model.service;


import hospital2Spring.model.entity.User;
import hospital2Spring.model.repository.UserRepository;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		
		User user = userRepository.findUserByLogin(login);
		UserBuilder builder = null;
	    if (user != null) {
	    	builder = org.springframework.security.core.userdetails.User.withUsername(login);
	        builder.password(user.getPassword());
	        String authorities = user.getRole();
	        builder.authorities(authorities);
	      } else {
	        throw new UsernameNotFoundException("User not found.");
	      }
	      return builder.build();
	    }
	
}
