Feature: Search Functionality
  Scenario: Search for pets and verify results
    Given I am on the JPetStore home page
    When I search for "Fish"
    Then I should see search results related to pet
    And I select a pet from searched result
    And I get the price and description
    Then I add the product to cart