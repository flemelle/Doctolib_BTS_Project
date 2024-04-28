package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.UserController;

public class DeleteModel {
	private static DBConnection bdd = new DBConnection ("localhost","btsProject","phpmyadmin","root");
	
	public static void DeleteUser(int idUser) {
		String requete = "DELETE FROM btsProject_User WHERE idUser = "+idUser+";";
		try {
			bdd.Connect();
			//création d'un curseur pour exécuter la requete 
			Statement req = bdd.getMaConnexion().createStatement(); 
			//execution de la requete et récuperation d'un resultat 
			req.executeQuery(requete); 
			//s'il y a un resultat, on récupere les champs 
			req.close();
			bdd.Disconnect();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " +requete);
		}
	}
	
	

}
