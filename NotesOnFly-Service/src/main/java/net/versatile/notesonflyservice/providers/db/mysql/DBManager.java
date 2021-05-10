package net.versatile.notesonflyservice.providers.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.versatile.notesonflyservice.bo.config.Configurations;

public class DBManager {
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(Configurations.dbURL, Configurations.dbUser, Configurations.dbPassword);
	}
	
	public static int executeSQL(String sqlQuery){
		Connection connection;
		try {
			connection = getDBConnection();
			Statement statement = connection.createStatement();
			return statement.executeUpdate(sqlQuery);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return 0;
	}
	
	public static ResultSet fetchResults(String sqlQuery){
		Connection connection;
		try {
			connection = DBManager.getDBConnection();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			resultSet.last();
			System.out.println("Record(s) Pulled: " + resultSet.getRow());
			resultSet.beforeFirst();
			return resultSet;
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
