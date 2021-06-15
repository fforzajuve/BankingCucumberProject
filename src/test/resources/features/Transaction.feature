Feature: Transactions Feature 

Scenario: Check transactions 
	Given user is logged in to application 
		|userName   |password  |
		|mngr330925 |zatydaz   |
	When user opens "Mini Statement" Navigation Menu 
	And user selects transactions for 93372 account 
	Then transaction should have following parts 
		|Transaction ID|
		|Amount|
		|Transaction Type|
		|Date of Transaction|
		|Description|
	And last five transactions should be displayed 