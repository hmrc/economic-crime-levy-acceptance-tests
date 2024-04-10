@all @account @registration
Feature: ECL account Dashboard after De-registration

  Scenario: User view their dashboard after successful de-registration
    Given I am signed in to the account journey with my ECL reference as XMECL00000000019
    When I am on the ECL account dashboard
    Then I should see the de registered ECL reference number as ECL reference number: XMECL00000000019
    And I should be on the page that says You deregistered this account.
    And I should be on the page that says You have no returns due.
    And I should be on the page that says You have an overdue payment for 1 April 2022 to 31 March 2023.

  Scenario Outline: User views payments after successful de-registration
    Given I am signed in to the account journey with my ECL reference as XMECL00000000019
    When I click on the View or amend your returns or View your payments link to view the deregistered <link> details
    Then the links <link> under the Action column should be visible on the the page
    Examples:
      | link     |
      | Returns  |
      | Payments |

  Scenario: User able to request ECL de-registration
    Given I am signed in to the account journey with my ECL reference as XMECL00000000002
    When I provide the details to de register the ECL account from the system
    Then I should be on the page that says Deregistration requested
