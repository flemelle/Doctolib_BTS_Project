package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.UserController;

public class DeleteModel {
	private static DBConnection bdd = new DBConnection ("localhost","btsProject","phpmyadmin","root");
	
	public static void DeleteUser(int idUser) {
		String request = "DELETE FROM btsProject_User WHERE idUser = "+idUser+";";
		SQLRequestModel.executeSQL(request);
	}
	public static void DeleteAppointment(int idAppointment) {
		String requete = "DELETE FROM btsProject_Appointment WHERE idAppointment = "+idAppointment+";";
		try {
			bdd.Connect();
			//création d'un curseur pour exécuter la requete 
			Statement req = bdd.getMaConnexion().createStatement(); 
			//execution de la requete et récuperation d'un resultat 
			req.execute(requete); 
			//s'il y a un resultat, on récupere les champs 
			req.close();
			bdd.Disconnect();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " +requete);
			System.out.println(exp);
		}
	}
	

}
