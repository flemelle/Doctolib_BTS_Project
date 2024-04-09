package lib;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	private Connection Mysql ;
	public void dbConnect() {
		String url = "jdbc:mysql://localhost/orange_event_266"; 
		url += "?verifyServerCertificate=false&useSSL=false";
		try {
			this.Mysql = DriverManager.getConnection(url, "phpmyadmin", "root");
		}
		catch (SQLException exp) {
			System.out.println("Erreur de connexion a : " + url);
		}
	}

}
