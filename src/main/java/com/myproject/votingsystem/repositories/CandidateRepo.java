package com.myproject.votingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.votingsystem.entity.Candidate;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Integer> {

	
}
