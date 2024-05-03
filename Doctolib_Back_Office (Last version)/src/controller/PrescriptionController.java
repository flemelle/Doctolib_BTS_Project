package controller;

public class PrescriptionController {
	public int idPrescription;
	public String datePrescription, content;
	public UserController patient, doctor;
	public PrescriptionController(int idPrescription, String datePrescription, String content, UserController patient, UserController doctor ) {
		this.idPrescription = idPrescription;
		this.datePrescription = datePrescription;
		this.content = content;
		this.patient = patient;
		this.doctor = doctor;
	}
	public int getIdPrescription() {
		return idPrescription;
	}
	public void setIdPrescription(int idPrescription) {
		this.idPrescription = idPrescription;
	}
	public String getDatePrescription() {
		return datePrescription;
	}
	public void setDatePrescription(String datePrescription) {
		this.datePrescription = datePrescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public UserController getPatient() {
		return patient;
	}
	public void setPatient(UserController patient) {
		this.patient = patient;
	}
	public UserController getDoctor() {
		return doctor;
	}
	public void setDoctor(UserController doctor) {
		this.doctor = doctor;
	}
}
