Feature: Remove from card

Background: user is loged in
  Given the user is a logged in user


@Remove_one_item_from_card
Scenario: remove from card
  Given the user is in the Home page
  When he clicks on remove button for an added item
  Then items should removed from the card correctly

@Remove_multiple_items_from_card
Scenario: remove multiple items from card
  Given the user in the Home screen
  When he clicks on remove button for the added items
  Then the items should be removed from the card correctly