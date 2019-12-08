package hospital2Spring.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "diagnosis")
public class Diagnosis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "conclusion")
	private String conclusion;
	
	@Column(name = "procedures")
	private String procedures;
	
	@Column(name = "medicines")
	private String medicines;
	
	@Column(name = "operations")
	private String operations;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private Patient patient;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private User doctor;
	
	
	@OneToMany(mappedBy="diagnosis", fetch = FetchType.EAGER)
	private List<Note> listOfJournals;
	
	

	public Diagnosis(String description, String conclusion, String procedures,
			String medicines, String operations) {
		super();
		this.description = description;
		this.conclusion = conclusion;
		this.procedures = procedures;
		this.medicines = medicines;
		this.operations = operations;
	}
	public Diagnosis() {
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getProcedures() {
		return procedures;
	}

	public void setProcedures(String procedures) {
		this.procedures = procedures;
	}

	public String getMedicines() {
		return medicines;
	}

	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}

	public String getOperations() {
		return operations;
	}

	public void setOperations(String operations) {
		this.operations = operations;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public List<Note> getListOfJournals() {
		return listOfJournals;
	}

	public void setListOfJournals(List<Note> listOfJournals) {
		this.listOfJournals = listOfJournals;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((conclusion == null) ? 0 : conclusion.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((medicines == null) ? 0 : medicines.hashCode());
		result = prime * result
				+ ((operations == null) ? 0 : operations.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		result = prime * result
				+ ((procedures == null) ? 0 : procedures.hashCode());
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
		Diagnosis other = (Diagnosis) obj;
		if (conclusion == null) {
			if (other.conclusion != null)
				return false;
		} else if (!conclusion.equals(other.conclusion))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (medicines == null) {
			if (other.medicines != null)
				return false;
		} else if (!medicines.equals(other.medicines))
			return false;
		if (operations == null) {
			if (other.operations != null)
				return false;
		} else if (!operations.equals(other.operations))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		if (procedures == null) {
			if (other.procedures != null)
				return false;
		} else if (!procedures.equals(other.procedures))
			return false;
		return true;
	}
	
	
	
}
