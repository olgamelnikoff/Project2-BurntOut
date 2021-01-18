package com.jobportal.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.model.Application;
import com.jobportal.model.JobPosting;
import com.jobportal.model.User;
import com.jobportal.repository.ApplicationRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class ApplicationService {
	
	private ApplicationRepository appRepo;
	
	public List<Application> getAllApplications(){
		return appRepo.findAll();
	}
	
	public Application getApplicationById(int id) {
		return appRepo.getOne(id);
	}
	
	public List<Application> getApplicationByApplicantId(User userId) {
		return appRepo.findByApplicantId(userId);
	}
	
	public List<Application> getApplicationByPostingId(JobPosting postingId) {
		return appRepo.findByPostingId(postingId);
	}
	
	public void insertApplication(Application Application) {
		appRepo.save(Application);
	}
	
	public void updateApplication(Application Application) {
		
		appRepo.save(Application);
	}
	
	public void deleteApplication(Application Application) {
		appRepo.delete(Application);
	}

}