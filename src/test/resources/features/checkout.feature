Feature: Checkout

  Background: user has added elemnts to the card
    Given   the user has added elements to the card

  @Checkout
  Scenario: checkout elements from card
    Given the user in card page
    When he clicks on the checkout button and confirm the checkout
    Then order should be checked out correctly