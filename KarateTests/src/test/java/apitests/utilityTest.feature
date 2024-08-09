@regressiontest
Feature: Ramdom Utility Test

Scenario: Ramdom Utility Test

		#Generate Random Name
		Given def functions = Java.type('library.Utility')	
		Then def name = functions.generateRandomName()
		And print name.firstname
		And print name.lastname
		And print name.middlename
		
		#Generate Random Address based on state input
		Then def readAddress = functions.getRandomAddress('IN')
		And print readAddress.addressline1
		And print readAddress.city
		And print readAddress.state
		And print readAddress.zip
		 
		#Generate Random License Number based on state input
		Then def licenseIN = functions.getStateLicenseNumber('IN')
		And print 'IN License: ' + licenseIN
		Then def licenseOH = functions.getStateLicenseNumber('OH')
		And print 'OH License: ' + licenseOH
		
		#Retrieve Current Date
		Then def currentDate = functions.getCurrentDate()
		And print currentDate

		#Generate Basic Authentication Header
		And def loginDetails = call read('classpath:library/basic-auth.js') {username:"Raja@test", password:"gw"}
		And print loginDetails
		#And header Authentication = call read('classpath:library/basic-auth.js') {username:"Raja@test", password:"gw"}