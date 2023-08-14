@all @account
Feature: ECL Dashboard details

  Scenario: User that is registered for ECL can view the information about returns on ECL dashboard
    Given I am signed in to the account journey with my ECL reference as XMECL0000000005
    When I am on the ECL account dashboard
    Then I should be on the page that says Your Economic Crime Levy account

  Scenario: User is able to see most recent returns due
    Given I am signed in to the account journey with my ECL reference as XMECL0000000005
    When I click on the Submit an Economic Crime Levy return link
    Then I should be on the page that says Submit your Economic Crime Levy return for 2021-2022

  Scenario Outline: User is able to see their returns details for the previous and current financial years
    Given I am signed in to the account journey with my ECL reference as XMECL0000000005
    When I click on the View or amend your returns link to view the <return status> return details
    Then I should be on the page that says Your Economic Crime Levy returns
    And I should see the return status as <return status>
    Examples:
      | return status |
      | DUE           |
      | OVERDUE       |
      | SUBMITTED     |

  Scenario: User that is registered for ECL can make a returns submission through ECL dashboard
    Given I am signed in to the account journey with my ECL reference as XMECL0000000005
    When I provide the registration details to submit a return through ECL dashboard link
    Then I should be on the page that says ECL registration details

  Scenario Outline: User that is registered for ECL can view their due and completed payments
    Given I am signed in to the account journey with my ECL reference as <ECL Reference>
    When I am on the ECL account dashboard
    Then I should be on the page that says <Expected content>
    Examples:
      | ECL Reference   | Expected content                                                                          |
      | XMECL0000000006 | You have a payment of £23,100 due on 30 September 2023 for 1 April 2022 to 31 March 2023. |
      | XMECL0000000005 | You have no payments due.                                                                 |

  Scenario: User that is registered for ECL can view their overdue payments
    Given I am signed in to the account journey with my ECL reference as XMECL0000000007
    When I am on the ECL account dashboard
    Then I should be on the page that says You have an overdue payment for 1 April 2021 to 31 March 2022.
    And I should be on the page that says We are charging you interest on this payment. You owe £20,500.

  Scenario Outline: User is able to see their payment details for the previous and current financial years
    Given I am signed in to the account journey with my ECL reference as <ECL Reference Number>
    When I click on the View your payments link to view the <payment status> payment details
    Then I should be on the page that says Your Economic Crime Levy payments
    And I should see the <payment status> payment amount <Amount>
    And I should see the payment status as <payment status>
    Examples:
      | ECL Reference Number | payment status | Amount |
      | XMECL0000000007      | DUE            | 14600  |
      | XMECL0000000007      | OVERDUE        | 20500  |
      | XMECL0000000007      | PARTIALLY PAID | 2400   |
      | XMECL0000000005      | PAID           | 14000  |

  Scenario Outline: User is able to see the payment service page for make an ECL payment
    Given I am signed in to the account journey with my ECL reference as <ECL Reference>
    When I click on the Make an ECL payment link to pay the <payment status> payment
    Then I should be on the page that says <Expected content>
    Examples:
      | ECL Reference   | payment status | Expected content         |
      | XMECL0000000006 | DUE            | When do you want to pay? |
      | XMECL0000000007 | OVERDUE        | Select an amount to pay  |

  Scenario: User is able to amend the returns they have submitted through ECL account dashboard
    Given I am signed in to the account journey with my ECL reference as XMECL0000000006
    When I provide the details to amend the submitted economic crime levy return
    Then I should be on the page that says Economic Crime Levy return amended
