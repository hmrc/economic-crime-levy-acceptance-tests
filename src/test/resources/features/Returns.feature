@all @submit @accessibility @zap
Feature: Submit ECL Return

  Scenario: User that is registered for ECL starts a return submission
    Given I am signed in to the return journey
    When I click on Start now button
    Then I should be on the page that says Is your relevant accounting period 12 months?

  Scenario: User that is registered for ECL starts a return submission
    Given I am signed in to the return journey
    When I provide the details to submit the economic crime levy return
    Then I should be on the page that says Check your answers