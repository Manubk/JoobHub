package com.joobhub.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "JOB_DETAILS")
@Data
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JOB_ID")
	private Integer jobId;
	
	@Column(name = "JOB_TITLE")
	private String jobTitle;
	
	@Column(name = "JOB_DESCRIPTION")
	private String jobDescription;
	
	@Column(name = "COMPANY")
	private String company;
	
	@Column(name = "EXPERIENCE")
	private String experience;
	
	@Column(name = "EDUCATION")
	private String education;
	
	@Column(name = "SALARY")
	private String salary;
	
	@Column(name = "JOB_LOCATION")
	private String jobLocation;
	
	@Column(name = "JOB_WORKMODE")
	private String workMode;
	
	@Column(name = "JOB_SWIFT")
	private String swift;
	
	@Column(name = "CREATED_AT",updatable = false)
	@CreationTimestamp
	private LocalDate createdAt;
	
	@Column(name = "UPDATED_AT",insertable = false)
	@UpdateTimestamp
	private LocalDate updatedAt;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "UPDATED_BY")
	private String updatedBy;
}
