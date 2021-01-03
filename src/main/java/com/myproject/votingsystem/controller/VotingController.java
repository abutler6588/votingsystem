package com.myproject.votingsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
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
	
	public final Logger logger = Logger.getLogger(VotingController.class);
	
	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	
	//landing page directs to vote.html 
	@RequestMapping("/")
	public String goToVote() {
		logger.info("Returning vote.html file");
		return "vote.html";
	}
	
	//then enter our citizen name to login
	//checking that citizen/name  has not yet already voted
	@RequestMapping("/doLogin") 
	public String doLogin(@RequestParam String name, Model model, HttpSession session) {
		
		logger.info("getting citizen from database");
		
		//search database for the citizen
		Citizen citizen = citizenRepo.findByName(name);
		logger.info("putting citizen into session");
		//insert the citizen name during HTTPSession into session
		session.setAttribute("citizen", citizen);
				//if citizen has voted returns true, then perform return statement
		if (!citizen.getHasVoted()) {
			logger.info("putting candidates into model");
			List<Candidate> candidates = candidateRepo.findAll();
			model.addAttribute("candidates", candidates);
			return "/performVoted.html";
		} else {
			return "/alreadyVoted.html";
		}
	}
	
	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Long id, HttpSession session) {
		//check to see if citizen has already voted

		Citizen citizen = (Citizen)session.getAttribute("citizen");
		
	
		//if citzien.getHasVoted is false
		if(!citizen.getHasVoted()) {
			//then set citizen.setHasVoted to true
		citizen.setHasVoted(true);
			//then allow citizen to vote, works based upon the ID given for the citizen
		Candidate c = candidateRepo.findById((long)id);
		logger.info("voting for candidate" + c.getName());
		c.setNumberOfVotes(c.getNumberOfVotes()+1);
		
		candidateRepo.save(c);
		citizenRepo.save(citizen);
		
		return "voted.html";
		}
		
		return "alreadyVoted.html";
	}
	}
	
