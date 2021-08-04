Feature: error message for invalid user name or password
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