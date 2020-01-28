package com.aroha.HRMSProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aroha.HRMSProject.model.JobListing;
import com.aroha.HRMSProject.service.HRService;

@RestController
@RequestMapping("/api")
public class HRController {

	@Autowired
	HRService hrService;

	//Create Job List
	@PostMapping("/CreateJobList")
	public ResponseEntity<?> createJobListing(@RequestBody JobListing jobListing){
		JobListing jobList=hrService.createJobListing(jobListing);
		return ResponseEntity.ok(jobList);	
	}

	//Get Job List By id
	@GetMapping("/getJobListById")
	public ResponseEntity<?> getJobListById(@RequestBody JobListing jobListing){
		JobListing getJobListObj=hrService.getJobListById(jobListing.getJoblistid());
		return ResponseEntity.ok(getJobListObj);	
	}

	//Update Job List
	@PostMapping("/UpdateJobList")
	public ResponseEntity<?> updateJobListing(@RequestBody JobListing jobListing){
		JobListing getUpdatedJobListObj=hrService.updateJobList(jobListing);
		return ResponseEntity.ok("Job Description Updated Successfully");		
	}

	//Get All Job Lists
	@GetMapping("/getAllJobList")
	public ResponseEntity<?> getAllJobListing(){
		List<JobListing> list=hrService.getAllJobListing();
		return ResponseEntity.ok(list);		
	}

	//Delete Job List
	@DeleteMapping("/deleteJobListingById")
	public ResponseEntity<?> deleteJobListById(@RequestBody JobListing jobListing){
		String result=hrService.deleteJobListById(jobListing);
		return ResponseEntity.ok(result);		

	}
}
