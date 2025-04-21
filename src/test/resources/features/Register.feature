Feature:

  #Scenenario 1
  Scenario: Register account successfully
    Given I have the website up
    When I enter a valid birthdate
    When I enter a valid first name
    When I enter a valid last name
    When I enter a valid email address
    When I enter a valid password
    When I click terms and conditions
    When I click I am eighteen years of age box
    When I click the code of ethics box
    Then I registered a new account


    #Scenenario 2
    Scenario: Missing last name
      Given I have the website up
      When I enter a valid birthdate
      When I enter a valid first name
      When I enter a valid email address
      When I enter a valid password
      When I click terms and conditions
      When I click I am eighteen years of age box
      When I click the code of ethics box
      When I click confirm and join
      Then I get result you forgot your last name


      #Scenenario 3
  Scenario: Passwords do not match
    Given I have the website up
    When I enter a valid birthdate
    When I enter a valid first name
    When I enter a valid last name
    When I enter a valid email address
    When I enter different passwords
    When I click terms and conditions
    When I click I am eighteen years of age box
    When I click the code of ethics box
    When I click confirm and join
    Then I get result your passwords arent matching


    #Scenenario 4
  Scenario: Terms and conditions unchecked
    Given I have the website up
    When I enter a valid birthdate
    When I enter a valid first name
    When I enter a valid last name
    When I enter a valid email address
    When I enter a valid password
    When I click the code of ethics box
    When I click I am eighteen years of age box
    When I click confirm and join
    Then I get result you must agree to terms and conditions
