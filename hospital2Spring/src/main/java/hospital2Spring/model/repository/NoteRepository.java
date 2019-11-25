package hospital2Spring.model.repository;

import java.util.List;

import hospital2Spring.model.entity.Note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer>{
	
	@Query(value = "SELECT u FROM Note u")
	List<Note> findAllNotes();

	@Transactional
	@Modifying
	@Query(value = "INSERT INTO user_patient (user_id, patient_id) VALUES (:user_id, :patient_id);", 
			  nativeQuery = true)
	void saveRelation(@Param("patient_id")int patient_id, @Param("user_id")int user_id);
	
}
