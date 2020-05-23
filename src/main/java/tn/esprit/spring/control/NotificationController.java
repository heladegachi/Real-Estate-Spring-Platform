package tn.esprit.spring.control;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Action;
import tn.esprit.spring.entity.Annonce;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.Type;
import tn.esprit.spring.service.AnnReviewService;
import tn.esprit.spring.service.AnnService;
import tn.esprit.spring.service.NotificationServiceImpl;
import tn.esprit.spring.service.UserSerivce;

@Scope(value = "session") 
@Controller(value = "notificationController") 
@ELBeanName(value = "notificationController") 

public class NotificationController {
	@Autowired
	AnnService iannservice;
	@Autowired
	AnnReviewService iannRevservice;

	@Autowired
	UserSerivce userservice;
	@Autowired
	UserController usercontroller;
	@Autowired
	NotificationServiceImpl notificationservice;
	
	
	private Integer notificationId;

	private String message;

	private Date createdAt;
	private boolean isRead;
	


	private Action Action;
	
	private Integer a=0;
	
	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
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

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Action[] getActions() {
		return Action.values(); 
	}

	
	private List<Notification> notifications;
	public List<Notification> getNotifications() {
		
		List<Notification> addings = notificationservice.retrieveAddings();
		List<Notification> updates = notificationservice.retrieveUpdates();
		List<Notification> deletings = notificationservice.retrieveDeletings();
		List<Notification> notifications = notificationservice.retrieveAllNotifications();
		if (a==1)
		{
				return addings;
		}
		else if (a==2){
				return updates;	
				}
		else if (a==3){
				return deletings;
			}
		
		for(int i=0, j= notifications.size()-1; i<j; i++)
		{
			
			notifications.add(i,notifications.remove(j)); 
		} 
		return notifications;	
		
	}

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public void setAnnonces(List<Notification> notifications) {
		this.notifications = notifications;
	}
	
	public Date currentDate()
	{
		Date currdate = new Date();
		return currdate;
	}
	
	
	public List<Notification> getNotificationsSameDay() {
		Date currdate = new Date();

		notifications = notificationservice.retrieveAllNotifications();
		
		
			
			for(int i=0, j= notifications.size()-1; i<j; i++)
			{
				
				notifications.add(i,notifications.remove(j)); 
			} 
			
		
		return notifications;
	}
	public Date getDate()
	{	
		Date currdate = new Date();
		return currdate;
		
	}
	public int getAddings()
	{
		return a=1;
	}
	public int getUpdates()
	{
		return a=2;
	}
	public int getDeletings()
	{
		return a=3;
	}
	public int getAll()
	{
		return a=0;
	}
	

}
