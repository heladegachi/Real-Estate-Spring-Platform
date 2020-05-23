package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "AnnonceReview")
public class AnnonceReview implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private String text;
	
	@Column 
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	@Column 
	@Temporal(TemporalType.DATE)
	private Date updatedAt;
	
	@ManyToOne
	private Annonce annonce;

	@ManyToOne
	private User user;
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	public AnnonceReview(String text, Date createdAt) {
		super();
		this.text = text;
		this.createdAt = createdAt;
		
	}

	public AnnonceReview() {
		super();
	}

	@Override
	public String toString() {
		return "AnnonceReview [id=" + id + ", text=" + text + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", annonce=" + annonce + "]";
	}

	public AnnonceReview( String text, Date createdAt, Annonce annonce, User user) {
		super();
		
		this.text = text;
		this.createdAt = createdAt;
		
		this.annonce = annonce;
		this.user = user;
	}


	

}
