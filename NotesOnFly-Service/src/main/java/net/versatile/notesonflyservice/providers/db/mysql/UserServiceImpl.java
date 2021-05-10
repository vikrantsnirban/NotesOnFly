package net.versatile.notesonflyservice.providers.db.mysql;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.versatile.notesonflyservice.bo.User;
import net.versatile.notesonflyservice.bo.config.Configurations;
import net.versatile.notesonflyservice.definitions.UserService;

public class UserServiceImpl implements UserService {
	
	//String userFolderRoot = Configurations.appRoot + "user/" ;

	public void addUser(User user) {
		String sqlQuery = "INSERT INTO USER VALUES (\""+ user.getUserName() 
		+"\", \"" + user.getFirstName() 
		+ "\", \"" + user.getLastName()
		+"\", \"" + user.getEmailAddress()
		+"\", \"" + user.getAddress() 
		+ "\")";
		Connection connection;
		try {
			connection = DBInitializer.getDBConnection();
			Statement statement = connection.createStatement();
			statement.execute(sqlQuery);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void updateUser(User user) {
		String sqlQuery = "UPDATE USER SET "
							+ "USERNAME = " + "\"" + user.getUserName() 
							+ "\", FIRSTNAME = " + "\"" + user.getFirstName()
							+ "\", LASTNAME = " + "\"" + user.getLastName() 
							+ "\", EMAIL = " + "\"" + user.getEmailAddress() 
							+ "\", ADDRESS = " + "\"" + user.getAddress() 
							+ "\" WHERE USERNAME = " + "\"DONTKNOW" + "\"";


		Connection connection;
		try {
			connection = DBInitializer.getDBConnection();
			Statement statement = connection.createStatement();
			statement.execute(sqlQuery);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void deleteUser(String userName) {

		String sqlQuery = "DELETE FROM USER WHERE USERNAME = " + "\"" + userName + "\"";
		System.out.println(sqlQuery);


		Connection connection;
		try {
			connection = DBInitializer.getDBConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate(sqlQuery);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	
	}

	public List<User> listUsers() {
		List<User> users = new ArrayList<User>();
		//File userFolder = new File(userFolderRoot);
		
		String sqlQuery = "SELECT * FROM USER";
		
		Connection connection;
		try {
			connection = DBInitializer.getDBConnection();
			Statement statement = connection.createStatement();
			ResultSet usersFromDB = statement.executeQuery(sqlQuery);
			while(usersFromDB.next()){
				User user = new User();
				user.setUserName(usersFromDB.getString("USERNAME"));
				user.setFirstName(usersFromDB.getString("FIRSTNAME"));
				user.setLastName(usersFromDB.getString("LASTNAME"));
				user.setEmailAddress(usersFromDB.getString("EMAIL"));
				user.setAddress(usersFromDB.getString("ADDRESS"));
				users.add(user);
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return users;
	}

}
