@all @account
Feature: ECL Dashboard details

  Scenario: User that is registered for ECL can view the information about returns on ECL dashboard
    Given I am signed in to the account journey with my ECL reference as XMECL0000000005
    When I am on the ECL account dashboard
    Then I should be on the page that says Your Economic Crime Levy account

  Scenario: User is able to submit most recent returns
    Given I am signed in to the account journey with my ECL reference as XMECL0000000005
    When I click on the Submit an Economic Crime Levy return link
    And I provide the details to submit the economic crime levy return
    Then I should be on the page that says Return submitted

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

  Scenario: User that is registered for ECL can view their completed payments
    Given I am signed in to the account journey with my ECL reference as XMECL0000000005
    When I am on the ECL account dashboard
    Then I should be on the page that says You have no payments due.

  Scenario: User that is registered for ECL can view their overdue payments
    Given I am signed in to the account journey with my ECL reference as XMECL0000000007
    When I am on the ECL account dashboard
    Then I should be on the page that says You have an overdue payment for 1 April 2022 to 31 March 2023.
    And I should be on the page that says We are charging you interest on this payment. You owe £20,500.

  Scenario Outline: User is able to see their payment details for the previous and current financial years
    Given I am signed in to the account journey with my ECL reference as <ECL Reference Number>
    When I click on the View your payments link to view the <payment status> payment details
    Then I should be on the page that says Your Economic Crime Levy payments
    And I should see the <payment status> payment amount <Amount>
    And I should see the payment status as <payment status>
    Examples:
      | ECL Reference Number | payment status | Amount |
      | XMECL0000000007      | OVERDUE        | 20500  |
      | XMECL0000000007      | PARTIALLY PAID | 2400   |
      | XMECL0000000005      | PAID           | 14000  |

  Scenario Outline: User is able to see the payment service page for make an ECL payment
    Given I am signed in to the account journey with my ECL reference as <ECL Reference>
    When I click on the Make an ECL payment link to pay the <payment status> payment
    Then I should be on the page that says <Expected content>
    Examples:
      | ECL Reference   | payment status | Expected content         |
      | XMECL0000000007 | OVERDUE        | Select an amount to pay  |

  Scenario: User without overdue payment views their ECL dashboard and see the interest payment as the most urgent payment to be made
    Given I am signed in to the account journey with my ECL reference as XMECL00000000010
    When I am on the ECL account dashboard
    And I should be on the page that says You owe an interest payment. Interest will continue to be accrued if not paid.

  Scenario: User clicks "View Payment" for partially-paid interest
    Given I am signed in to the account journey with my ECL reference as XMECL00000000014
    When I click on the View your payments link to view my interest charge
    Then the interest row should display the partial interest payment information under Payments you owe
      | Payment Type   | Interest charge for ECL return number XMECL0000000014 |
      | Financial year | 1 April 2023 to 31 March 2024                         |
      | Amount Paid    | £12.73                                                |
      | Payment Status |                                                       |
      | Actions        |                                                       |

  Scenario: User clicks "View Payment" for fully paid interest
    Given I am signed in to the account journey with my ECL reference as XMECL00000000011
    When I am on the ECL account dashboard
    And I should be on the page that says You have no payments due.
    When I click on the View your payments link to view my fully paid interest
    Then I click on the Back link
    Then I am on the ECL account dashboard
    When I click on the View your payments link to view my fully paid interest
    Then the interest row should display the fully paid interest payment information under Payment History
      | Payment Date   | 9 February 2022                                       |
      | Payment Type   | Interest charge for ECL return number XMECL0000000011 |
      | Payment Period | 1 April 2022 to 31 March 2023                         |
      | You paid HMRC  | £114.84                                               |
      | Payment Status | PAID                                                  |
      | Actions        | Request a refund                                      |

  Scenario: User clicks "View Payment" to see the overdue payment information
    Given I am signed in to the account journey with my ECL reference as XMECL00000000012
    When I am on the ECL account dashboard
    And I should be on the page that says You have an overdue payment for 1 April 2022 to 31 March 2023.
    When I click on the View your payments link to view my overdue
    Then the overdue row should display the overdue payment information under Payment you owe
      | Payment Date   | 30 September 2023                          |
      | Payment Type   | Levy for ECL return number XMECL0000000012 |
      | Financial year | 1 April 2022 to 31 March 2023              |
      | You paid HMRC  | £4,000                                     |
      | Payment Status | OVERDUE                                    |
      | Actions        | Make a payment                             |
    And I click make a payment link to pay the overdue payment
    Then I should be on the page that says Select an amount to pay
