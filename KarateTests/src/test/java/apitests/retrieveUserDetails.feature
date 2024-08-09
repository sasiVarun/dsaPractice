@regressiontest
@smoketest
Feature: Retrieve User Details

Scenario: Retrieve User Details using the Get call

Given url ENDPOINT + '2'
When method GET
Then status 200
And print response

And match response.data.id == 2

