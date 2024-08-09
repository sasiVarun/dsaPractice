@regressiontest
@smoketest
@a1
Feature: Insert and Retrieve User details

  Scenario: Insert and Retrieve User details

  * print "entered"
  Given call read('classpath:apimethods/insertUserDetails.feature')
  And def id = response.id
  And def firstname = response.name
  And print id
  
  And call read('classpath:apimethods/updateUserDetails.feature') {"id": #(id), "firstname": #(firstname)}


