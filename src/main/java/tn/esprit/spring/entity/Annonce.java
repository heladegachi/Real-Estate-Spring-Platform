package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import tn.esprit.spring.entity.AnnonceReview;

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
	public Annonce(String title, String adresse, String description, State state) {
		super();
		this.title = title;
		this.adresse = adresse;
		this.description = description;
		this.state = state;
	}
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
	
	
	@Enumerated(EnumType.STRING)
	AdState AdState;
	
	@Column 
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	@Column 
	@Temporal(TemporalType.DATE)
	private Date updatedAt;
	
	@Column 
	private Long numberBathrooms;
	@Column 
	private Long numberGarages;
	
	@Column
	private String history;
	
	
	
	public Long getNumberBathrooms() {
		return numberBathrooms;
	}
	public void setNumberBathrooms(Long numberBathrooms) {
		this.numberBathrooms = numberBathrooms;
	}
	public Long getNumberGarages() {
		return numberGarages;
	}
	public void setNumberGarages(Long numberGarages) {
		this.numberGarages = numberGarages;
	}
	public Annonce(String title, String adresse, String description, Long annonceIdToBeUpdated, String history,
			State state) {
		super();
		this.title = title;
		this.adresse = adresse;
		this.description = description;
		this.annonceIdToBeUpdated = annonceIdToBeUpdated;
		this.history = history;
		this.state = state;
	}
	public Long getAnnonceIdToBeUpdated() {
		return annonceIdToBeUpdated;
	}
	public void setAnnonceIdToBeUpdated(Long annonceIdToBeUpdated) {
		this.annonceIdToBeUpdated = annonceIdToBeUpdated;
	}
	private Long annonceIdToBeUpdated;
	
	
	@OneToMany(mappedBy="annonce", 
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
			fetch=FetchType.EAGER)
	private List<AnnonceReview> annonceReviews = new ArrayList<>();
	
	
	@OneToMany(mappedBy="annonce", 
			cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Notification> notifications = new ArrayList<>();
	
	public Annonce(String title, String adresse, Float price, String description, String picture,
			StatePrice statePrice, Date createdAt, State state, ContractType contractType) {
		super();
		this.title = title;
		this.adresse = adresse;
	
		this.price = price;
		this.description = description;
		this.picture = picture;
		this.statePrice = statePrice;
		this.createdAt = createdAt;
		this.state = state;
		this.contractType = contractType;
	}
	@ManyToOne
	private User user;
	

	

	
	public AdState getAdState() {
		return AdState;
	}
	public void setAdState(AdState adState) {
		AdState = adState;
	}
	public List<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	@Column 
	@Enumerated(EnumType.STRING)
	State state;
	
	
	@Column
	@Enumerated(EnumType.STRING)
	private ContractType contractType;
	
	@Column
	private String country;
	
	@Column
	private String city;
	
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
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
	
	
	
	public List<AnnonceReview> getAnnonceReviews() {
		return annonceReviews;
	}
	public void setAnnonceReviews(List<AnnonceReview> annonceReviews) {
		this.annonceReviews = annonceReviews;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public Annonce(String title,String description, String adresse,  Long annonceIdToBeUpdated, State state) {
		super();
		this.title = title;
		this.adresse = adresse;
		this.description = description;
		this.annonceIdToBeUpdated = annonceIdToBeUpdated;
		this.state = state;
	}
	public Annonce(String title, String adresse, String type, Float price, String description, String picture,
			String intSurface, String extSurface, Long numberRooms, StatePrice statePrice, Date createdAt,
			Long annonceIdToBeUpdated, List<AnnonceReview> annonceReviews, User user) {
		super();
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
		this.annonceIdToBeUpdated = annonceIdToBeUpdated;
		this.annonceReviews = annonceReviews;
		this.user = user;
	}
	public Annonce(String title, String adresse, String description, Date createdAt, State state) {
		super();
		this.title = title;
		this.adresse = adresse;
		this.description = description;
		this.createdAt = createdAt;
		this.state = state;
	}
	public Annonce(Long id, String title, String adresse, String description, State state) {
		super();
		this.id = id;
		this.title = title;
		this.adresse = adresse;
		this.description = description;
		this.state = state;
	}
	
	
	public Annonce(Long annonceIdToBeUpdated, String title, String adresse, Float price, String description, String picture,
			StatePrice statePrice, Date createdAt, State state, ContractType contractType) {
		super();
		this.title = title;
		this.adresse = adresse;
		this.annonceIdToBeUpdated = annonceIdToBeUpdated;
		this.price = price;
		this.description = description;
		this.picture = picture;
		this.statePrice = statePrice;
		this.createdAt = createdAt;
		this.state = state;
		this.contractType = contractType;
	}
	public ContractType getContractType() {
		return contractType;
	}
	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}
	public Annonce(String title, String adresse,  Float price, String description, String picture,
			String intSurface, String extSurface, Long numberRooms, StatePrice statePrice, Date createdAt, User user, String history, State state,
			ContractType contractType, String country, String city, Long numberBathrooms, Long numberGarages) {
		super();
		this.title = title;
		this.adresse = adresse;
		
		this.price = price;
		this.description = description;
		this.picture = picture;
		this.intSurface = intSurface;
		this.extSurface = extSurface;
		this.numberRooms = numberRooms;
		this.statePrice = statePrice;
		this.createdAt = createdAt;
		this.user = user;
		this.history = history;
		this.state = state;
		this.contractType = contractType;
		this.country = country;
		this.city = city;
		this.numberBathrooms = numberBathrooms;
		this.numberGarages = numberGarages;
	}
	public Annonce(Long annonceIdToBeUpdated, String title, String adresse,  Float price, String description, String picture,
			String intSurface, String extSurface, Long numberRooms, StatePrice statePrice, Date createdAt, User user, String history, State state,
			ContractType contractType, String country, String city, Long numberBathrooms, Long numberGarages) {
		super();
		this.title = title;
		this.adresse = adresse;
		this.annonceIdToBeUpdated = annonceIdToBeUpdated;
		this.price = price;
		this.description = description;
		this.picture = picture;
		this.intSurface = intSurface;
		this.extSurface = extSurface;
		this.numberRooms = numberRooms;
		this.statePrice = statePrice;
		this.createdAt = createdAt;
		this.user = user;
		this.history = history;
		this.state = state;
		this.contractType = contractType;
		this.country = country;
		this.city = city;
		this.numberBathrooms = numberBathrooms;
		this.numberGarages = numberGarages;
	}
	public Annonce( String title, String adresse, Float price, String description, String picture,
			String intSurface, String extSurface, Long numberRooms, StatePrice statePrice,
			AdState adState, Date createdAt, Date updatedAt, Long numberBathrooms,
			Long numberGarages, String history, List<AnnonceReview> annonceReviews,
			List<Notification> notifications, User user, State state, ContractType contractType, String country,
			String city) {
		super();
		
		this.title = title;
		this.adresse = adresse;
		
		this.price = price;
		this.description = description;
		this.picture = picture;
		this.intSurface = intSurface;
		this.extSurface = extSurface;
		this.numberRooms = numberRooms;
		this.statePrice = statePrice;
		AdState = adState;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.numberBathrooms = numberBathrooms;
		this.numberGarages = numberGarages;
		this.history = history;
		this.annonceIdToBeUpdated = annonceIdToBeUpdated;
		this.annonceReviews = annonceReviews;
		this.notifications = notifications;
		this.user = user;
		this.state = state;
		this.contractType = contractType;
		this.country = country;
		this.city = city;
	}
	
	public Annonce(String title, String adresse,  Float price, String description, String picture,
			String intSurface, String extSurface, Long numberRooms, StatePrice statePrice, Date createdAt, User user, String history, State state,
			ContractType contractType, String country, String city, Long numberBathrooms, Long numberGarages, AdState adState) {
		super();
		this.title = title;
		this.adresse = adresse;
		AdState = adState;
		this.price = price;
		this.description = description;
		this.picture = picture;
		this.intSurface = intSurface;
		this.extSurface = extSurface;
		this.numberRooms = numberRooms;
		this.statePrice = statePrice;
		this.createdAt = createdAt;
		this.user = user;
		this.history = history;
		this.state = state;
		this.contractType = contractType;
		this.country = country;
		this.city = city;
		this.numberBathrooms = numberBathrooms;
		this.numberGarages = numberGarages;
	}
	public Annonce(Long annonceIdToBeUpdated, String title, String adresse,  Float price, String description, String picture,
			String intSurface, String extSurface, Long numberRooms, StatePrice statePrice, Date createdAt, User user, String history, State state,
			ContractType contractType, String country, String city, Long numberBathrooms, Long numberGarages, AdState adState) {
		super();
		this.annonceIdToBeUpdated = annonceIdToBeUpdated;
		this.title = title;
		this.adresse = adresse;
		AdState = adState;
		this.price = price;
		this.description = description;
		this.picture = picture;
		this.intSurface = intSurface;
		this.extSurface = extSurface;
		this.numberRooms = numberRooms;
		this.statePrice = statePrice;
		this.createdAt = createdAt;
		this.user = user;
		this.history = history;
		this.state = state;
		this.contractType = contractType;
		this.country = country;
		this.city = city;
		this.numberBathrooms = numberBathrooms;
		this.numberGarages = numberGarages;
	}
	public Annonce(Long id, AdState adState) {
		super();
		AdState = adState;
		this.id = id;
	}
	
	
}
