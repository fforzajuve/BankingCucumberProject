Feature: Login feature 

Scenario: Login with correct credentials 
	Given user is on login page 
	When user enters username "mngr330925" 
	And user enters password "zatydaz" 
	And user clicks on Login button 
	Then user with name "mngr330925" should be logged in 
	And navigation menu should be displayed 
	
Scenario: Login with wrong password 
	Given user is on login page 
	When user enters username "mngr330925" 
	And user enters password "sss" 
	And user clicks on Login button 
	Then "User or Password is not valid" alert should be displayed