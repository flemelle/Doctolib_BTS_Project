package model;

import java.sql.SQLException;
import java.sql.Statement;

public class SQLRequestModel {
	private static DBConnection bdd = new DBConnection ("localhost:3306","btsProject","phpmyadmin","root");
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
		 }
	}
}
