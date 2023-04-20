@all @registration
Feature: Register for ECL

  Scenario Outline: User registers a <Entity type> supervised by HMRC for AML that is liable for ECL
    Given I am signed in to the registration journey
    When I provide details of my limited company that is supervised by HMRC and liable for ECL
    Then I should be on the page that says Registration submitted

    Examples:
      | Entity type                   |
      | Limited company               |
      | Limited liability partnership |
      | Limited partnership           |
      | Scottish limited partnership  |
      | General partnership           |
      | Scottish partnership          |
      | Sole trader                   |

  Scenario: User does not select whether or not they started AML regulated activity in current FY
    Given I am signed in to the registration journey
    When I do not select an option for whether or not I started AML regulated activity in current FY
    Then I should see an error that says Select an answer

  Scenario: User does not select whether or not they started AML regulated activity in current FY
    Given I am signed in to the registration journey
    When I select No on whether or not I carried out AML-regulated activity in current FY
    Then I should be on the page that says You do not need to register for the Economic Crime Levy

  Scenario: User does not select their AML supervisor
    Given I am signed in to the registration journey
    When I do not select an option for my AML supervisor
    Then I should see an error that says Select an AML supervisor

  Scenario: User selects AML supervisor as other but does not select the professional body
    Given I am signed in to the registration journey
    When I do not select an other professional body when I have selected the Other option
    Then I should see an error that says Enter the name of your professional body or select from the list

  Scenario Outline: User's AML supervisor is GC or FCA
    Given I am signed in to the registration journey
    When I say that my AML supervisor is <AML supervisor>
    Then I should be on the page that says <Expected content>

    Examples:
      | AML supervisor              | Expected content                                                                |
      | Gambling Commission         | You need to register with the Gambling Commission (GC) to pay the levy          |
      | Financial Conduct Authority | You need to register with the Financial Conduct Authority (FCA) to pay the levy |

  Scenario: User does not select whether or not their relevant accounting period 12 months
    Given I am signed in to the registration journey
    When I do not select an option for whether or not my relevant accounting period 12 months
    Then I should see an error that says Select an answer

  Scenario: User selects no on whether or not their relevant accounting period 12 months
    Given I am signed in to the registration journey
    When I select No on whether or not my relevant accounting period 12 months
    Then I should see an error that says How long is your relevant accounting period?

  Scenario: User does not select how long is their relevant accounting period?
    Given I am signed in to the registration journey
    When I do not enter the length of my accounting period in days
    Then I should see an error that says Enter the length

  Scenario Outline: User enters an invalid length for their relevant accounting period
    Given I am signed in to the registration journey
    When I enter the length of my accounting period in days <Days>
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
    Given I am signed in to the registration journey
    When I enter the UK revenue <UK Revenue> for the relevant accounting period
    Then I should see an error that says <Expected content>
    Examples:
      | UK Revenue | Expected content                                              |
      |            | Enter the UK revenue                                          |
      | -1         | UK revenue must be between 0 and 99,999,999,999               |
      | asdfg      | UK revenue must be a number rounded down to the nearest pound |
      | 99.999     | UK revenue must be a number rounded down to the nearest pound |
      | 1019999.99 | UK revenue must be a number rounded down to the nearest pound |

  Scenario Outline: User enters an valid amount for UK revenue but less than 10.2M for their relevant accounting period
    Given I am signed in to the registration journey
    When I enter the UK revenue <UK Revenue> for the relevant accounting period
    Then I should be on the page that says You do not need to register for the Economic Crime Levy
    Examples:
      | UK Revenue |
      | 0          |
      | 10199999   |

  Scenario: User does not select their entity type
    Given I am signed in to the registration journey
    When I do not select an option for my entity type
    Then I should see an error that says Please select your entity type

