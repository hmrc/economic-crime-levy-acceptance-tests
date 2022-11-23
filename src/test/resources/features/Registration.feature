@all @reg @accessibility @zap
Feature: Register for ECL service

  Scenario Outline: User able to select their UK revenue category for ECL service registration
    Given I am on the registration start page
    When I click on Start now button
    And I enter valid login credentials
    And I select a <UK revenue> category for ECL payments

    Examples:
      | UK revenue                          |
      |                                     |
      | Less than £10.2 million             |
      | Equal to or more than £10.2 million |