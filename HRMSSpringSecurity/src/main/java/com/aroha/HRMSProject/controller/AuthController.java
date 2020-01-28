package com.aroha.HRMSProject.controller;

import java.net.BindException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aroha.HRMSProject.exception.FileNotFoundException;
import com.aroha.HRMSProject.model.User;
import com.aroha.HRMSProject.payload.JwtAuthenticationResponse;
import com.aroha.HRMSProject.payload.LoginRequest;
import com.aroha.HRMSProject.payload.SignUpRequest;
import com.aroha.HRMSProject.repo.UserRepository;
import com.aroha.HRMSProject.security.CurrentUser;
import com.aroha.HRMSProject.security.JwtTokenProvider;
import com.aroha.HRMSProject.security.UserPrincipal;
import com.aroha.HRMSProject.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider tokenProvider;

	@Autowired
	UserService userService;

	@Autowired
	JwtAuthenticationResponse jwtObj;

	@Autowired
	UserRepository userRepo;

	@PostMapping("/signin")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateToken(authentication);
		User user = userService.getuser(loginRequest.getUsernameOrEmail()).get();
		jwtObj.setTokenType("Bearer");
		jwtObj.setAccessToken(jwt);
		jwtObj.setId(user.getUserid());
		jwtObj.setName(user.getUsername());
		jwtObj.setRoles(authentication.getAuthorities());
		jwtObj.setUsername(user.getUseremail());
		// return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
		return ResponseEntity.ok(jwtObj);
	}

	// Add Users
	@PostMapping("/addUsers")
	public ResponseEntity<?> addUsersInRoles(@RequestBody SignUpRequest signUp, @CurrentUser UserPrincipal user) {
		if (user.isAdminRole()) {
			Long roleId = signUp.getRoleId();
			User getUser = signUp.getAdduser();
			getUser.setUserpassword(passwordEncoder.encode(signUp.getAdduser().getUserpassword()));
			signUp.setStatus(userService.addUser(roleId, getUser));
			return ResponseEntity.ok(signUp);
		}
		signUp.setStatus("Not authorized");
		return ResponseEntity.ok(signUp);
	}

	// Get All Users
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUser());
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable long id) {
		userRepo.deleteById(id);

	}

	@PutMapping("/updateusers/{id}")
	public User updateUser(@PathVariable(value = "id") long userid,
			@Valid @RequestBody User userDetails) throws FileNotFoundException {

		User user = userRepo.findById(userid)
				.orElseThrow(() -> new FileNotFoundException(userid));
		if(userDetails.getUsername()!=null) {		
			user.setUsername(userDetails.getUsername());}
		if(userDetails.getUseremail()!=null) {
			user.setUseremail(userDetails.getUseremail());}
		if(userDetails.getUserpassword()!=null) {
			user.setUserpassword(userDetails.getUserpassword());}
		if(userDetails.getPhoneNumber()!=null) {

			user.setPhoneNumber(userDetails.getPhoneNumber());}
		if(userDetails.getAddress()!=null) {
			user.setAddress(userDetails.getAddress());}
		User updatedUser = userRepo.save(user);

		return updatedUser;
	}



}
