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
#      | DUE           |
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
#      | XMECL0000000006 | You have a payment of £23,100 due on 30 September 2023 for 1 April 2022 to 31 March 2023. |
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
#      | XMECL0000000007      | DUE            | 14600  |
      | XMECL0000000007      | OVERDUE        | 20500  |
      | XMECL0000000007      | PARTIALLY PAID | 2400   |
      | XMECL0000000005      | PAID           | 14000  |

  Scenario Outline: User is able to see the payment service page for make an ECL payment
    Given I am signed in to the account journey with my ECL reference as <ECL Reference>
    When I click on the Make an ECL payment link to pay the <payment status> payment
    Then I should be on the page that says <Expected content>
    Examples:
      | ECL Reference   | payment status | Expected content         |
#      | XMECL0000000006 | DUE            | When do you want to pay? |
      | XMECL0000000007 | OVERDUE        | Select an amount to pay  |

  Scenario: User is able to amend the returns they have submitted through ECL account dashboard
    Given I am signed in to the account journey with my ECL reference as XMECL0000000007
    When I provide the details to amend the submitted economic crime levy return
    Then I should be on the page that says Economic Crime Levy return amended

  Scenario: User is able to amend the registrations they have submitted through ECL account dashboard
    Given I am signed in to the account journey with my ECL reference as XMECL0000000001
    When I provide the details to amend the submitted economic crime levy registration
    Then I should be on the page that says Economic Crime Levy registration amendment requested

  Scenario: User has an overdue payment with accrued interest
    Given I am signed in to the account journey with my ECL reference as XMECL00000000010
    When I click on the View your payments link to view an interest accrued on the overdue payment
    And I should be on the page that says Interest charge XB001286323438 for ECL return number XMECL0000000005
    And I should see the interest amount £4.84 and Financial year 1 April 2021 to 31 March 2022

  Scenario: User without overdue payment views their ECL dashboard and see the interest payment as the most urgent payment to be made
    Given I am signed in to the account journey with my ECL reference as XMECL00000000010
    When I am on the ECL account dashboard
    And I should be on the page that says You owe an interest payment. Interest will continue to be accrued if not paid.

  Scenario: User clicks "View Payment" for partially-paid interest
    Given I am signed in to the account journey with my ECL reference as XMECL00000000014
    When I click on the View your payments link to view my partially-paid interest
    Then the interest row should display the partial interest payment information under Payments you owe
      | Payment Type   | Interest charge for ECL return number XM002610190690 |
      | Financial year | 1 April 2022 to 31 March 2023                        |
      | Amount Paid    | £12.73                                               |
      | Payment Status |                                                      |
      | Actions        |                                                       |

  Scenario: User clicks "View Payment" for fully paid interest
    Given I am signed in to the account journey with my ECL reference as XMECL00000000011
    When I am on the ECL account dashboard
    And I should be on the page that says You have no payments due.
    When I click on the View your payments link to view my fully paid interest
    Then the interest row should display the fully paid interest payment information under Payment History
      | Payment Date   | 9 February 2021                                       |
      | Payment Type   | Interest charge for ECL return number XMECL0000000005 |
      | Payment Period | 1 April 2021 to 31 March 2022                         |
      | You paid HMRC  | £114.84                                               |
      | Payment Status | PAID                                                  |
      | Actions        | Request a refund                                      |

  Scenario: User clicks "View Payment" to see the overdue payment information
    Given I am signed in to the account journey with my ECL reference as XMECL00000000012
    When I am on the ECL account dashboard
    And I should be on the page that says You have an overdue payment for 1 April 2021 to 31 March 2022.
    When I click on the View your payments link to view my overdue
    Then the overdue row should display the overdue payment information under Payment you owe
      | Payment Date   | 30 September 2022                          |
      | Payment Type   | Levy for ECL return number XMECL0000000005 |
      | Financial year | 1 April 2021 to 31 March 2022              |
      | You paid HMRC  | £4,000                                     |
      | Payment Status | OVERDUE                                    |
      | Actions        | Make a payment                             |
    And I click make a payment link to pay the overdue payment
    Then I should be on the page that says Select an amount to pay

