package com.joobhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joobhub.entity.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer> {

}
