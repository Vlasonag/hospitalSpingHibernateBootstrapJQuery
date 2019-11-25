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
	
	
	
}
