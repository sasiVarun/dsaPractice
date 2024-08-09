@regressiontest
Feature: Read CSV data

  Scenario Outline: Read CSV data parameters and print details - "<State>"

		And print 'FirstName: ' + "<FirstName>"
		And print 'LastName: ' + "<FirstName>"
		And print 'State: ' + "<State>"
		And print 'Role: ' + "<Role>"
		
		Examples:
		| read('classpath:resources/data/userData.csv')|