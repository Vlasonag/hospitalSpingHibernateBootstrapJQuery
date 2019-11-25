package hospital2Spring.model.repository;

import java.util.List;

import javax.transaction.Transactional;

import hospital2Spring.model.entity.Patient;
import hospital2Spring.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
		@Query("SELECT u FROM Patient u WHERE u.id = :id")
		Patient findPatientById(@Param("id")int id);
		
		@Query("SELECT u FROM Patient u WHERE u.room = :room AND u.name = :name AND u.surname = :surname")
		Patient findPatientByRoomNameSurname(@Param("room")int room, @Param("name")String name, @Param("surname")String surname);
		
		@Modifying
		@Query("UPDATE Patient SET doctor_id = :doctor_id WHERE id = :id")
		@Transactional
		void setNewDoctor(@Param("doctor_id")int doctor_id, @Param("id")int id);
		
		@Query("SELECT u FROM Patient u WHERE u.inHospital = 1")
		List<Patient> getListOfPatientsInHospital();
		
		@Modifying
		@Query("UPDATE Patient SET inHospital = 0 WHERE id = :id")
		@Transactional
		void dischargePatientById(@Param("id")int id);

		void save(User user);
		
}
