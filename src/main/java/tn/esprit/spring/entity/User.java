package tn.esprit.spring.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import tn.esprit.spring.entity.*;

@Entity
@Table(name= "User")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="User_ID")
	private Long id;
	@Column(name="Prenom")
	private String prenom ;
	@Column(name="Nom")
	private String nom;
	@Column(name="Cin")
	private Long cin;
	@Column(name="numero_telephonique")
	private Long tel;
	@Column(name="Adresse_mail")
	private String email;
	@Column(name="Code_postal")
	private Long codepostal;
	@Column(name="Adresse")
	private String adresse;
	@Column(name="Profession")
	private String profession;
	@Column(name="Relation")
	private String relation;
	@Column(name="Password")
	private String password;
	@Temporal(TemporalType.DATE)
	@Column(name="Date_de_naissance")
	private Date datenaissance;
	@Enumerated(EnumType.STRING)
	Type type;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Subscription> Subscriptions;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Surveillance> Surveillances;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Assurance> Assurances;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Fiche> fiche;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Reclamation> Reclamations;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Long getCin() {
		return cin;
	}
	public void setCin(Long cin) {
		this.cin = cin;
	}
	public Long getTel() {
		return tel;
	}
	public void setTel(Long tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(Long codepostal) {
		this.codepostal = codepostal;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Set<Subscription> getSubscriptions() {
		return Subscriptions;
	}
	public void setSubscriptions(Set<Subscription> subscriptions) {
		Subscriptions = subscriptions;
	}
	public Set<Surveillance> getSurveillances() {
		return Surveillances;
	}
	public void setSurveillances(Set<Surveillance> surveillances) {
		Surveillances = surveillances;
	}
	public Set<Assurance> getAssurances() {
		return Assurances;
	}
	public void setAssurances(Set<Assurance> assurances) {
		Assurances = assurances;
	}
	public Set<Fiche> getFiche() {
		return fiche;
	}
	public void setFiche(Set<Fiche> fiche) {
		this.fiche = fiche;
	}
	public Set<Reclamation> getReclamations() {
		return Reclamations;
	}
	public void setReclamations(Set<Reclamation> reclamations) {
		Reclamations = reclamations;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", cin=" + cin + ", tel=" + tel + ", email="
				+ email + ", codepostal=" + codepostal + ", adresse=" + adresse + ", profession=" + profession
				+ ", relation=" + relation + ", password=" + password + ", datenaissance=" + datenaissance + ", type="
				+ type + "]";
	}
	public User(Long id, String prenom, String nom, Long cin, Long tel, String email, Long codepostal, String adresse,
			String profession, String relation, String password, Date datenaissance, Type type) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.cin = cin;
		this.tel = tel;
		this.email = email;
		this.codepostal = codepostal;
		this.adresse = adresse;
		this.profession = profession;
		this.relation = relation;
		this.password = password;
		this.datenaissance = datenaissance;
		this.type = type;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
