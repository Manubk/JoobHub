package com.joobhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joobhub.entity.Job;
import com.joobhub.service.IJobService;

@RestController
public class JobController {
	
	@Autowired
	private IJobService jobService;
	
	@GetMapping("jobs")
	public ResponseEntity<List<Job>> getAllJobs(){
		List<Job> allJobs = jobService.getAllJobs();
		
		return new ResponseEntity<List<Job>>(allJobs,HttpStatus.OK);
	}
	
	@GetMapping("job/{jobId}")
	public ResponseEntity<Job> findById(@RequestParam("jobId") Integer jobId){
		Job findById = jobService.findById(jobId);
		
		if(findById == null )
			return new ResponseEntity<Job>(findById,HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Job>(findById,HttpStatus.OK);
	}
	
	@PostMapping("job")
	public ResponseEntity<String> save(@RequestBody Job job){
		boolean save = jobService.save(job);
		
		return (save)?new ResponseEntity<String>("saved sucessfully",HttpStatus.OK):
				new ResponseEntity<String>("Unable to save",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("job")
	public ResponseEntity<String> updateJob(@RequestBody Job job){
		boolean save = jobService.save(job);
		
		return (save)?new ResponseEntity<String>("updated sucessfully",HttpStatus.OK):
			new ResponseEntity<String>("Unable to Update",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("job/{jobId}")
	public ResponseEntity<String> deleteById(@RequestParam("jobId") Integer jobId){
		
		boolean deleteById = jobService.deleteById(jobId);
		return (deleteById)?new ResponseEntity<String>("Deleted sucessfully",HttpStatus.OK):
			new ResponseEntity<String>("Unable to Delete or Record Not Found",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}	
