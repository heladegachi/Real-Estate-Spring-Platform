package tn.esprit.spring.service;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.omg.CORBA.UserException;

import tn.esprit.spring.entity.*;
public interface UserSerivce {
	List<User> retrieveAllUsers();
	User addUser(User u);
	void deleteUser(String id);
	User updateUser(User u);
	User retrieveUser(String id);
	User authenticate(String login, String password);
	List<User> getAllUsers();
	long addOrUpdateUser(User usr);
	
}
