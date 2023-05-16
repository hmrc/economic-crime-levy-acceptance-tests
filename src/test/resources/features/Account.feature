@all @account
Feature: ECL Dashboard details

  Scenario: User that is registered for ECL can view the information about returns on ECL dashboard
    Given I am signed in to the account journey
    When I am on the ECL account dashboard
    Then I should be on the page that says Your Economic Crime Levy account

  Scenario: User is able to see most recent returns due
    Given I am signed in to the account journey
    When I click on the Submit an Economic Crime Levy return link
    Then I should be on the page that says Submit your Economic Crime Levy return for 2022-2023
