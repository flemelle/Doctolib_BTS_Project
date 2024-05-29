package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLRequestModel {
	private static DBConnection bdd = new DBConnection ("localhost","btsProject","phpmyadmin","root");
	public static void executeSQL(String request) {
		try {
			bdd.Connect();
			Statement unStat = bdd.getMaConnexion().createStatement();
			unStat.execute(request); 
			unStat.close();
			bdd.Disconnect();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " +request);
			System.out.println(exp);
		}
	}
	public static ResultSet executeQuerySQL(String request) {
		try {
			bdd.Connect();
			Statement unStat = bdd.getMaConnexion().createStatement();
			ResultSet data = unStat.executeQuery(request); 
			unStat.close();
			bdd.Disconnect();
			return data;
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " +request);
			System.out.println(exp);
		}
		return null;
	}
}
