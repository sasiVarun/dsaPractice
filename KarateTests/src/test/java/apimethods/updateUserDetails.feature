Feature: Update User details

  Scenario: Update User details using Patch method
		And def req =  read('classpath:resources/template/updateRequest.json')

		Given url ENDPOINT + id
		And request req
		When method patch
		Then status 200
		And print response
		
		And match response.job == "zion leader"