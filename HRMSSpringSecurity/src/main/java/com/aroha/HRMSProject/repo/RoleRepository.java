package com.aroha.HRMSProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aroha.HRMSProject.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Boolean existsByrolename(String roleName);
}
