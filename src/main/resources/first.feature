Feature: Saving the user information in the app

  Scenario Outline: Successful in saving user informaion
    Given I input the username as "<username>"
    And provide the password as "<password>"
    And provide the confirm password as "<confirmPassword>"
    And provide the email as "<email>"
    And provide the postal address as "<postalAddress>"
    And provide the street as "<street>"
    And provide the zipcode as "<zipcode>"
    And provide the city as "<city>"
    And provide the country as "<country>"
    And provide the dob as "<dob>"
    And I am able to save the information
    
	Examples:
		| username  | password  | confirmPassword | email               | postalAddress | street  | zipcode | city    | country   | dob        |
		| yeshendra | yA9@verma | yA9@verma       | yashv1991@gmail.com | Chinhat			  | Chinhat | 226028  | Lucknow | INDIA     | 2000-03-01 |
		| yeshendrk | yA9@verma | yA9@verma       | 28yashver@gmail.com | Chinhat			  | Chinhat | 226028  | Lucknow | INDIA     | 2000-03-01 |
		| yeshendrv | yA9@verma | vA9@verma       | yashverma@gmail.com | Chinhat			  | Chinhat | 226028  | Lucknow | INDIA     | 2000-03-01 |