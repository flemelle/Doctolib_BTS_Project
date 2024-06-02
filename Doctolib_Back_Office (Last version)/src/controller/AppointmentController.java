package controller;

import java.util.ArrayList;

import model.DeleteModel;
import model.InsertModel;
import model.SelectModel;
import model.UpdateModel;

public class AppointmentController {
	public int idAppointment;
	public String dateAppointment, timeAppointment, reason;
	public UserController patient, doctor;
	public AppointmentController(int idAppointment, String dateAppointment, String timeAppointment, String reason, UserController patient, UserController doctor ) {
		this.idAppointment = idAppointment;
		this.dateAppointment = dateAppointment;
		this.timeAppointment = timeAppointment;
		this.reason = reason;
		this.patient = patient;
		this.doctor = doctor;
	}
	public int getIdAppointment() {
		return idAppointment;
	}
	public void setIdAppointment(int idAppointment) {
		this.idAppointment = idAppointment;
	}
	public UserController getpatient() {
		return patient;
	}
	public void setpatient(UserController patient) {
		this.patient = patient;
	}
	public UserController getdoctor() {
		return doctor;
	}
	public void setdoctor(UserController doctor) {
		this.doctor = doctor;
	}
	public String getDateAppointment() {
		return dateAppointment;
	}
	public void setDateAppointment(String dateAppointment) {
		this.dateAppointment = dateAppointment;
	}
	public String getTimeAppointment() {
		return timeAppointment;
	}
	public void setTimeAppointment(String timeAppointment) {
		this.timeAppointment = timeAppointment;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public static ArrayList<AppointmentController> SelectAll() {
		return SelectModel.SelectAllAppointment();
	}
	public static AppointmentController Select(int idAppointment) {
		return SelectModel.SelectAppointment(idAppointment);
	}
	public void Delete() {
		DeleteModel.Delete(this);
	}
	public void Update() {
		UpdateModel.Update(this);
	}
	public void Add() {
		InsertModel.Insert(this);
	}
}