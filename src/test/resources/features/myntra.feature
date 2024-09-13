Feature: Myntra Website Automation

  Scenario: Verify phone case selection and validation
    Given I am on the Myntra Website
    When I navigate to the Men Tab and select Phone Case from Fashion Accessories
    And I click on the 3rd row, 3rd item
    Then I verify that the price is displaced and it is not less that Rs. 10
    And I verify that the Add to bag button is displaced