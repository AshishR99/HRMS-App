package com.aroha.HRMSProject.payload;

import com.aroha.HRMSProject.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SignUpRequest {
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private User adduser;
	private String status;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private long roleId;
	
	
	public User getAdduser() {
		return adduser;
	}
	public void setAdduser(User adduser) {
		this.adduser = adduser;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
	
}
