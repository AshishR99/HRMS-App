package com.aroha.HRMSProject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long candid;
	private String candname;
	private String mobnumber;
	private String candemail;
	private String uploadDir;


	@ManyToMany(mappedBy = "candidate")
	private Set<JobListing> joblisting=new HashSet<>();

	public Set<JobListing> getJoblisting() {
		return joblisting;
	}

	public void setJoblisting(Set<JobListing> joblisting) {
		this.joblisting = joblisting;
	}

	public long getCandid() {
		return candid;
	}

	public void setCandid(long candid) {
		this.candid = candid;
	}

	public String getCandname() {
		return candname;
	}

	public void setCandname(String candname) {
		this.candname = candname;
	}

	public String getMobnumber() {
		return mobnumber;
	}

	public void setMobnumber(String mobnumber) {
		this.mobnumber = mobnumber;
	}

	public String getCandemail() {
		return candemail;
	}

	public void setCandemail(String candemail) {
		this.candemail = candemail;
	}

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

}
