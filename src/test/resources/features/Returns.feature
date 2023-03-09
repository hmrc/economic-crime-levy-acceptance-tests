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

  Scenario: User does not select whether or not their relevant accounting period is 12 months
    Given I am signed in to the return journey
    When I do not select an option for my relevant accounting period 12 months
    Then I should see an error that says Select an answer

  Scenario: User selects no on whether or not their relevant accounting period 12 is months
    Given I am signed in to the return journey
    When I select No option for my relevant accounting period 12 months
    Then I should see an error that says How long is your relevant accounting period?

  Scenario: User does not enter how long their relevant accounting period is?
    Given I am signed in to the return journey
    When I do not enter the length of my accounting period
    Then I should see an error that says Enter the length

  Scenario: User enters a valid length for their relevant accounting period
    Given I am signed in to the return journey
    When I enter the length of my relevant accounting period as 364 days
    Then I should see an error that says What was your UK revenue for the relevant accounting period?

  Scenario Outline: User enters an invalid length for their relevant accounting period
    Given I am signed in to the return journey
    When I enter the length of my relevant accounting period as <Days> days
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

  Scenario: User does not select whether or not they carried out AML-regulated activity for the full financial year
    Given I am signed in to the return journey
    When I do not select an option for whether or not I carry out AML-regulated activity for the full financial year?
    Then I should see an error that says Select if you carried out AML-regulated activity in the financial year

  Scenario: User selects no for whether or not they carried out AML-regulated activity for the full financial year
    Given I am signed in to the return journey
    When I select No option for my AML-regulated activity for the full financial year
    Then I should see an error that says How many days of the financial year did you carry out AML-regulated activity?

  Scenario Outline: User enters an invalid number of days of AML regulated activity in the financial year
    Given I am signed in to the return journey
    When I enter the total number of days <Days> I carried out AML regulated activity
    Then I should see an error that says <Expected content>
    Examples:
      | Days  | Expected content                                                |
      |       | Enter the number of days you carried out AML-regulated activity |
      | 0     | Length must be between 1 and 999 days                           |
      | -1    | Length must be between 1 and 999 days                           |
      | 1000  | Length must be between 1 and 999 days                           |
      | asdwa | Length must be a whole number                                   |
      | 245.0 | Length must be a whole number                                   |

  Scenario Outline: Return submission for 12 month accounting period and AML-regulated activity for the full financial year
    Given I am signed in to the return journey
    When I enter 12 month accounting period revenue <UK Revenue> and select Yes for my AML-regulated activity for the full financial year
    Then I should be on the page that says <Expected content>
    Examples:
      | UK Revenue | Expected content                                                        |
      | 10199999   | The amount of levy you need to pay for this financial year is £0.00      |
      | 10200000   | The amount of levy you need to pay for this financial year is £10,000.  |
      | 35999999   | The amount of levy you need to pay for this financial year is £10,000.  |
      | 36000000   | The amount of levy you need to pay for this financial year is £36,000.  |
      | 999999999  | The amount of levy you need to pay for this financial year is £36,000.  |
      | 1000000000 | The amount of levy you need to pay for this financial year is £250,000. |

  Scenario Outline: Return submission for 12 month accounting period and AML-regulated activity for the non-full financial year
    Given I am signed in to the return journey
    When I enter 12 month accounting period revenue <UK Revenue> and select No for my AML-regulated activity for the full financial year
    And I enter the number of days <AMLDays> I carried out AML regulated activity during the financial year
    Then I should be see the amount of ECL need to pay <Expected content>
    Examples:
      | UK Revenue | AMLDays | Expected content                                                           |
      | 10199999   | 120     | The amount of levy you need to pay for this financial year is £0.00.          |
      | 10200000   | 60      | The amount of levy you need to pay for this financial year is £1,643.83.   |
      | 999999999  | 204     | The amount of levy you need to pay for this financial year is £20,120.54.  |
      | 1000000000 | 330     | The amount of levy you need to pay for this financial year is £226,027.39. |

  Scenario Outline: Return submission for non 12 month accounting period and AML-regulated activity for the full financial year
    Given I am signed in to the return journey
    When I select No for my accounting period 12 months and enter the length of my accounting period as <APDays> days
    And I enter my UK revenue <UK Revenue> for the accounting period and select Yes for my AML-regulated activity for the full financial year
    Then I should be see the amount of ECL need to pay <Expected content>
    Examples:
      | UK Revenue | APDays | Expected content                                                        |
      | 5000000    | 245    | The amount of levy you need to pay for this financial year is £0.00.      |
      | 10000000   | 182    | The amount of levy you need to pay for this financial year is £10,000.00. |
      | 8000000    | 73     | The amount of levy you need to pay for this financial year is £36,000.00.  |
      | 1300000000 | 450    | The amount of levy you need to pay for this financial year is £250,000.00. |


  Scenario Outline: Return submission for non 12 month accounting period and AML-regulated activity for the non-full financial year
    Given I am signed in to the return journey
    When I select No for my accounting period 12 months and enter the length of my accounting period as <APDays> days
    And I enter my UK revenue <UK Revenue> for the accounting period and select No for my AML-regulated activity for the full financial year
    And I enter the number of days <AMLDays> I carried out AML regulated activity during the financial year
    Then I should be see the amount of ECL need to pay <Expected content>
    Examples:
      | UK Revenue | APDays | AMLDays | Expected content                                                           |
      | 7000000    | 314    | 92      | The amount of levy you need to pay for this financial year is £0.00.          |
      | 10000000   | 113    | 198     | The amount of levy you need to pay for this financial year is £5,424.65.   |
      | 31000000   | 284    | 300     | The amount of levy you need to pay for this financial year is £29,589.04.  |
      | 350000000  | 91     | 256     | The amount of levy you need to pay for this financial year is £175,342.46. |

  Scenario: User wants to go to check your answers page directly without providing any of the previous pages details
    Given I am signed in to the return journey
    When I go to the return submission check your answers page directly without providing answers for any of the previous page questions
    Then I should be on the page that says The answers you provided are not valid

  Scenario: User wants to change the contact details before submitting the returns
    Given I am signed in to the return journey
    When I click on the change link to modify my contact details
    Then I should be on the page that says Check your answers