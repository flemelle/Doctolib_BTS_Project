package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.AppointmentController;
import controller.PrescriptionController;
import controller.UserController;

public class SelectModel {
	private static DBConnection bdd = new DBConnection ("localhost","btsProject","phpmyadmin","root");
	
	public static UserController VerifyCredential(String login, String password) {
		UserController user = null;
		String requete = "SELECT * FROM btsProject_User where mail = '"+login
				+ "' AND password ='"+password+"' AND role = 'admin';";
		try {
			bdd.Connect();
			//création d'un curseur pour exécuter la requete 
			Statement req = bdd.getMaConnexion().createStatement(); 
			//execution de la requete et récuperation d'un resultat -
			ResultSet data = req.executeQuery(requete); 
			//s'il y a un resultat, on récupere les champs 
			if (data.next()) {
				user = new UserController (
						data.getInt("idUser"),
						data.getString("lastName"), 
						data.getString("firstName"), 
						data.getString("mail"), 
						data.getString("address"), 
						data.getString("password"), 
						data.getString("role"),   
						data.getInt("age")
						);
			}
			req.close();
			bdd.Disconnect();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " +requete);
		}
		return user;
	}
	
	//#region User
	public static ArrayList<UserController> SelectAllUser(String role) {
		ArrayList<UserController> userList = new ArrayList<UserController>();
		String requete = "SELECT * FROM btsProject_User";
		if (role != null){
			requete += " WHERE role = '" + role + "';";
		}else
		{
			requete += ";";
		}
		try {
			bdd.Connect(); 
			Statement req = bdd.getMaConnexion().createStatement(); 
			ResultSet data = req.executeQuery(requete); 
			while (data.next()) {
				UserController user = new UserController (
						data.getInt("idUser"),
						data.getString("lastName"), 
						data.getString("firstName"),
						data.getString("mail"), 
						data.getString("address"), 
						data.getString("password"), 
						data.getString("role"), 
						data.getInt("age")
						);
				userList.add(user);
			}
			req.close();
			bdd.Disconnect();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return userList;
	}

	public static UserController SelectUser(int idUser) {
		UserController user = null;
		String requete = "SELECT * FROM btsProject_User WHERE idUser = '"+ idUser + "';";
		try {
			bdd.Connect(); 
			Statement req = bdd.getMaConnexion().createStatement(); 
			ResultSet data = req.executeQuery(requete); 
			if (data.next()) {
				user = new UserController (
					data.getInt("idUser"),
					data.getString("firstName"),
					data.getString("lastName"), 
					data.getString("mail"), 
					data.getString("address"), 
					data.getString("password"), 
					data.getString("role"), 
					data.getInt("age")
					);
				req.close();
				bdd.Disconnect();
			}
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
			System.out.println("Erreur : " + exp);
		}
		return user;
	}
	//#endregion
	//#region Appointment
	public static ArrayList<AppointmentController> SelectAllAppointment() {
		ArrayList<AppointmentController> appointmentList = new ArrayList<AppointmentController>();
		String requete = "SELECT * FROM btsProject_Appointment;";
		try {
			bdd.Connect(); 
			Statement req = bdd.getMaConnexion().createStatement(); 
			ResultSet data = req.executeQuery(requete); 
			// UserController patient = new UserController();	
			// UserController doctor = new UserController();	
			while (data.next()) {
				UserController patient = SelectUser(data.getInt("idPatient"));	
				UserController doctor = SelectUser(data.getInt("idDoctor"));		
				AppointmentController appointment = new AppointmentController (
					data.getInt("idAppointment"),
					data.getString("dateAppointment"),
					data.getString("timeAppointment"),
					data.getString("reason"),
					patient,
					doctor
					);
				appointmentList.add(appointment);
			}
			req.close();
			bdd.Disconnect();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return appointmentList;
	}
	public static AppointmentController SelectAppointment(int idAppointment) {
		AppointmentController appointment = null;
		String requete = "SELECT * FROM btsProject_Appointment WHERE idAppointment = '" + idAppointment + "';";
		try {
			bdd.Connect(); 
			Statement req = bdd.getMaConnexion().createStatement(); 
			ResultSet data = req.executeQuery(requete);
			while (data.next()) {
				UserController patient = SelectUser(data.getInt("idPatient"));	
				UserController doctor = SelectUser(data.getInt("idDoctor"));		
				appointment = new AppointmentController (
					data.getInt("idAppointment"),
					data.getString("dateAppointment"),
					data.getString("timeAppointment"),
					data.getString("reason"),
					patient,
					doctor
					);
			}
			req.close();
			bdd.Disconnect();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return appointment;
	}
	//endregion
	//#region Prescription
	public static ArrayList<PrescriptionController> SelectAllPrescription() {

		ArrayList<PrescriptionController> prescriptionList = new ArrayList<PrescriptionController>();
		String requete = "SELECT * FROM btsProject_Prescription;";
		try {
			bdd.Connect(); 
			Statement req = bdd.getMaConnexion().createStatement(); 
			ResultSet data = req.executeQuery(requete); 
			while (data.next()) {
				UserController patient = SelectUser(data.getInt("idPatient"));	
				UserController doctor = SelectUser(data.getInt("idDoctor"));
				PrescriptionController prescription = new PrescriptionController (
						data.getInt("idPrescription"),
						data.getString("datePrescription"), 
						data.getString("content"),
						patient,
						doctor
						);
				prescriptionList.add(prescription);
			}
			req.close();
			bdd.Disconnect();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return prescriptionList;
	}
	public static PrescriptionController SelectPrescription(int idPrescription) {

		PrescriptionController prescription = null;
		String requete = "SELECT * FROM btsProject_Prescription WHERE idPrescription = '" + idPrescription + "';";
		try {
			bdd.Connect(); 
			Statement req = bdd.getMaConnexion().createStatement(); 
			ResultSet data = req.executeQuery(requete); 
			while (data.next()) {
				UserController patient = SelectUser(data.getInt("idPatient"));	
				UserController doctor = SelectUser(data.getInt("idDoctor"));
				prescription = new PrescriptionController (
					data.getInt("idPrescription"),
					data.getString("datePrescription"), 
					data.getString("reason"),
					patient,
					doctor
					);
			}
			req.close();
			bdd.Disconnect();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return prescription;
	}
	//#endregion
}
