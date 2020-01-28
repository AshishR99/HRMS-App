package com.aroha.HRMSProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aroha.HRMSProject.model.JobListing;
import com.aroha.HRMSProject.repo.JobListingRepository;

@Service
public class HRService {

	@Autowired
	JobListingRepository jobListingRepo;

	public JobListing createJobListing(JobListing jobListing) {
		return jobListingRepo.save(jobListing);
	}

	public JobListing getJobListById(long joblistid) {
		Optional<JobListing> JobListObj=jobListingRepo.findByjoblistid(joblistid);
		if(JobListObj.isPresent()) {
			return JobListObj.get();
		}
		else
			return null;
	}

	public JobListing updateJobList(JobListing jobListing) {
		Optional<JobListing> jobListId=jobListingRepo.findByjoblistid(jobListing.getJoblistid());
		System.out.println("Here Job List Id is: "+jobListId);
		if(jobListId.isPresent()) {
			JobListing joblistingObj=jobListId.get();
			joblistingObj.setJobdesc(jobListing.getJobdesc());
			return jobListingRepo.save(joblistingObj);
		}
		else {
			// TODO Auto-generated method stub
			return jobListingRepo.save(jobListing);
		}
	}

	public List<JobListing> getAllJobListing() {
		List<JobListing> jobList=jobListingRepo.findAll();
		if(jobList.size()>0) {
			return jobList;
		}
		return new ArrayList<JobListing>();
		// TODO Auto-generated method stub		
	}

	public String deleteJobListById(JobListing jobListing) {
		Optional<JobListing> joblistid=jobListingRepo.findByjoblistid(jobListing.getJoblistid());
		// TODO Auto-generated method stub
		long id=jobListing.getJoblistid();
		if(joblistid.isPresent()) {
			jobListingRepo.deleteById(id);
			return "JobListing Deleted Successfully";
		}
		else {
			return "No Record Found";
		}
		
	}

	

	public Optional<JobListing> getJobListByJobListId(long joblistId) {
		
	return jobListingRepo.findById(joblistId);
		
		
	}
}


