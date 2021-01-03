package com.myproject.votingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.votingsystem.entity.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository <Citizen, Integer>{
	
	//return a citizen with a given name that we have inserted
	public Citizen findByName(String name);
	
}
