Feature: Home Page Verification
  Scenario: Verify the home page links and title
    Given I navigate to the JPetStore home page "https://petstore.octoperf.com/"
    Then I verify the page title is "JPetStore Demo"
    And I Enter to the store