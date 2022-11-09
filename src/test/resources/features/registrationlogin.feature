@all @reg @accessibility
Feature: login to ECL

  Scenario: User able to navigate to economic crime levy registration page
    Given I am on the registration start page
    When I click on submit button
    Then text is displayed economic-crime-levy-registration-frontend

