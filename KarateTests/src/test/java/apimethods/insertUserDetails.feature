Feature: Insert User details

  Scenario: Insert User details using Post method
		Given def functions = Java.type('library.Utility')
		Then def name = functions.generateRandomName()
		And def req = read('classpath:resources/template/insertRequest.json')
	
		Given url ENDPOINT
		And request req
		When method post
		Then status 201
		And print response
		
		And match response.name == name.firstname
		And match response.id != null
	