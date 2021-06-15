Feature: Account feature 

Scenario: Create new Account 
	Given user is logged in to application
		|userName   |password  |
		|mngr330925 |zatydaz   |
	When user opens "New Account" Navigation Menu 
	And user creates new account with following data
		|customerId|accountType|initialDeposit|
		|84217     |Savings    |500           |
	Then new account should be created
	And customer id should be 84217
	And account type should be "Savings"
	And account amount should be 500