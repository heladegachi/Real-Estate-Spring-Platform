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
@Table(name= "Abonnement_de_publication")
public class Subscription {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Abonnement_ID")
	private Long id;
	@Temporal(TemporalType.DATE)
	@Column(name="Date_début")
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	@Column(name="Date_fin")
	private Date dateFin;
	@Column(name="Code_validation")
	private String code;
	@Column(name="Prix")
	private Float prix;
	@ManyToOne
	User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Float getPrix() {
		return prix;
	}
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Subscription [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", code=" + code
				+ ", prix=" + prix + "]";
	}
	public Subscription(Long id, Date dateDebut, Date dateFin, String code, Float prix, User user) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.code = code;
		this.prix = prix;
		this.user = user;
	}
	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
