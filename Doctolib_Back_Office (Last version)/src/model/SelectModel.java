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
	
	
//	public static UserController Select() {
//		UserController user;
//		String requete = "SELECT * FROM btsProject_User;";
//		try {
//			bdd.Connect(); 
//			Statement req = bdd.getMaConnexion().createStatement(); 
//			ResultSet data = req.executeQuery(requete); 
//			user = new UserController (
//					data.getInt("idUser"),
//					data.getString("lastName"), 
//					data.getString("firstName"), 
//					data.getString("mail"), 
//					data.getString("address"), 
//					data.getString("password"), 
//					data.getString("role"), 
//					data.getInt("age")
//					);
//			req.close();
//			bdd.Disconnect();
//		}
//		catch (SQLException exp) {
//			System.out.println("Erreur de requete : " + requete);
//		}
//		return user;
//	}

	public static ArrayList<UserController> SelectAllUser() {
		ArrayList<UserController> userList = new ArrayList<UserController>();
		String requete = "SELECT * FROM btsProject_User;";
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
public static ArrayList<AppointmentController> SelectAllAppointment() {

		ArrayList<AppointmentController> appointmentList = new ArrayList<AppointmentController>();
		return appointmentList;
	}
	public static ArrayList<PrescriptionController> SelectAllPrescription() {

		ArrayList<PrescriptionController> prescriptionList = new ArrayList<PrescriptionController>();
		return prescriptionList;
	}

}
