@all @reg @accessibility @zap
Feature: Register for ECL

  Scenario Outline: User registers a <Entity type> supervised by HMRC for AML that is liable for ECL
    Given I am signed in to the registration journey
    When I provide details of my limited company that is supervised by HMRC and liable for ECL
    Then I should be on the page that says Check your answers

    Examples:
      | Entity type                   |
      | Limited company               |
      | Limited liability partnership |
      | Limited partnership           |
      | Scottish limited partnership  |
      | General partnership           |
      | Scottish partnership          |
      | Sole trader                   |

  Scenario: User registers a limited company supervised by an other professional body for AML that is liable for ECL
    Given I am signed in to the registration journey
    When I provide details of my limited company that is supervised by an other professional body and liable for ECL
    Then I should be on the page that says Did you start AML-regulated activity in FY 2022?

  Scenario: User's UK revenue is less than £10.2 million
    Given I am signed in to the registration journey
    When I say that my UK revenue is less than £10.2 million
    Then I should be on the page that says You do not need to register for the Economic Crime Levy

  Scenario: User does not select their UK revenue
    Given I am signed in to the registration journey
    When I do not select an option for my UK revenue
    Then I should see an error that says Select your UK revenue for 2022

  Scenario Outline: User's AML supervisor is GC or FCA
    Given I am signed in to the registration journey
    When I say that my AML supervisor is <AML supervisor>
    Then I should be on the page that says <Expected content>

    Examples:
      | AML supervisor              | Expected content                                                                |
      | Gambling Commission         | You need to register with the Gambling Commission (GC) to pay the levy          |
      | Financial Conduct Authority | You need to register with the Financial Conduct Authority (FCA) to pay the levy |

  Scenario: User does not select their AML supervisor
    Given I am signed in to the registration journey
    When I do not select an option for my AML supervisor
    Then I should see an error that says Select an AML supervisor

  Scenario: User selects AML supervisor as other but does not select the professional body
    Given I am signed in to the registration journey
    When I do not select an other professional body when I have selected the Other option
    Then I should see an error that says Enter the name of your professional body or select from the list

  Scenario: User's entity type is Other
    Given I am signed in to the registration journey
    When I say that my entity type is Other
    Then I should be on the page that says Sorry, we’re experiencing technical difficulties

  Scenario: User does not select their entity type
    Given I am signed in to the registration journey
    When I do not select an option for my entity type
    Then I should see an error that says Please select your entity type

  Scenario: User does not select whether or not they started AML regulated activity in current FY
    Given I am signed in to the registration journey
    When I do not select an option for whether or not I started AML regulated activity in current FY
    Then I should see an error that says Select an answer

  Scenario: User selects Yes and enters a valid date for when they started AML regulated activity
    Given I am signed in to the registration journey
    When I select Yes for whether or not I started AML regulated activity in current FY
    And I enter the start date for my AML regulated activity as day 10 month 10 and year 2022
    Then I should be on the page that says What is your business sector?

  Scenario Outline: User select Yes and enter an invalid date for their start AML regulated activity questions
    Given I am signed in to the registration journey
    When I select Yes for whether or not I started AML regulated activity in current FY
    And I enter the start date for my AML regulated activity as day <Day> month <Month> and year <Year>
    Then I should see an error that says <Expected content>

    Examples:
      | Day | Month | Year | Expected content                                        |
      |     |       |      | Enter a date                                            |
      |     | 01    | 2022 | Enter a day                                             |
      | 01  |       | 2022 | Enter a month                                           |
      | 01  | 04    |      | Enter a year                                            |
      | dd  | 02    | 2023 | The day entered must be a real day                      |
      | 10  | mm    | 2023 | The month entered must be a real month                  |
      | 10  | 02    | yyyy | The year entered must be a real year                    |
      | 0   | 0     | 0    | The date entered must be a real date                    |
      | 30  | 02    | 2023 | The date entered must be a real date                    |
      | 01  | 13    | 2021 | The month entered must be a real month                  |
      | 01  | 04    | 2023 | The date must be between 1 April 2022 and 31 March 2023 |
      | 31  | 03    | 2022 | The date must be between 1 April 2022 and 31 March 2023 |

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
      | Role                                                           | Expected content                   |
      |                                                                | Enter a role                       |
      | ABCDEFGHIJKlmnouvwxyz1234567890!@£$%^&#* ()-_+=[]{}":;'\?><,./ | Role must be 60 characters or less |

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
      | 1234567890 1234567890-12  | Enter a telephone number, like 01632 960 001, 07700 900 982 or +44 808 157 0192 |

  Scenario: User does not want to use his registered address as the main contact address but wants to use another UK address
    Given I am signed in to the registration journey
    When I select No to use my registered address as the main contact address
    And I select Yes for whether or not my contact address is based in the UK
    Then I should be on the page that says Stub Address Lookup Journey Data

  Scenario: User does not want to use his registered address as the main contact address but wants to use another non UK address
    Given I am signed in to the registration journey
    When I select No to use my registered address as the main contact address
    And I select No for whether or not my contact address is based in the UK
    Then I should be on the page that says Stub Address Lookup Journey Data
