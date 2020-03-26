package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Admin")
public class Admin {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Admin_ID")
	private Long id;
	@Column(name="Username")
	private String username ;
	@Column(name="Password")
	private String password;
}
