Feature: Login Functionality for LambdaTest Allpication


Scenario: Login to LambdaTest and validate login is success (positive testcase)
	Given Launch the url and Navigate to login Page
	Then Enter valid Username
	And Enter valid Password
	And Select login button
	Then Validate login is success

Scenario: Login to Invalid LambdaTest and validate error message (Negative testcase)
	Given Launch the url and Navigate to login Page
	And Enter valid Username
	And Enter invalid Password
	And Select login button
	Then Validate proper error message is getting displayed or not
