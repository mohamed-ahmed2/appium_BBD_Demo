Feature: login
 Scenario Outline: error msg should be displayed when the user enters invalid username and password
    Given he entered invalid "<username>"
    Given he write invalid "<password>"
    Given he clicked on login button
    Then error message should be displayed
   Examples:
     |  username|password
     |invalid_user1|12345
     |invalid_user2|6782
     |invalid_user3|58255
     |invalid_user4|0

   @valid_login
   Scenario Outline: user should be able to login when he enters valid username and password
     Given the user enters valid "<username>"
     And he entered valid "<pass>"
     When he clicks on login button
     Then he should be redirected to Home page
    Examples:
      |username|pass|
      |standard_user|secret_sauce|

