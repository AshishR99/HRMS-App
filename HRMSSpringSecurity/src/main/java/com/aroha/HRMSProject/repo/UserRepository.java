package com.aroha.HRMSProject.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aroha.HRMSProject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByuseremail(String useremail);
	
	Optional<User> findByuserid(Long userid);
	
	Boolean existsByuseremail(String useremail);

}
