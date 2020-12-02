package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "VisiteV_Virtuelle")

public class VisiteVirtuelleEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VisiteVirtuelle_ID")
	private Long id;
	@Temporal(TemporalType.DATE)
    Date postDate;
	
	 @Column
	private Integer rating;
	 
	 @Column
		private String view;
	 
	 @Column
		private String url;
	 
	 @Column
		private String bedroom;
	 
	 @Column
		private String bathroom;
	 
	 @Column
		private String kitchen;
	 
	 @Column
		private String livingroom;
	 
	 @Column
		private String garden;
	 
	 @Column
		private String floor;
	 
	 @Column
		private String housegarage;
	 
	 
	 
	 
	 
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBedroom() {
		return bedroom;
	}

	public void setBedroom(String bedroom) {
		this.bedroom = bedroom;
	}

	public String getBathroom() {
		return bathroom;
	}

	public void setBathroom(String bathroom) {
		this.bathroom = bathroom;
	}

	public String getKitchen() {
		return kitchen;
	}

	public void setKitchen(String kitchen) {
		this.kitchen = kitchen;
	}

	

	public String getLivingroom() {
		return livingroom;
	}

	public void setLivingroom(String livingroom) {
		this.livingroom = livingroom;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getGarden() {
		return garden;
	}

	public void setGarden(String garden) {
		this.garden = garden;
	}

	
	

	public String getHousegarage() {
		return housegarage;
	}

	public void setHousegarage(String housegarage) {
		this.housegarage = housegarage;
	}

	
	

	
	

	@Override
	public String toString() {
		return "VisiteVirtuelleEntity [id=" + id + ", postDate=" + postDate + ", rating=" + rating + ", view=" + view
				+ ", url=" + url + ", bedroom=" + bedroom + ", bathroom=" + bathroom + ", kitchen=" + kitchen
				+ ", livingroom=" + livingroom + ", garden=" + garden + ", floor=" + floor + ", housegarage="
				+ housegarage + "]";
	}

	

	public VisiteVirtuelleEntity(Long id, Date postDate, Integer rating, String view, String url, String bedroom,
			String bathroom, String kitchen, String livingroom, String garden, String floor, String housegarage) {
		super();
		this.id = id;
		this.postDate = postDate;
		this.rating = rating;
		this.view = view;
		this.url = url;
		this.bedroom = bedroom;
		this.bathroom = bathroom;
		this.kitchen = kitchen;
		this.livingroom = livingroom;
		this.garden = garden;
		this.floor = floor;
		this.housegarage = housegarage;
	}
	public VisiteVirtuelleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


}
