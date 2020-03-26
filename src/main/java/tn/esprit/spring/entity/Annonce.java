package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "Annonce")
public class Annonce implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column 
	private String title;
	@Column 
	private String adresse;
	@Column 
	private String type;
	@Column 
	private Float price;
	@Column 
	private String description;
	@Column 
	private String picture;
	@Column 
	private String intSurface;
	@Column 
	private String extSurface;
	@Column 
	private Long numberRooms;
	@Enumerated(EnumType.STRING)
	StatePrice statePrice;
	
	@Column 
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	@Column 
	@Temporal(TemporalType.DATE)
	private Date updatedAt;
	
	@Column 
	private String history;
	@Column 
	@Enumerated(EnumType.STRING)
	State state;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getIntSurface() {
		return intSurface;
	}
	public void setIntSurface(String intSurface) {
		this.intSurface = intSurface;
	}
	public String getExtSurface() {
		return extSurface;
	}
	public void setExtSurface(String extSurface) {
		this.extSurface = extSurface;
	}
	public Long getNumberRooms() {
		return numberRooms;
	}
	public void setNumberRooms(Long numberRooms) {
		this.numberRooms = numberRooms;
	}
	public StatePrice getStatePrice() {
		return statePrice;
	}
	public void setStatePrice(StatePrice statePrice) {
		this.statePrice = statePrice;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Annonce [id=" + id + ", title=" + title + ", adresse=" + adresse + ", type=" + type + ", price=" + price
				+ ", description=" + description + ", picture=" + picture + ", intSurface=" + intSurface
				+ ", extSurface=" + extSurface + ", numberRooms=" + numberRooms + ", statePrice=" + statePrice
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", history=" + history + ", state=" + state
				+ "]";
	}
	public Annonce(Long id, String title, String adresse, String type, Float price, String description, String picture,
			String intSurface, String extSurface, Long numberRooms, StatePrice statePrice, Date createdAt,
			Date updatedAt, String history, State state) {
		super();
		this.id = id;
		this.title = title;
		this.adresse = adresse;
		this.type = type;
		this.price = price;
		this.description = description;
		this.picture = picture;
		this.intSurface = intSurface;
		this.extSurface = extSurface;
		this.numberRooms = numberRooms;
		this.statePrice = statePrice;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.history = history;
		this.state = state;
	}
	public Annonce (){
		
	}
	public Annonce(Long id, String title, Date createdAt, State state) {
		super();
		this.id = id;
		this.title = title;
		this.createdAt = createdAt;
		this.state = state;
	}
	public Annonce(String title, Date createdAt, State state) {
		super();
		this.title = title;
		this.createdAt = createdAt;
		this.state = state;
	}
	
	
	
	
}
