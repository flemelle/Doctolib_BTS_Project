package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private String serveur, bdd, user, password ; 
	
	private Connection connection ;

	public DBConnection(String serveur, String bdd, String user, String password) {
		super();
		this.serveur = serveur;
		this.bdd = bdd;
		this.user = user;
		this.password = password;
		this.connection = null; 
	} 
	public void Connect () {
		this.uploadPilote();
		String url = "jdbc:mysql://"+this.serveur+"/"+this.bdd; 
		url += "?verifyServerCertificate=false&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		try {
			this.connection = DriverManager.getConnection(url, this.user, this.password);
		}
		catch (SQLException exp) {
			System.out.println("Erreur de connexion a : " + url);
			System.out.println(exp);
		}
	}
	public void Disconnect () {
		try {
			if (this.connection != null) {
				this.connection.close();
			}
		}
		catch(SQLException exp) {
			System.out.println("Erreur de deconnexion");
		}
	}
	public Connection getMaConnexion () {
		return this.connection;
	}
	public void uploadPilote () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		}
		catch (ClassNotFoundException exp) {
			System.out.println("Absence du driver JDBC");
		}
	}
}
