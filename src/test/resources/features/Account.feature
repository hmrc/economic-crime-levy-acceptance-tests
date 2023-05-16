@all @account
Feature: ECL Dashboard

  Scenario: User that is registered for ECL can view the information about returns on ECL dashboard
    Given I am signed in to the account journey
    When I am on the ECL account dashboard
    Then I should be on the page that says Your return for 1 April 2022 to 31 March 2023 is due by 30 September 2023.
