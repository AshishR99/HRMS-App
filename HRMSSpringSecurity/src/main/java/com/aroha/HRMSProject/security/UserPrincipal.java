package com.aroha.HRMSProject.security;

import com.aroha.HRMSProject.model.Role;
import com.aroha.HRMSProject.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

	private Long id;

	private String name;

	private String username;

	@JsonIgnore
	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserPrincipal(Long id, String name, String email, String password, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.name = name;
		this.username = email;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public UserPrincipal(long userid, Set<Role> role, String useremail, String userpassword,
			List<GrantedAuthority> authorities2) {
		// TODO Auto-generated constructor stub
	}

	public static UserPrincipal create(User user) {
		List<GrantedAuthority> authorities = user.getRole().stream().map(role
				-> new SimpleGrantedAuthority(role.getRolename())
				).collect(Collectors.toList());
		return new UserPrincipal(
				user.getUserid(),
				user.getUsername(),
				user.getUseremail(),
				user.getUserpassword(),
				authorities
				);
	}



	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserPrincipal that = (UserPrincipal) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}

	public boolean isAdminRole() {
		boolean admin = false;
		for (GrantedAuthority a : authorities) {
			if (a.getAuthority().contains("ADMIN")) {
				admin = true;
			}
		}
		return admin;
	}

	public boolean isMenterRole() {
		boolean menter = false;
		for (GrantedAuthority a : authorities) {
			if (a.getAuthority().contains("MENTOR")) {
				menter = true;
			}
		}
		return menter;
	}

}
