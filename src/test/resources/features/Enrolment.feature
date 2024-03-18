@all @enrolment
Feature: Claim enrolment for ECL

  Scenario: User that is registered for ECL starts the claim enrolment journey
    Given I am signed in to the enrolment journey
    When I provide the details of my ECL reference number
    Then I should be on the page that says Your details have been confirmed

  Scenario: User selects the answer No for do they have an Economic Crime Levy reference number?
    Given I am signed in to the enrolment journey
    When I select No option for whether or not I have the ECL reference number
    Then I should be on the page that says You need to register for the Economic Crime Levy

  Scenario: User selects the answer I do not know for do they have an Economic Crime Levy reference number?
    Given I am signed in to the enrolment journey
    When I select Unknown option for whether or not I have the ECL reference number
    Then I should be on the page that says How to find your Economic Crime Levy reference number

  Scenario: User enters a valid date that does not match ECL records
    Given I am signed in to the enrolment journey
    When I enter the ECL registration date day as 10 month as 10 and year as 2022
    Then I should be on the page that says Your details do not match our records

  Scenario: User enters a valid ECL reference number that does not match ECL records
    Given I am signed in to the enrolment journey
    When I enter the economic crime levy reference number XMECL0000000002
    Then I should be on the page that says Your details do not match our records

