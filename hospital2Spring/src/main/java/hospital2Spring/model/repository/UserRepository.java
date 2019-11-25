package hospital2Spring.model.repository;

import java.util.List;


import hospital2Spring.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.login = :login")
	User findUserByLogin(@Param("login")String login);
	
	@Query("SELECT u FROM User u WHERE u.id = :id")
	User findUserById(@Param("id")int id);
	
	@Query("SELECT u FROM User u WHERE u.role = 'ROLE_DOCTOR'")
	List<User> findAllDoctors();
	
}
