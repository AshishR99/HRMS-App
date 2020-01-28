package com.aroha.HRMSProject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GeneratorType;

@Entity
public class JobListing {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long joblistid;
	private String jobdesc;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "job_desc")
	/*joinColumns = @JoinColumn(name = "joblistid"),
	inverseJoinColumns = @JoinColumn(name = "cand_id"))*/
	private Set<Candidate> candidate=new HashSet<>();
	public long getJoblistid() {
		return joblistid;
	}
	public void setJoblistid(long joblistid) {
		this.joblistid = joblistid;
	}
	public String getJobdesc() {
		return jobdesc;
	}
	public void setJobdesc(String jobdesc) {
		this.jobdesc = jobdesc;
	}

	
}
