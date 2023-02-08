@all @submit @accessibility @zap
Feature: Submit ECL Return

  Scenario: User starts a return for submission after the registration for AML that is liable for ECL
    Given I am signed in to the return journey
    When I click on Start now button
    Then I should be on the page that says Is your relevant accounting period 12 months?
