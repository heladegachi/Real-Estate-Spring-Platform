package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "Reclamation")
public class Reclamation {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Reclamation_ID")
	private Long id;
	@Temporal(TemporalType.DATE)
	@Column(name="Date")
	private Date date;
	@Enumerated(EnumType.STRING)
	Objet objet;
	@Column(name="Description")
	private String description;
	@Column(name="Fichier")
	private String fichier;
	@ManyToOne
	User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFichier() {
		return fichier;
	}
	public void setFichier(String fichier) {
		this.fichier = fichier;
	}
	public Objet getObjet() {
		return objet;
	}
	public void setObjet(Objet objet) {
		this.objet = objet;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", date=" + date + ", objet=" + objet + ", description=" + description
				+ ", fichier=" + fichier + ", user=" + user + "]";
	}
	public Reclamation(Long id, Date date, Objet objet, String description, String fichier, User user) {
		super();
		this.id = id;
		this.date = date;
		this.objet = objet;
		this.description = description;
		this.fichier = fichier;
		this.user = user;
	}
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
