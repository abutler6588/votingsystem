package com.myproject.votingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.votingsystem.entity.Citizen;
import com.myproject.votingsystem.repositories.CitizenRepo;

@RestController
public class index {
	
	@Autowired
	CitizenRepo citizenRepo;
	
	@RequestMapping("/doAction")
	public String doAction() {
		
		Citizen t = new Citizen((long)1, "Bob");
		citizenRepo.save(t);
		
		return "Success";
	}
}
