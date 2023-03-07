@all @returns
Feature: Submit ECL Return

  Scenario: User that is registered for ECL starts a return submission
    Given I am signed in to the return journey
    When I provide the details to submit the economic crime levy return
    Then I should be on the page that says Check your answers

  Scenario Outline: User does not provide their contact person's valid name for completing the ECL return
    Given I am signed in to the return journey
    When I enter the contact person's name <Name> for completing my ECL return
    Then I should see an error that says <Expected content>

    Examples:
      | Name                                                                                                                                                              | Expected content                         |
      |                                                                                                                                                                   | Enter a full name                        |
      | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstu1234567890!@£#$%^&*()-+={}[]"';:,.<>/? | Full name must be 160 characters or less |

  Scenario Outline: User does not provide their contact person's valid role for completing the ECL return
    Given I am signed in to the return journey
    When I enter the contact person's role <Role> for completing my ECL return
    Then I should see an error that says <Expected content>

    Examples:
      | Role                                                                                                                                                              | Expected content                    |
      |                                                                                                                                                                   | Enter a role                        |
      | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstu1234567890!@£#$%^&*()-+={}[]"';:,.<>/? | Role must be 160 characters or less |

  Scenario Outline: User does not provide their contact person's valid email address for completing the ECL return
    Given I am signed in to the return journey
    When I enter the contact person's email address <Email address> for completing my ECL return
    Then I should see an error that says <Expected content>

    Examples:
      | Email address | Expected content                                                    |
      |               | Enter an email address                                              |
      | email-address | Enter an email address in the correct format, like name@example.com |

  Scenario Outline: User does not provide their contact person's valid contact number for for completing the ECL return
    Given I am signed in to the return journey
    When I enter the contact person's contact number <Contact number> for completing my ECL return
    Then I should see an error that says <Expected content>

    Examples:
      | Contact number            | Expected content                                                                |
      |                           | Enter a telephone number                                                        |
      | 1234567890123456789012345 | Telephone number must be 24 characters or less                                  |
      | contact number            | Enter a telephone number, like 01632 960 001, 07700 900 982 or +44 808 157 0192 |
      | 1234567890_               | Enter a telephone number, like 01632 960 001, 07700 900 982 or +44 808 157 0192 |

  Scenario: User does not select whether or not their relevant accounting period 12 months
    Given I am signed in to the return journey
    When I do not select an option for my relevant accounting period 12 months
    Then I should see an error that says Select an answer

  Scenario: User selects no on whether or not their relevant accounting period 12 months
    Given I am signed in to the return journey
    When I select No option for my relevant accounting period 12 months
    Then I should see an error that says How long is your relevant accounting period?

  Scenario: User does not select how long is their relevant accounting period?
    Given I am signed in to the return journey
    When I do not enter the length of my accounting period
    Then I should see an error that says Enter the length

  Scenario Outline: User enters an invalid length for their relevant accounting period
    Given I am signed in to the return journey
    When I enter the length of my relevant accounting period in days <Days>
    Then I should see an error that says <Expected content>
    Examples:
      | Days  | Expected content                      |
      |       | Enter the length                      |
      | 0     | Length must be between 1 and 999 days |
      | -1    | Length must be between 1 and 999 days |
      | 1000  | Length must be between 1 and 999 days |
      | asdwa | Length must be a whole number         |
      | 245.0 | Length must be a whole number         |

  Scenario Outline: User enters an invalid amount for UK revenue for their relevant accounting period
    Given I am signed in to the return journey
    When I enter the UK revenue <UK Revenue> for my relevant accounting period
    Then I should see an error that says <Expected content>
    Examples:
      | UK Revenue | Expected content                                              |
      |            | Enter the UK revenue                                          |
      | -1         | UK revenue must be between 0 and 99,999,999,999               |
      | asdfg      | UK revenue must be a number rounded down to the nearest pound |
      | 99.999     | UK revenue must be a number rounded down to the nearest pound |
      | 1019999.99 | UK revenue must be a number rounded down to the nearest pound |

  Scenario: User does not select whether or not they carry out AML-regulated activity for the full financial year?
    Given I am signed in to the return journey
    When I do not select an option for whether or not I carry out AML-regulated activity for the full financial year?
    Then I should see an error that says Select if you carried out AML-regulated activity in the financial year

  Scenario: User select no whether or not they carry out AML-regulated activity for the full financial year?
    Given I am signed in to the return journey
    When I select No option for my AML-regulated activity for the full financial year
    Then I should see an error that says How many days of the financial year did you carry out AML-regulated activity?

  Scenario Outline: User enters an invalid number of days of AML regulated activity in the financial year
    Given I am signed in to the return journey
    When I enter the total number of days <Days> I carried out AML regulated activity
    Then I should see an error that says <Expected content>
    Examples:
      | Days  | Expected content                      |
      |       | Enter the number of days you carried out AML-regulated activity                      |
      | 0     | Length must be between 1 and 999 days |
      | -1    | Length must be between 1 and 999 days |
      | 1000  | Length must be between 1 and 999 days |
      | asdwa | Length must be a whole number         |
      | 245.0 | Length must be a whole number         |