# commenting the below scenario for private beta test
#
#  Scenario: User's entity type is Other
#    Given I am signed in to the registration journey
#    When I say that my entity type is Other
#    Then I should be on the page that says Sorry, we’re experiencing technical difficulties

  Scenario: User does not select their business sector
    Given I am signed in to the registration journey
    When I do not select an option for my business sector
    Then I should see an error that says Select a business sector

  Scenario Outline: User does not provide their first contact person's valid name for the business sector page
    Given I am signed in to the registration journey
    When I enter the first contact person's name <Name> for my business
    Then I should see an error that says <Expected content>

    Examples:
      | Name                                                                                                                                                              | Expected content                         |
      |                                                                                                                                                                   | Enter a full name                        |
      | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstu1234567890!@£#$%^&*()-+={}[]"';:,.<>/? | Full name must be 160 characters or less |

  Scenario Outline: User does not provide their first contact person's valid role for the business sector page
    Given I am signed in to the registration journey
    When I enter the first contact person's role <Role> for my business
    Then I should see an error that says <Expected content>

    Examples:
      | Role                                                                                                                                                              | Expected content                    |
      |                                                                                                                                                                   | Enter a role                        |
      | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstu1234567890!@£#$%^&*()-+={}[]"';:,.<>/? | Role must be 160 characters or less |

  Scenario Outline: User does not provide their first contact person's valid email address for the business sector page
    Given I am signed in to the registration journey
    When I enter the first contact person's email address <Email address> for my business
    Then I should see an error that says <Expected content>

    Examples:
      | Email address | Expected content                                                    |
      |               | Enter an email address                                              |
      | email-address | Enter an email address in the correct format, like name@example.com |


  Scenario Outline: User does not provide their first contact person's valid contact number for the business sector page
    Given I am signed in to the registration journey
    When I enter the first contact person's contact number <Contact number> for my business
    Then I should see an error that says <Expected content>

    Examples:
      | Contact number            | Expected content                                                                |
      |                           | Enter a telephone number                                                        |
      | 1234567890123456789012345 | Telephone number must be 24 characters or less                                  |
      | contact number            | Enter a telephone number, like 01632 960 001, 07700 900 982 or +44 808 157 0192 |
      | 1234567890 1234567890-1_  | Enter a telephone number, like 01632 960 001, 07700 900 982 or +44 808 157 0192 |

  Scenario: User wants to use another UK address as his registered address for the main contact
    Given I am signed in to the registration journey
    When I provide the details of another UK address as my main contact address
    Then I should be on the page that says Check your answers

  Scenario: User wants to use another non UK address as his registered address for the main contact
    Given I am signed in to the registration journey
    When I provide the details of a non UK address as my main contact address
    Then I should be on the page that says Check your answers

  Scenario: User wants to go to check your answers page directly without providing any of the previous pages details
    Given I am signed in to the registration journey
    When I go to check your answers page directly without providing answers for any of the previous page questions
    Then I should be on the page that says The answers you provided are not valid

  Scenario: User wants to change the contact details before submitting the registration
    Given I am signed in to the registration journey
    When I click on the change link and edit my contact details
    Then I should be on the page that says Check your answers

  Scenario: User wants to remove the secondary contact details before submitting the registration
    Given I am signed in to the registration journey
    When I click on the change link to modify my secondary contact
    And I select No on whether or not to add a secondary contact details
    Then I should be on the page that says Check your answers

  Scenario: User wants to change the contact address before submitting the registration
    Given I am signed in to the registration journey
    When I click on the change link to modify the registered address
    And I select No on whether or not to use a different UK address as my main contact address
    Then I should be on the page that says Check your answers

  Scenario: User wants to change the the organisation details (Business sector, AML supervisor, UK revenue and Accounting Period) before submitting the registration
    Given I am signed in to the registration journey
    When I click on the change link and edit my organisation details
    Then I should be on the page that says Check your answers

  Scenario: User wants to change the AML regulated activity of the organisation before submitting the registration
    Given I am signed in to the registration journey
    When I click on the change link and select No on whether or not I carried out AML-regulated activity in current FY
    Then I should be on the page that says You do not need to register for the Economic Crime Levy

  Scenario: User wants to change the entity type of the organisation before submitting the registration
    Given I am signed in to the registration journey
    When I click on the change link and select the new entity type
    Then I should be on the page that says Check your answers

  Scenario Outline: User selects their entity type as General or Scottish Partnership
    Given I am signed in to the registration journey
    When I select my entity type as <Entity type> and provide the registration details
    Then I should be on the page that says Check your answers
    Examples:
      | Entity type          |
      | General partnership  |
      | Scottish partnership |

  Scenario Outline: User does not provide a valid entity name for their General or Scottish Partnership
    Given I am signed in to the registration journey
    When I enter my <Entity type>'s name as <Partnership Name>
    Then I should see an error that says <Expected content>

    Examples:
      | Entity type          | Partnership Name                                                                                                                                                  | Expected content                                |
      | General partnership  |                                                                                                                                                                   | Enter a partnership name                        |
      | Scottish partnership |                                                                                                                                                                   | Enter a partnership name                        |
      | General partnership  | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstu1234567890!@£#$%^&*()-+={}[]"';:,.<>/? | Partnership name must be 160 characters or less |
      | Scottish partnership | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstu1234567890!@£#$%^&*()-+={}[]"';:,.<>/? | Partnership name must be 160 characters or less |

  Scenario Outline: User provides a valid entity name for their General or Scottish Partnership
    Given I am signed in to the registration journey
    When I enter my <Entity type>'s name as <Partnership Name>
    Then I should be on the page that says What is your business sector?

    Examples:
      | Entity type          | Partnership Name                                                                                                                                                 |
      | General partnership  | A                                                                                                                                                                |
      | Scottish partnership | 1                                                                                                                                                                |
      | General partnership  | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrst1234567890!@£#$%^&*()-+={}[]"';:,.<>/? |
      | Scottish partnership | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrst1234567890!@£#$%^&*()-+={}[]"';:,.<>/? |

  Scenario Outline: User enters an invalid access code to register for the ECL
    Given I am signed in to the registration journey
    When I enter the invalid access code <Access Code> to register for the ECl
    Then I should see an error that says <Expected content>
    Examples:
      | Access Code | Expected content          |
      |             | Enter an access code      |
      | abcdef      | Enter a valid access code |
      | 123654      | Enter a valid access code |