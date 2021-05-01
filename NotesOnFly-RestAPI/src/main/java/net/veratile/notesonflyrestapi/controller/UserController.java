package net.veratile.notesonflyrestapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.versatile.notesonflyservice.bo.User;
import net.versatile.notesonflyservice.delegate.ServiceDelegator;

@RestController
public class UserController {
	@RequestMapping("/user/list")
	public String listUsers() {
		return ServiceDelegator.getUserService().listUsers().toString().replaceAll(",","<br/>");
	}
	
	
	@RequestMapping("/user/add")
	public void addUser(@RequestParam(value = "userName", defaultValue = "defaultuser") String userName, @RequestParam(value = "firstName", defaultValue = "FIRST-NAME") String firstName, @RequestParam(value = "lastName", defaultValue = "LAST=NAME") String lastName, @RequestParam(value = "emailAddress", defaultValue = "EMAIL-ADDRESS") String emailAddress, @RequestParam(value = "address", defaultValue = "ADDRESS") String address) {
		User user = new User();
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailAddress(emailAddress);
		user.setAddress(address);
		ServiceDelegator.getUserService().addUser(user);
	}
	
	@RequestMapping("/user/update")
	public void updateUser(@RequestParam(value = "userName", defaultValue = "defaultuser") String userName, @RequestParam(value = "firstName", defaultValue = "FIRST-NAME") String firstName, @RequestParam(value = "lastName", defaultValue = "LAST=NAME") String lastName, @RequestParam(value = "emailAddress", defaultValue = "EMAIL-ADDRESS") String emailAddress, @RequestParam(value = "address", defaultValue = "ADDRESS") String address) {
		User user = new User();
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailAddress(emailAddress);
		user.setAddress(address);
		ServiceDelegator.getUserService().addUser(user);
	}
	
	@RequestMapping("/user/delete")
	public void deleteUser(@RequestParam(value = "userName", defaultValue = "defaultuser") String userName){
		ServiceDelegator.getUserService().deleteUser(userName);
	}
}
