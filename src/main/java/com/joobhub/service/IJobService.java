package com.joobhub.service;

import java.util.List;

import com.joobhub.entity.Job;

public interface IJobService {
	public boolean save(Job job);
	public boolean deleteById(Integer jobId);
	public Job findById(Integer jobId);
	public List<Job> getAllJobs();
	
}
