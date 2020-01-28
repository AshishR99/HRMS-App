package com.aroha.HRMSProject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aroha.HRMSProject.exception.ResourceNotFoundException;
import com.aroha.HRMSProject.model.User;
import com.aroha.HRMSProject.repo.UserRepository;

/**
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrEmail)
			throws UsernameNotFoundException {
		// Let people login with either username or email
		User user = userRepository.findByuseremail(usernameOrEmail).
				orElseThrow(()
					-> new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
				);
		return UserPrincipal.create(user);
	}

	@Transactional
	public UserDetails loadUserById(Long userid) {
		User user = userRepository.findById(userid).orElseThrow(
				() -> new ResourceNotFoundException("User", "userid", userid)
		);

		return UserPrincipal.create(user);
	}
}
