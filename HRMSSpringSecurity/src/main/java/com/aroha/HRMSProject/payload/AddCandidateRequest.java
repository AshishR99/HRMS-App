package com.aroha.HRMSProject.payload;

import com.aroha.HRMSProject.model.Candidate;

public class AddCandidateRequest {
	
	private Candidate addCandidate;
	private String status;
	private long joblistid;
	public Candidate getAddCandidate() {
		return addCandidate;
	}
	public void setAddCandidate(Candidate addCandidate) {
		this.addCandidate = addCandidate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getJoblistid() {
		return joblistid;
	}
	public void setJoblistid(long joblistid) {
		this.joblistid = joblistid;
	}

	
}
