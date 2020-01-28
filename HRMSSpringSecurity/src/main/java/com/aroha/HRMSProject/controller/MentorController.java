package com.aroha.HRMSProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aroha.HRMSProject.model.Candidate;
import com.aroha.HRMSProject.payload.AddCandidateRequest;
import com.aroha.HRMSProject.security.CurrentUser;
import com.aroha.HRMSProject.security.UserPrincipal;
import com.aroha.HRMSProject.service.MentorService;

@RestController
@RequestMapping("/api")
public class MentorController {

	@Autowired
	MentorService mentorService;

	@PostMapping("/createCandidate")
	public ResponseEntity<?> createCandidate(@RequestBody AddCandidateRequest candidateRequest, @CurrentUser UserPrincipal currentuser){
		long joblistId=candidateRequest.getJoblistid();
		Candidate getCandDetails=candidateRequest.getAddCandidate();
		candidateRequest.setStatus(mentorService.createCandidate(joblistId, getCandDetails));
		return ResponseEntity.ok(candidateRequest);
	}
}
