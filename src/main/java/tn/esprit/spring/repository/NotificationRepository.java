package tn.esprit.spring.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.User;



@Repository
public interface NotificationRepository extends CrudRepository<Notification,Integer> {

	Notification findByUser(User user);

	@Query("select n from Notification n where n.user.id=:userId ORDER BY n.createdAt DESC")
	List<Notification> userNotification(@Param("userId") Long userId,Pageable pageSize);

	Notification findByUserAndNotificationId(User user,Integer notificationId);
	
	
	@Query("SELECT u FROM Notification u WHERE u.isRead = 1")
	List<Notification> findAllReadNotifications();
	
	@Query("SELECT u FROM Notification u WHERE u.Action = 'Added' ORDER BY u.createdAt DESC ")
	List<Notification> findAllAddings();
	
	@Query("SELECT u FROM Notification u WHERE u.Action = 'Updated' ORDER BY u.createdAt DESC")
	List<Notification> findAllUpdates();
	
	@Query("SELECT u FROM Notification u WHERE u.Action = 'Deleted' ORDER BY u.createdAt DESC")
	List<Notification> findAllDeletings();
	  
	@Modifying 
	@Transactional
	@Query("UPDATE Notification e SET e.isRead= 1 where e.notificationId=:notificationId")
	public void isReadJPQL( @Param("notificationId") long notificationId);	
}