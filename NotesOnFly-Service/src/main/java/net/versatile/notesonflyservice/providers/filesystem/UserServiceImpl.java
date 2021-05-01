package net.versatile.notesonflyservice.providers.filesystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.versatile.notesonflyservice.bo.User;
import net.versatile.notesonflyservice.bo.config.Configurations;
import net.versatile.notesonflyservice.definitions.UserService;

public class UserServiceImpl implements UserService {
	
	String userFolderRoot = Configurations.appRoot + "user/" ;

	public void addUser(User user) {
		try {
			File userFolder = new File(userFolderRoot);
			if(!userFolder.exists())
				userFolder.mkdirs();
			
			File userFile = new File(userFolderRoot + user.getUserName());
			if (userFile.createNewFile()) {
				System.out.println("User File created: " + userFile.getName());
			}
			FileWriter userFileWriter = new FileWriter(userFile);
			userFileWriter.write(user.toString());
			userFileWriter.close();
			System.out.println("Successfully wrote User Data to file: " + userFile.getName());
		} catch (IOException e) {
			System.out.println("An error occurred while User file creation");
			e.printStackTrace();
		}
	}

	public void updateUser(User user) {
		try {
			File userFile = new File(userFolderRoot + user.getUserName());
			if (userFile.exists()) {
				System.out.println("User File Exists: " + userFile.getName());
			}
			FileWriter userFileWriter = new FileWriter(userFile);
			userFileWriter.write(user.toString());
			userFileWriter.close();
			System.out.println("Successfully updated User Data to file: " + userFile.getName());
		} catch (IOException e) {
			System.out.println("An error occurred while User file update");
			e.printStackTrace();
		}

	}

	public void deleteUser(String userName) {
		File userFile = new File(userFolderRoot + userName);
	    if (userFile.delete()) { 
	      System.out.println("Deleted User file: " + userFile.getName());
	    } else {
	      System.out.println("Failed to delete User file: " + userFile.getName());
	    } 
	}

	public List<User> listUsers() {
		List<User> users = new ArrayList<User>();
		File userFolder = new File(userFolderRoot);
		for(File userFile: userFolder.listFiles()){
			User user = new User();
			user.setUserName(userFile.getName());
			users.add(user);
		}
		return users;
	}

}
