package com.aroha.HRMSProject.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aroha.HRMSProject.model.JobListing;

public interface JobListingRepository extends JpaRepository<JobListing, Long>{
	
	Optional<JobListing> findByjoblistid(long joblistid);

	Optional<JobListing> deleteByJoblistid(long jobListId);

}
