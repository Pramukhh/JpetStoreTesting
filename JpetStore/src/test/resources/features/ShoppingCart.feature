Feature: Shopping Cart Checkout Process
  As a user
  I want to add products to the cart, update the cart, and proceed to checkout
  So that I can successfully place my order

  Scenario: Complete shopping cart process
    Given I enter the store and sign in
    When I choose a pet "fish"
    And I select a product "first", item "first" and add it to the cart
    And I return to the main menu and select another pet "dogs"
    And I select another product "third", item "first" and add it to the cart
    And I update the quantity of one product
    And I remove one product from the cart
    And I proceed to checkout
    And I continue after address confirmation
    Then I confirm and verify the order
