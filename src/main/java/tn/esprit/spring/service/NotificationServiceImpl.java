package tn.esprit.spring.service;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.repository.NotificationRepository;


@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	private static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

	public NotificationServiceImpl(){}
	
	
	
	public List<Notification> retrieveAllNotifications() {
		List<Notification> Notifications=(List<Notification>) notificationRepository.findAll();
		for(Notification notification:Notifications){
		logger.info("user +++ : "+ notification);}
		return Notifications;
	}
	public List<Notification> retrieveReadNotifications() {
		List<Notification> Notifications=(List<Notification>) notificationRepository.findAllReadNotifications();
		for(Notification notification:Notifications){
		logger.info("user +++ : "+ notification);}
		return Notifications;
	}
	public List<Notification> retrieveAddings() {
		List<Notification> Notifications=(List<Notification>) notificationRepository.findAllAddings();
		for(Notification notification:Notifications){
		logger.info("user +++ : "+ notification);}
		return Notifications;
	}
	public List<Notification> retrieveUpdates() {
		List<Notification> Notifications=(List<Notification>) notificationRepository.findAllUpdates();
		for(Notification notification:Notifications){
		logger.info("user +++ : "+ notification);}
		return Notifications;
	}
	public List<Notification> retrieveDeletings() {
		List<Notification> Notifications=(List<Notification>) notificationRepository.findAllDeletings();
		for(Notification notification:Notifications){
		logger.info("user +++ : "+ notification);}
		return Notifications;
	}
	
	
	

	public String updateUserNotification(Notification notification,User user){

                notification = save(notification);
		if(notification == null){
			return ("NotificationNotUpdated");
		}
         
		return ("NotificationUpdated") + notification.getNotificationId();
	}

	public Notification save(Notification notification){
		try{
			return notificationRepository.save(notification);
			
		}catch (Exception e) {
			logger.error("Exception occur while save Notification ",e);
			return null;
		}
	}


	public Notification findByUser(User user){
		try{
			return notificationRepository.findByUser(user);
		}catch (Exception e) {
			logger.error("Exception occur while fetch Notification by User ",e);
			return null;
		}
	}

	/*
	  public List<Notification> findByUser(User user,Integer limit){
	 
		try{
			return notificationRepository.userNotification(user.getId(), new PageRequest(0, limit));
		}catch (Exception e) {
			logger.error("Exception occur while fetch Notification by User ",e);
			return null;
		}
	}
	*/
	

	public Notification createNotificationObject(String message,User user){
		return new Notification(message,new Date(),user);
	}

	public Notification findByUserAndNotificationId(User user,Integer notificationId){
		try{
			return notificationRepository.findByUserAndNotificationId(user,notificationId);
		}catch (Exception e) {
			logger.error("Exception occur while fetch Notification by User and Notification Id ",e);
			return null;
		}
	}

}
