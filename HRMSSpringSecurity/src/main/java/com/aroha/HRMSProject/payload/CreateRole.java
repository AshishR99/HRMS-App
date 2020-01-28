package com.aroha.HRMSProject.payload;

import com.aroha.HRMSProject.model.Role;

public class CreateRole {
	
	private Role createRole;
	private String status;

	public Role getCreateRole() {
		return createRole;
	}

	public void setCreateRole(Role createRole) {
		this.createRole = createRole;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
		
}
