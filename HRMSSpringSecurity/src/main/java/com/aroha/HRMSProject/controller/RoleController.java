package com.aroha.HRMSProject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aroha.HRMSProject.model.Role;
import com.aroha.HRMSProject.payload.CreateRole;
import com.aroha.HRMSProject.security.CurrentUser;
import com.aroha.HRMSProject.security.UserPrincipal;
import com.aroha.HRMSProject.service.RoleService;


@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping("/createRole")
	public ResponseEntity<?> createNewRole(@RequestBody CreateRole createNewRole,@CurrentUser UserPrincipal user){
		if(!user.isAdminRole()) {
			return ResponseEntity.ok("Not Authorized to create role");
		}
		Role getROle=createNewRole.getCreateRole();
		createNewRole.setStatus(roleService.saveRole(getROle));
		return ResponseEntity.ok(createNewRole);
	}

	@GetMapping("/findRoles")
	public ResponseEntity<?> getAllRole(){
		if(roleService.getAllRole().isEmpty()) {
			return ResponseEntity.ok("No role found");
		}
		return ResponseEntity.ok(roleService.getAllRole());
	}

}
