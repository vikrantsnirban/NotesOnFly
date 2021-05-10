package net.versatile.notesonflyservice.providers.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.versatile.notesonflyservice.bo.config.Configurations;

public class DBInitializer {
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(Configurations.dbURL, Configurations.dbUser, Configurations.dbPassword);
	}
}
