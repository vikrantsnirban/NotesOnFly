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
	public void addUser(@RequestParam(value = "userName", defaultValue = "DEFAULT-USER") String userName, @RequestParam(value = "firstName", defaultValue = "DEFAULT-FIRSTNAME") String firstName, @RequestParam(value = "lastName", defaultValue = "DEFAULT-LASTNAME") String lastName, @RequestParam(value = "email", defaultValue = "DEFAULT-EMAIL") String email, @RequestParam(value = "address", defaultValue = "DEFAULT-ADDRESS") String address) {
		User user = new User();
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailAddress(email);
		user.setAddress(address);
		ServiceDelegator.getUserService().addUser(user);
	}
	
	@RequestMapping("/user/update")
	public void updateUser(@RequestParam(value = "userName", defaultValue = "DEFAULT-USER") String userName, @RequestParam(value = "firstName", defaultValue = "DEFAULT-FIRSTNAME") String firstName, @RequestParam(value = "lastName", defaultValue = "DEFAULT-LASTNAME") String lastName, @RequestParam(value = "email", defaultValue = "DEFAULT-EMAIL") String email, @RequestParam(value = "address", defaultValue = "DEFAULT-ADDRESS") String address) {
		User user = new User();
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailAddress(email);
		user.setAddress(address);
		ServiceDelegator.getUserService().updateUser(user);
	}
	
	@RequestMapping("/user/delete")
	public void deleteUser(@RequestParam(value = "userName", defaultValue = "DEFAULT-USER") String userName){
		ServiceDelegator.getUserService().deleteUser(userName);
	}
}
