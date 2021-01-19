## Voting System Project – Enterprise level code

## Project Overview 

-	How it works: When a user first logs in, it will ask for their ID or a name. If we wanted to use an ID we could change it to a number. Once it enters that name, it will take the user to an application but first it will check if the user has voted already. If user has voted, it will be a yes or no pathway, if yes then it will provide the user with a page that says “you have vote,” if NOT, then it will give a choice for each candidate (ex. Candidate 1, Candidate 2 as an option). User can click on the one they want to vote for. After a user votes, they will be provided with a page that will render a “THANK YOU FOR VOTING,” page. If the page is refreshed, user can enter their name again and if they have noted it will display you’ve already vote. Another page to check the results. Must enter president password, for current president, it login correct, application will display the election results; example, candidate 1 got 50% of votes, candidate 2 got 50%. 

## Project Diagram

<img src="/images/Picture1.png">

## Technology stack:

•	Spring Boot (Java Framework)
•	Spring Security
•	REST
•	Spring Data JPA
•	HSQL DB
•	Maven
•	Junit  
•	Spring entity 
•	Thymeleaf

## Demo

- Input form for citzien to enter name

<img src="/images/Picture0.png">

- Candidate selection input from user 

<img src="/images/Picture2.png">

- Thank citizen for thier vote 

<img src="/images/Picture3.png">

- Error screen should citzien have already voted 

<img src="/images/Picture4.png">

