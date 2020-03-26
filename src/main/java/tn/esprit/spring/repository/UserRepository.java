package tn.esprit.spring.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.*;
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	//List<User> findByFirstName(String firstName);
	//List<User> findByLastName(String lastName);
	//@Query("SELECT (MAX(e.id), 0) FROM Employee e")
	//Long getMaxId();
	
}
