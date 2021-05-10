package net.versatile.notesonflyservice.providers.db.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.versatile.notesonflyservice.bo.User;
import net.versatile.notesonflyservice.definitions.UserService;

public class UserServiceImpl implements UserService {
	
	public void addUser(User user) {
		String sqlQuery = "INSERT INTO USER VALUES (\""+ user.getUserName() 
		+"\", \"" + user.getFirstName() 
		+ "\", \"" + user.getLastName()
		+"\", \"" + user.getEmailAddress()
		+"\", \"" + user.getAddress() 
		+ "\")";
		System.out.println("sqlQuery:\n" + sqlQuery);
		System.out.println("Record(s) Added: " + DBManager.executeSQL(sqlQuery));
	}

	public void updateUser(User user) {
		String sqlQuery = "UPDATE USER SET "
							+ "USERNAME = " + "\"" + user.getUserName() 
							+ "\", FIRSTNAME = " + "\"" + user.getFirstName()
							+ "\", LASTNAME = " + "\"" + user.getLastName() 
							+ "\", EMAIL = " + "\"" + user.getEmailAddress() 
							+ "\", ADDRESS = " + "\"" + user.getAddress() 
							+ "\" WHERE USERNAME = \"" + user.getUserName()  + "\"";

		System.out.println("sqlQuery:\n" + sqlQuery);
		System.out.println("Record(s) Updated: " + DBManager.executeSQL(sqlQuery));
	}

	public void deleteUser(String userName) {

		String sqlQuery = "DELETE FROM USER WHERE USERNAME = " + "\"" + userName + "\"";
		System.out.println("sqlQuery:\n" + sqlQuery);
		System.out.println("Record(s) Deleted: " + DBManager.executeSQL(sqlQuery));
	}

	public List<User> listUsers() {
		List<User> users = new ArrayList<User>();
		
		String sqlQuery = "SELECT * FROM USER";
		System.out.println("sqlQuery:\n" + sqlQuery);
		
		try {
			ResultSet userResultSet = DBManager.fetchResults(sqlQuery);
			while(userResultSet.next()){
				User user = new User();
				user.setUserName(userResultSet.getString("USERNAME"));
				user.setFirstName(userResultSet.getString("FIRSTNAME"));
				user.setLastName(userResultSet.getString("LASTNAME"));
				user.setEmailAddress(userResultSet.getString("EMAIL"));
				user.setAddress(userResultSet.getString("ADDRESS"));
				users.add(user);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return users;
	}

}
