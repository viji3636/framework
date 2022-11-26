Feature: Login Functionality for LambdaTest Allpication 

Background: 
	Given Launch the url and Navigate to login Page 
	
@endtoend
Scenario Outline: Login and validate login with multiple set of testdata (negative testcase)
	And Enter valid Username as <username>
	And Enter Password as <password>
	Then Select login button

Examples:
|username|password|
|'sampletest001@gmail.com'|'Qwerty@0000'|
|'sampletest001@gmail.com'|'sdasdasd@0000'|