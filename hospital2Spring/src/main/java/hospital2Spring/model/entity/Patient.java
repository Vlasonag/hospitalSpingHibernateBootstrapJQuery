package hospital2Spring.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "room")
	private int room;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "inHospital")
	private int inHospital;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
	private Diagnosis diagnosis;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private User doctor;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_patient", 
        joinColumns = { @JoinColumn(name = "patient_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
	private Set<User> listOfWorkers;

	
	
	public Patient(Diagnosis diagnosis) {
		super();
		this.diagnosis = diagnosis;
	}
	public Patient() {
		
	}
	public Patient(int room, String name, String surname, int inHospital) {
		super();
		this.room = room;
		this.name = name;
		this.surname = surname;
		this.inHospital = inHospital;
	}
	public Patient(int room, String name, String surname) {
		super();
		this.room = room;
		this.name = name;
		this.surname = surname;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getInHospital() {
		return inHospital;
	}

	public void setInHospital(int inHospital) {
		this.inHospital = inHospital;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}
	
	public Set<User> getListOfWorkers() {
		return listOfWorkers;
	}

	public void setListOfWorkers(Set<User> listOfWorkers) {
		this.listOfWorkers = listOfWorkers;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", room=" + room + ", name=" + name
				+ ", surname=" + surname + ", inHospital=" + inHospital
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((diagnosis == null) ? 0 : diagnosis.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + id;
		result = prime * result + inHospital;
		result = prime * result
				+ ((listOfWorkers == null) ? 0 : listOfWorkers.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + room;
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (diagnosis == null) {
			if (other.diagnosis != null)
				return false;
		} else if (!diagnosis.equals(other.diagnosis))
			return false;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (id != other.id)
			return false;
		if (inHospital != other.inHospital)
			return false;
		if (listOfWorkers == null) {
			if (other.listOfWorkers != null)
				return false;
		} else if (!listOfWorkers.equals(other.listOfWorkers))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (room != other.room)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
}
