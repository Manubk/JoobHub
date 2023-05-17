package com.joobhub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joobhub.entity.Job;
import com.joobhub.repository.JobRepo;

@Service
public class JobService implements IJobService {

	@Autowired
	private JobRepo jobRepo;
	
	@Override
	public boolean save(Job job) {
		Job save = jobRepo.save(job);
		
		if(save.getJobId() != null)
			return true;
		
		return false;
	}

	@Override
	public boolean deleteById(Integer jobId) {
		try {
			Optional<Job> findById = jobRepo.findById(jobId);
			if(findById.isPresent()) {
				jobRepo.deleteById(jobId);
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Job findById(Integer jobId) {
		Optional<Job> findById = jobRepo.findById(jobId);
		
		if (findById.isPresent()) 
			return findById.get();
			
		return null;
	}

	@Override
	public List<Job> getAllJobs() {
		List<Job> findAll = jobRepo.findAll();
		return findAll;
	}
	
}
