package tn.esprit.spring.service;
import tn.esprit.spring.entity.*;
import tn.esprit.spring.service.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.*;

@Service
public class UserServiceImpl implements UserSerivce {
@Autowired
UserRepository userRepository;

private static final Logger L=LogManager.getLogger(UserServiceImpl.class);

@Override
public List<User>retrieveAllUsers(){
	List<User> users=(List<User>) userRepository.findAll();
	for(User user:users){
	L.info("user +++ : "+ user);}
	return users;
}
@Override
public User addUser(User u){
	return userRepository.save(u);
	
}
@Override
public User updateUser(User u){
	return userRepository.save(u);
	
}

@Override
public void deleteUser(String id) {
	userRepository.deleteById(Long.parseLong(id));
	
}
@Override
public User retrieveUser(String id) {
	User u;
	u=userRepository.findById(Long.parseLong(id)).orElse(null);
	return u;
	
}

}

