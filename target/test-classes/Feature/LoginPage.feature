Feature: Adactin Hotel WebPage Validation

  Scenario: Adactin Hotel Login Page Validation with Valid Credentials
    When User should be in Adactin Login Page
    And User should enter the valid credentials
    And User should click Login button
    Then User should validate Login Success
