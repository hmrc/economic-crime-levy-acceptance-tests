@all @reg @accessibility @zap
Feature: Register for ECL service

  Scenario Outline: User able to select whether their UK revenue is less than or more than/equal to £10.2m
    Given I am on the registration start page
    When I click on Start now button
    And I click Submit button on authority wizard page
    And I select that my UK revenue is <UK revenue>

    Examples:
      | UK revenue         |
      |                    |
      | less-than          |
      | equal-or-more-than |