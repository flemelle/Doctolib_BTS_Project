package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.UserController;

public class SelectModel {
	private static DBConnection bdd = new DBConnection ("localhost:3306","btsProject","phpmyadmin","root");
	
	public static UserController selectUser(String login, String password) {
		UserController user = null;
		String requete = "SELECT * FROM btsProject_User where mail = '"+login
				+ "' AND password ='"+password+"' AND role = 'admin';";
		try {
			bdd.Connect();
			//création d'un curseur pour exécuter la requete 
			Statement req = bdd.getMaConnexion().createStatement(); 
			//execution de la requete et récuperation d'un resultat 
			ResultSet data = req.executeQuery(requete); 
			//s'il y a un resultat, on récupere les champs 
			if (data.next()) {
				user = new UserController (
						data.getInt("idUser"),   
						data.getInt("age"), 
						data.getString("lastName"), 
						data.getString("firstName"), 
						data.getString("mail"), 
						data.getString("address"), 
						data.getString("password"), 
						data.getString("role")
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
	
	public static ArrayList<UserController>	 selectUserList() {
		ArrayList<UserController> userList = new ArrayList<UserController>();
		String requete = "SELECT * FROM btsProject_User;";
		try {
			bdd.Connect(); 
			Statement req = bdd.getMaConnexion().createStatement(); 
			ResultSet data = req.executeQuery(requete); 
			if (data.next()) {
				UserController user = new UserController (
						data.getInt("idUser"),   
						data.getInt("age"), 
						data.getString("lastName"), 
						data.getString("firstName"), 
						data.getString("mail"), 
						data.getString("address"), 
						data.getString("password"), 
						data.getString("role")
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

}
