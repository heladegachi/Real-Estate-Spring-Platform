package tn.esprit.spring.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import tn.esprit.spring.entity.User;

public interface UserDetailsService {
	User loadUserByEmail(String email)  ;
}
