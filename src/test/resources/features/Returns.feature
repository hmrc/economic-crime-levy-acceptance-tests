@all @returns
Feature: Submit ECL Return

  Scenario: User that is registered for ECL starts a return submission
    Given I am signed in to the return journey
    When I provide the details to submit the economic crime levy return
    Then I should be on the page that says Return submitted
    And I should see my ecl return number is ECL return number and the amount to pay is Amount you need to pay
@validations
  Scenario Outline: User does not provide their contact person's valid name for completing the ECL return
    Given I am signed in to the return journey
    When I enter the contact person's name <Name> for completing my ECL return
    Then I should see an error that says <Expected content>

    Examples:
      | Name                                                                                                                                                              | Expected content                                                                                           |
      |                                                                                                                                                                   | Enter a full name                                                                                          |
      | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstu1234567890!@£#$%^&*()-+={}[]"';:,.<>/? | Full name must be 160 characters or less                                                                   |
      | James@                                                                                                                                                            | Full name must only include letters a to z, and special characters such as hyphens, spaces and apostrophes |
@validations
  Scenario Outline: User does not provide their contact person's valid role for completing the ECL return
    Given I am signed in to the return journey
    When I enter the contact person's role <Role> for completing my ECL return
    Then I should see an error that says <Expected content>

    Examples:
      | Role                                                                                                                                                              | Expected content                                                                                      |
      |                                                                                                                                                                   | Enter a role                                                                                          |
      | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstu1234567890!@£#$%^&*()-+={}[]"';:,.<>/? | Role must be 160 characters or less                                                                   |
      | Compliance officer#                                                                                                                                               | Role must only include letters a to z, and special characters such as hyphens, spaces and apostrophes |
@validations
  Scenario Outline: User does not provide their contact person's valid email address for completing the ECL return
    Given I am signed in to the return journey
    When I enter the contact person's email address <Email address> for completing my ECL return
    Then I should see an error that says <Expected content>

    Examples:
      | Email address                                                                                                                         | Expected content                                                    |
      |                                                                                                                                       | Enter an email address                                              |
      | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUV@oc.com | Email address must be 132 characters or less                        |
      | email-address                                                                                                                         | Enter an email address in the correct format, like name@example.com |
@validations
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
@validations
  Scenario: User does not select whether or not their relevant accounting period is 12 months
    Given I am signed in to the return journey
    When I do not select an option for my relevant accounting period 12 months
    Then I should see an error that says Select yes if you have a relevant accounting period that ends in the financial year

  Scenario: User selects no on whether or not their relevant accounting period 12 is months
    Given I am signed in to the return journey
    When I select No option for my relevant accounting period 12 months
    Then I should be on the page that says How long is your relevant accounting period?
@validations
  Scenario: User does not enter how long their relevant accounting period is?
    Given I am signed in to the return journey
    When I do not enter the length of my accounting period
    Then I should see an error that says Enter the length

  Scenario: User enters a valid length for their relevant accounting period
    Given I am signed in to the return journey
    When I enter the length of my relevant accounting period as 364 days
    Then I should be on the page that says Total UK revenue
@validations
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
@validations
  Scenario Outline: User enters an invalid amount for UK revenue for their relevant accounting period
    Given I am signed in to the return journey
    When I enter the UK revenue <UK Revenue> for my relevant accounting period
    Then I should see an error that says <Expected content>
    Examples:
      | UK Revenue | Expected content                                              |
      |            | Enter the total UK revenue                                    |
      | -1         | UK revenue must be between 0 and 99,999,999,999.99            |
      | asdfg      | The total UK revenue can only include pounds and pence        |
      | 99.999     | The total UK revenue can only include pounds and pence        |
@validations
  Scenario: User does not select whether or not they carried out AML-regulated activity for the full financial year
    Given I am signed in to the return journey
    When I do not select an option for whether or not I carry out AML-regulated activity for the full financial year?
    Then I should see an error that says Select yes if you have a relevant accounting period that ends in the financial year
@validations
  Scenario: User selects no for whether or not they carried out AML-regulated activity for the full financial year
    Given I am signed in to the return journey
    When I select No option for my AML-regulated activity for the full financial year
    Then I should be on the page that says How many days of the financial year did you carry out AML-regulated activity?
@validations
  Scenario Outline: User enters an invalid number of days of AML regulated activity in the financial year
    Given I am signed in to the return journey
    When I enter the total number of days <Days> I carried out AML regulated activity
    Then I should see an error that says <Expected content>
    Examples:
      | Days  | Expected content                                                |
      |       | Enter the number of days you carried out AML-regulated activity |
      | -1    | Length must be between 0 and 365 days                           |
      | 1000  | Length must be between 0 and 365 days                           |
      | asdwa | Length must be a whole number                                   |
      | 245.0 | Length must be a whole number                                   |
