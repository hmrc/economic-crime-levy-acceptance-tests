@all @account
Feature: ECL Dashboard details

  Scenario: User that is registered for ECL can view the information about returns on ECL dashboard
    Given I am signed in to the account journey
    When I am on the ECL account dashboard
    Then I should be on the page that says Your Economic Crime Levy account

  Scenario: User is able to see most recent returns due
    Given I am signed in to the account journey
    When I click on the Submit an Economic Crime Levy return link
    Then I should be on the page that says Submit your Economic Crime Levy return for 2021-2022

  Scenario Outline: User is able to see their returns details for the previous and current financial years
    Given I am signed in to the account journey
    When I click on the View or amend your returns link to view the <return status> return details
    Then I should be on the page that says Your Economic Crime Levy returns
    And I should see the payment status as <return status>
    Examples:
      | return status |
      | DUE           |
      | OVERDUE       |
      | SUBMITTED     |

  Scenario: User that is registered for ECL can make a returns submission through ECL dashboard
    Given I am signed in to the account journey
    When I provide the details to amend the returns through ECL dashboard link
    Then I should be on the page that says ECL registration details