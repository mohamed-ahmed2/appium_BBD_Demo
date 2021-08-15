Feature: Add to Card

  Background: user is logged in
    Given   user is a logged in user

  @Add_one_item_to_card
  Scenario: Add item to card
    Given the user in Home page
    When he clicks on Add to card button
    Then item should be added to the card correctly

  @Add_multiple_items_to_card
   Scenario: Add multiple items to card
     Given the user in the Home page
     When he clicks on Add button for more than one item
     Then items should be added to the card correctly
