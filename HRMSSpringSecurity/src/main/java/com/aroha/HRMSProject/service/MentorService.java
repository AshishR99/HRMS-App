package com.aroha.HRMSProject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aroha.HRMSProject.model.Candidate;
import com.aroha.HRMSProject.model.JobListing;
import com.aroha.HRMSProject.repo.CandidateRepository;

@Service
public class MentorService {
	
	@Autowired
	CandidateRepository candidateRepository;
	
	@Autowired
	HRService hrService;

	public String createCandidate(long joblistId, Candidate getCandDetails) {
		Optional<JobListing> jobListObj=hrService.getJobListByJobListId(joblistId);
		System.out.println("Job List id is: "+joblistId);
		if(jobListObj.isPresent()) {
			JobListing candObj=jobListObj.get();
			System.out.println("Cand Details: "+candObj.getJobdesc());
			getCandDetails.getJoblisting().add(candObj);
			candidateRepository.save(getCandDetails);
			return "Candidate is saved";
		}
		return "Job List is not there";
	}

}
