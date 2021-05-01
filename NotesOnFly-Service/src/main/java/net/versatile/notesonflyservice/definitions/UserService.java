package net.versatile.notesonflyservice.definitions;

import java.util.List;

import net.versatile.notesonflyservice.bo.User;

public interface UserService {
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(String userName);
	List<User> listUsers();

}
