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