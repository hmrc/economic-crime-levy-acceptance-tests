@all @submit @accessibility
Feature: login to ECL

  Scenario: User able to navigate to economic crime levy returns page
    Given I am on the returns start page
    When I click on submit button
    Then text is displayed economic-crime-levy-returns-frontend
