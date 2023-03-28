@all @enrolment
Feature: Claim enrolment for ECL

  Scenario: User that is registered for ECL starts an enrolment
    Given I am signed in to the enrolment journey
    When I provide the details of my ECL reference number
    Then I should be on the page that says Your details have been confirmed
