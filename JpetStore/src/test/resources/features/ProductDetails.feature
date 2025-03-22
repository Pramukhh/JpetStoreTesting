Feature: Product Details Page Validation

  Scenario: Validate product details
    Given I navigate to the homepage
    When I select a pet category "Dogs"
    And I choose a product "first"
    And I choose an item "first"
    And I should see the product title, description, price, images, and availability
    Then the product should be added to the cart