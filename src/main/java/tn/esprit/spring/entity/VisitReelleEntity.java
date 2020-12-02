package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Visite_Reelle")

public class VisitReelleEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VisiteR_ID")
//	private Long id;
	 private Long id;

	@Column
	private String firstname;;

	@Column
	 private String lastname;
	
	@Column
    private Integer buildingidentifier;
	@Column
    private String street;
	@Column
    private String city;
	@Column
    private String postalCode;
	@Column
    private String info;
	@Column
    private String date;
    
	@Column
    private String email;
	@Column
    private String phone;

	
	
	

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getBuildingidentifier() {
		return buildingidentifier;
	}

	public void setBuildingidentifier(Integer buildingidentifier) {
		this.buildingidentifier = buildingidentifier;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	

//	@Override
//	public String toString() {
//		return "VisitReelle [id=" + id + ", reference=" + reference + ", adresse_mail=" + adresse_mail + ", photo=" + photo
//				+ ", datee=" + datee + "]";
//	}
//
//	public VisitReelleEntity(Long id, String reference, String adresse_mail, String photo, Date datee) {
//		super();
//		this.id = id;
//		this.reference = reference;
//		this.adresse_mail = adresse_mail;
//		this.photo = photo;
//		this.datee = datee;
//
//	}

	@Override
	public String toString() {
		return "VisitReelleEntity [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", buildingidentifier=" + buildingidentifier + ", street=" + street + ", city=" + city
				+ ", postalCode=" + postalCode + ", info=" + info + ", date=" + date + ", email=" + email + ", phone="
				+ phone + "]";
	}
	

	public VisitReelleEntity(Long id, String firstname, String lastname, Integer buildingidentifier, String street,
		String city, String postalCode, String info, String date, String email, String phone) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.buildingidentifier = buildingidentifier;
	this.street = street;
	this.city = city;
	this.postalCode = postalCode;
	this.info = info;
	this.date = date;
	this.email = email;
	this.phone = phone;
}

	public VisitReelleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}