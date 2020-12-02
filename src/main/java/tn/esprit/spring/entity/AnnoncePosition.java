package tn.esprit.spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "AnnoncePosition")
public class AnnoncePosition {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column 
	 private String title;
	@Column
    private double lat;
	@Column  
    private double lng;
	
	@OneToOne
	private Annonce annoncePosition;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public Annonce getAnnoncePosition() {
		return annoncePosition;
	}
	public void setAnnoncePosition(Annonce annoncePosition) {
		this.annoncePosition = annoncePosition;
	}
	public AnnoncePosition(String title, double lat, double lng, Annonce annoncePosition) {
		super();
		this.title = title;
		this.lat = lat;
		this.lng = lng;
		this.annoncePosition = annoncePosition;
	}
	public AnnoncePosition(String title, double lat, double lng) {
		super();
		this.title = title;
		this.lat = lat;
		this.lng = lng;
	}
	public AnnoncePosition() {
		super();
	}


	
	
	

}
