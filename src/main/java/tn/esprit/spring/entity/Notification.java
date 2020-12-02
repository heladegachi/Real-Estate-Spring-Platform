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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private long notificationId;
	@Column
	private String message;
	@Column
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	@Enumerated(EnumType.STRING)
	Action Action;
	@Column
	private boolean isRead;
	
	@ManyToOne
	private User user;
	@ManyToOne
	private Annonce annonce;
	
	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	public Notification(){}
	
	public Notification(String message,Date createdAt,User user){
		this.message = message;
		this.createdAt = createdAt;
		this.user = user;
		this.isRead = false;
}

	public long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(long notificationId) {
		this.notificationId = notificationId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Action getAction() {
		return Action;
	}

	public void setAction(Action action) {
		Action = action;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public Notification(Integer notificationId, String message, Date createdAt, Action action,
			boolean isRead, User user) {
		super();
		this.notificationId = notificationId;
		this.message = message;
		this.createdAt = createdAt;
		Action = action;
		this.isRead = isRead;
		this.user = user;
	}
	
	public Notification( String message, Date createdAt, Action action,
			boolean isRead, User user) {
		super();
		this.message = message;
		this.createdAt = createdAt;
		Action = action;
		this.isRead = isRead;
		this.user = user;
	}
	

	public Notification( String message, Date createdAt, Action action,
			boolean isRead) {
		super();
		this.message = message;
		this.createdAt = createdAt;
		Action = action;
		this.isRead = isRead;
		
	}

	public Notification(String message, Date createdAt, Action action, boolean isRead,
			User user, Annonce annonce) {
		super();
		this.message = message;
		this.createdAt = createdAt;
		Action = action;
		this.isRead = isRead;
		this.user = user;
		this.annonce = annonce;
	}
	
	public Notification(String message, Date createdAt, boolean isRead,
			 Annonce annonce) {
		super();
		this.message = message;
		this.createdAt = createdAt;
		this.isRead = isRead;
		this.annonce = annonce;
	}
	
	
	
	
}
