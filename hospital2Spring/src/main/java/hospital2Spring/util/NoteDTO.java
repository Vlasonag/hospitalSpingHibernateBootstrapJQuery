package hospital2Spring.util;

import java.sql.Timestamp;

public class NoteDTO {
	
	private int note_id;
	private String worker_name;
	private String worker_surname;
	private int worker_id;
	private String procedures;
	private String medicines;
	private String operation;
	private Timestamp date;
	private String commentary;
	private int room; 
	private String patient_name;
	private String patient_surname;
	private int currentPage;
	private int numberOfPages;
	private int numberPerPage;
	public NoteDTO() {
		
	}
	public NoteDTO(int note_id, String worker_name, String worker_surname,
			int worker_id, String procedures, String medicines,
			String operation, Timestamp date, String commentary, int room, String patient_name, String patient_surname) {
		super();
		this.note_id = note_id;
		this.worker_name = worker_name;
		this.worker_surname = worker_surname;
		this.worker_id = worker_id;
		this.procedures = procedures;
		this.medicines = medicines;
		this.operation = operation;
		this.date = date;
		this.commentary = commentary;
		this.room = room;
		this.patient_name = patient_name; 
		this.patient_surname = patient_surname;
	}
	
	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getNote_id() {
		return note_id;
	}

	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}

	public String getWorker_name() {
		return worker_name;
	}

	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}

	public String getWorker_surname() {
		return worker_surname;
	}

	public void setWorker_surname(String worker_surname) {
		this.worker_surname = worker_surname;
	}

	public int getWorker_id() {
		return worker_id;
	}

	public void setWorker_id(int worker_id) {
		this.worker_id = worker_id;
	}

	public String getProcedures() {
		return procedures;
	}
	
	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getPatient_surname() {
		return patient_surname;
	}

	public void setPatient_surname(String patient_surname) {
		this.patient_surname = patient_surname;
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

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public int getNumberPerPage() {
		return numberPerPage;
	}
	public void setNumberPerPage(int numberPerPage) {
		this.numberPerPage = numberPerPage;
	}
	
	
}
