package hospital2Spring.model.entity;

import java.sql.Timestamp; 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "note")
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "commentary")
	private String commentary;
	
	@Column(name = "date")
	private Timestamp date;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "diagnosis_id", nullable=false)
	private Diagnosis diagnosis;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "worker_id", referencedColumnName = "id")
	private User user;
	
	public Note() { 
		
	}
	public Note(String commentary, Timestamp date) {
		this.commentary = commentary;
		this.date = date;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", commentary=" + commentary + ", date="
				+ date + ", diagnosis=" + diagnosis + ", user=" + user + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commentary == null) ? 0 : commentary.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
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
		Note other = (Note) obj;
		if (commentary == null) {
			if (other.commentary != null)
				return false;
		} else if (!commentary.equals(other.commentary))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
