package com.aroha.HRMSProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aroha.HRMSProject.model.Role;
import com.aroha.HRMSProject.model.User;
import com.aroha.HRMSProject.repo.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;


	public String saveRole(Role newRole) {
		
		Boolean isExists=roleRepo.existsByrolename(newRole.getRolename());
		if(isExists) {
			return "Role is already present";
		}else {
			
			roleRepo.save(newRole);
		}
		return "role saved";
	}
	
	public Optional<Role> findRole(long roleid){
		return roleRepo.findById(roleid);
	}
	
	public List<Role> getAllRole(){
		return roleRepo.findAll();
	}


}
