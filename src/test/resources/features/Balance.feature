Feature: Balance Feature 

Scenario: Check Balance for Account 
	Given user is logged in to application 
		|userName   |password  |
		|mngr330925 |zatydaz   |
	When user opens "Balance Enquiry" Navigation Menu 
	And user selects account 93372 
	Then balance should be displayed for 93372 account 
	
Scenario Outline: Add Deposit to Account 
	Given user is logged in to application 
		|userName   |password  |
		|mngr330925 |zatydaz   |
	When user opens "Deposit" Navigation Menu 
	And user adds <amount> dollars to account 93372 
	Then <amount> dollars should be added to account 93372 
	
	Examples: 
		|amount|
		| 100  |
		| 200  |
		
Scenario: Withdraw money from Account 
	Given user is logged in to application 
		|userName   |password  |
		|mngr330925 |zatydaz   |
	When user opens "Withdrawal" Navigation Menu 
	And user withdraws 100 dollars from account 93372 
	Then 100 dollars should be taken from account 93372 
	
Scenario: Transfer fund from one account to another 
	Given user is logged in to application 
		|userName   |password  |
		|mngr330925 |zatydaz   |
	When user opens "Fund Transfer" Navigation Menu 
	And user transfers 100 dollars from account 93372 to account 93374 
	Then 100 dollars should be transfered from account 93372 to account 93374