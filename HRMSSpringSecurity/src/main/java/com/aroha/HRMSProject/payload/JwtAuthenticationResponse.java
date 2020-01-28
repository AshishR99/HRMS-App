package com.aroha.HRMSProject.payload;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 */
public class JwtAuthenticationResponse {

	private String accessToken;
	private String tokenType;
    private Long id;
    private String username;
    private String name;
    private Collection<? extends GrantedAuthority> roles;

	public JwtAuthenticationResponse(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public JwtAuthenticationResponse() {
		super();
	}



	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}

	public void setRoles(Collection<? extends GrantedAuthority> roles) {
		this.roles = roles;
	}
	
}
