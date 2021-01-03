package com.myproject.votingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.votingsystem.entity.Candidate;
import com.myproject.votingsystem.entity.Citizen;
import com.myproject.votingsystem.repositories.CandidateRepo;
import com.myproject.votingsystem.repositories.CitizenRepo;

@Controller
public class VotingController {
	
	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	
	//landing page directs to vote.html 
	@RequestMapping("/")
	public String goToVote() {
		return "vote.html";
	}
	
	//then enter our citizen name to login
	//checking that citizen/name  has not yet already voted
	@RequestMapping("/doLogin") 
	public String doLogin(@RequestParam String name, Model model) {
				//search database for the citizen
		Citizen citizen = citizenRepo.findByName(name);
				//if citizen has voted returns true, then perform return statement
		if (!citizen.getHasVoted()) {
			List<Candidate> candidates = candidateRepo.findAll();
			model.addAttribute("candidates", candidates);
			return "/performVoted.html";
		} else {
			return "/alreadyVoted.html";
		}
	}
	
	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Long id) {
		
		Candidate c = candidateRepo.findById((long)id);
		c.setNumberOfVotes(c.getNumberOfVotes()+1);
		candidateRepo.save(c);
		
		return "voted.html";
		
	}
	}
	
