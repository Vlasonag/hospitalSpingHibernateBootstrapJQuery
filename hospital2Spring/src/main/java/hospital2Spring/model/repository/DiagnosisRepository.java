package hospital2Spring.model.repository;

import javax.transaction.Transactional;

import hospital2Spring.model.entity.Diagnosis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer>{

	@Modifying
	@Query("UPDATE Diagnosis SET doctor_id = :doctor_id WHERE patient_id = :patient_id")
	@Transactional
	void setNewDoctor(@Param("doctor_id")int doctor_id, @Param("patient_id")int patient_id);
	
	@Query("SELECT u FROM Diagnosis u WHERE u.id = :id")
	Diagnosis getById(@Param("id")int id);
}