@validations
  Scenario Outline: Return submission for 12 month accounting period and AML-regulated activity for the full financial year
    Given I am signed in to the return journey
    When I enter 12 month accounting period revenue <UK Revenue> and select Yes for my AML-regulated activity for the full financial year
    Then I should be on the page that says <Expected content>
    Examples:
      | UK Revenue | Expected content                                           |
      | 10200000   | You need to pay £10,000   |
      | 35999999   | You need to pay £10,000  |
      | 36000000   | You need to pay £36,000   |
      | 999999999  | You need to pay £36,000  |
      | 1000000000 | You need to pay £250,000 |

  Scenario Outline: Return submission for 12 month accounting period and AML-regulated activity for the non-full financial year
    Given I am signed in to the return journey
    When I enter 12 month accounting period revenue <UK Revenue> and select No for my AML-regulated activity for the full financial year
    And I enter the number of days <AMLDays> I carried out AML regulated activity during the financial year
    Then I should be on the page that says <Expected content>
    Examples:
      | UK Revenue | AMLDays | Expected content                                              |
      | 10200000   | 60      | You need to pay £1,643.83    |
      | 999999999  | 204     | You need to pay £20,120.54  |
      | 1000000000 | 330     | You need to pay £226,027.39 |

  Scenario Outline: Return submission for non 12 month accounting period and AML-regulated activity for the full financial year
    Given I am signed in to the return journey
    When I select No for my accounting period 12 months and enter the length of my accounting period as <APDays> days
    And I enter my UK revenue <UK Revenue> for the accounting period and select Yes for my AML-regulated activity for the full financial year
    Then I should be on the page that says <Expected content>
    Examples:
      | UK Revenue | APDays | Expected content                                           |
      | 10000000   | 182    | You need to pay £10,000   |
      | 8000000    | 73     | You need to pay £36,000   |
      | 1300000000 | 450    | You need to pay £250,000  |


  Scenario Outline: Return submission for non 12 month accounting period and AML-regulated activity for the non-full financial year
    Given I am signed in to the return journey
    When I select No for my accounting period 12 months and enter the length of my accounting period as <APDays> days
    And I enter my UK revenue <UK Revenue> for the accounting period and select No for my AML-regulated activity for the full financial year
    And I enter the number of days <AMLDays> I carried out AML regulated activity during the financial year
    Then I should be on the page that says <Expected content>
    Examples:
      | UK Revenue | APDays | AMLDays | Expected content                                              |
      | 10000000   | 113    | 198     | You need to pay £5,424.65    |
      | 31000000   | 284    | 300     | You need to pay £29,589.04  |
      | 350000000  | 91     | 256     | You need to pay £175,342.46  |

  Scenario: User wants to go to check your answers page directly without providing any of the previous pages details
    Given I am signed in to the return journey
    When I go to the return submission check your answers page directly without providing answers for any of the previous page questions
    Then I should be on the page that says The answers you provided are not valid

  Scenario: User wants to change their ECL contact details before submitting the returns
    Given I am signed in to the return journey
    When I click on the change link to modify my contact details
    Then I should be on the page that says Check your answers

  Scenario: User wants to change their ECL accounting period before submitting the returns
    Given I am signed in to the return journey
    When I click on the change link to modify my economic crime levy accounting period
    Then I should be on the page that says Check your answers

  Scenario: User wants to change their ECL accounting period length before submitting the returns
    Given I am signed in to the return journey
    When I click on the change link to modify my accounting period length
    Then I should be on the page that says Check your answers

  Scenario: User wants to change their ECL UK revenue before submitting the returns
    Given I am signed in to the return journey
    When I click on the change link to modify my uk revenue
    Then I should be on the page that says Check your answers

  Scenario: User wants to change their AML-regulated activity for the full financial year before submitting the returns
    Given I am signed in to the return journey
    When I click on the change link to modify my AML-regulated activity for the full financial year
    Then I should be on the page that says Check your answers

  Scenario: User wants to change their AML-regulated activity length before submitting the returns
    Given I am signed in to the return journey
    When I click on the change link to modify my AML-regulated activity length
    Then I should be on the page that says Check your answers

  Scenario: Return submission for users who falls in the small band size (less than 10.2M)
    Given I am signed in to the return journey
    When I enter 12 month accounting period revenue is 10199999 that falls in the small band size
    Then I should be on the page that says You do not need to pay the Economic Crime Levy (ECL)

  Scenario: User wants to change their UK revenue (greater than or equal to 10.2M) from amount due page
    Given I am signed in to the return journey
    When I click on the change link to edit my uk revenue from amount due page and select Yes for my AML-regulated activity for the full financial year
    Then I should be on the page that says You need to pay £10,000

  Scenario: User wants to change the accounting period from amount due page for their UK revenue less than 10.2M
    Given I am signed in to the return journey
    When I click on the change link to edit my accounting period and select Yes for my AML-regulated activity for the full financial year
    Then I should be on the page that says You need to pay £10,000

  Scenario Outline: User is on the amount due page with content explaining how it was calculated
    Given I am signed in to the return journey
    When I enter the information required to calculate the amount due
    Then I should be on the page that says <Expected content>
    Examples:
      | Expected content                               |
      | Amount of Economic Crime Levy you need to pay  |
      | Your band size                                 |
      | How we worked this out                         |
      | How the size bands affect what you need to pay |
      | What you need to do next                       |

  Scenario: User that is registered for ECL starts for a nil return submission
    Given I am signed in to the return journey
    When I provide the details for a return submission
    Then I should be on the page that says Return submitted
    And I should see the amount to pay is Amount you need to pay: £0

  Scenario: User cancels amendments to the submitted economic crime levy return
    Given I am signed in to the account journey with my ECL reference as XMECL0000000007
    When I provide the details to amend the submitted economic crime levy return
    And I decide to cancel this amendments
    Then I should be on the page that says Your Economic Crime Levy account

Scenario: User amends the submitted returns via ECL account dashboard
  Given I am signed in to the account journey with my ECL reference as XMECL0000000007
  When I provide the details to amend the submitted economic crime levy return
  And the amended return information should display under Amended answers on the Check your answers page
    | Return completed by | James Bond 007     |
    | Role                | Compliance Officer |
    | Email address       | verify@oc.com      |
    | Telephone number    | 014753777777       |
  And I should be on the page that says Economic Crime Levy return amended

