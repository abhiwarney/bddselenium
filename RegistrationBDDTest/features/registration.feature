@execute  
  Feature: Registration Feature
  this feature helps user to register
  
  Scenario: user is trying to register using invalid set of details
  
  Given User is accing RegistrationPage on Browser
  
  When User is trying to submit data without entring 'User Id'
  Then 'User Id should not be empty / length be between 5 to 12' alert message should display
  
  When User is trying to submit request without entring 'Password'
  Then 'Password should not be empty / length be between 7 to 12' alert message should display
  
  When User is trying to submit request without entring 'username'
  Then 'Name should not be empty and must have alphabet characters only' alert message should display
  
  When User is trying to submit request without entring valid 'address'
  Then 'User address must have alphanumeric characters only' alert message should display
  
  When User is trying to submit request without selecting valid 'country'
  Then 'Select your country from the list' alert message should display
  
  When User is trying to submit request without entring valid 'zipCode'
  Then 'Zip code must have numeric characters only' alert message should display
  
  When User is trying to submit request without entring valid 'email'
  Then 'You have entered an invalid email address!' alert message should display
  
  When User is trying to submit request without selecting valid 'gender'
  Then 'Please select gender' alert message should display
  
  Scenario: User is trying to registre using valid set of details
  
  Given User is accing RegistrationPage on Browser
  
  When User is trying to submit request after entring valid set of information
  Then 'Your Registration with JobsWorld.com is Successfully done please check your registered email address to activate' alert message should display