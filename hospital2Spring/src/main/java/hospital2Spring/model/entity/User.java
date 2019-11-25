package hospital2Spring.model.entity;

import java.util.Set;  

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "login")
	private String login;
	
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "role")
	private String role;
	
	
	@OneToMany(mappedBy="doctor", fetch = FetchType.EAGER)
	Set<Patient> listOfDiagnosisedPatients;
	
	@ManyToMany(mappedBy = "listOfWorkers", fetch = FetchType.EAGER)
	Set<Patient> listOfPatients;
	
	public User(int id, String login, String password, String name, String surname, String role) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.role = role;
	}
	
	public User(String login, String password, String name, String surname,
			String role) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.role = role;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public Set<Patient> getListOfPatients() {
		return listOfPatients;
	}

	public void setListOfPatients(Set<Patient> listOfPatients) {
		this.listOfPatients = listOfPatients;
	}
	
	public Set<Patient> getListOfDiagnosisedPatients() {
		return listOfDiagnosisedPatients;
	}

	public void setListOfDiagnosisedPatients(Set<Patient> listOfDiagnosisedPatients) {
		this.listOfDiagnosisedPatients = listOfDiagnosisedPatients;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password
				+ ", name=" + name + ", surname=" + surname + ", role=" + role
				+ "]";
	}
	
}
