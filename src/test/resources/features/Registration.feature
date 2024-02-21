@all @registration
Feature: Register for ECL

  Scenario Outline: User registers a <Entity type> supervised by HMRC for AML that is liable for ECL
    Given I am signed in to the registration journey
    When I provide details of my <Entity type> that is supervised by HMRC and liable for current ECL
    Then I should be on the page that says Registration submitted

    Examples:
      | Entity type                   |
      | Sole trader                   |
@validations
  Scenario: User does not select whether or not they started AML regulated activity in current FY
    Given I am signed in to the registration journey
    When I do not select an option for whether or not I started AML regulated activity in current FY
    Then I should see an error that says Select yes if you carried out anti-money laundering (AML) regulated activity

  Scenario: Users who answer "No" whether or not they started AML regulated activity in current FY
    Given I am signed in to the registration journey
    When I select No on whether or not I carried out AML-regulated activity in current FY
    Then I should be on the page that says Were you liable to pay the ECL from 1 April 2022 to 31 March 2023?
@validations
  Scenario: User does not select their AML supervisor
    Given I am signed in to the registration journey
    When I do not select an option for my AML supervisor
    Then I should see an error that says Select an AML supervisor

  Scenario: User selects AML supervisor as other but does not select the professional body
    Given I am signed in to the registration journey
    When I do not select an other professional body when I have selected the Other option
    Then I should see an error that says Select a professional body from the list

  Scenario Outline: User's AML supervisor is GC or FCA
    Given I am signed in to the registration journey
    When I say that my AML supervisor is <AML supervisor>
    Then I should be on the page that says <Expected content>

    Examples:
      | AML supervisor              | Expected content                                                                |
      | Gambling Commission         | You need to register with the Gambling Commission (GC) to pay the levy          |
      | Financial Conduct Authority | You need to register with the Financial Conduct Authority (FCA) to pay the levy |
@validations
  Scenario: User does not select whether or not their relevant accounting period 12 months
    Given I am signed in to the registration journey
    When I do not select an option for whether or not my relevant accounting period 12 months
    Then I should see an error that says Select yes if you have a relevant accounting period that ends in the financial year

  Scenario: User selects no on whether or not their relevant accounting period 12 months
    Given I am signed in to the registration journey
    When I select No on whether or not my relevant accounting period 12 months
    Then I should be on the page that says How long is your relevant accounting period?
@validations
  Scenario: User does not select how long is their relevant accounting period in days?
    Given I am signed in to the registration journey
    When I do not enter the my relevant accounting period in days
    Then I should see an error that says Enter the length
@validations
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
@validations
  Scenario Outline: User enters an invalid amount for UK revenue for their relevant accounting period
    Given I am signed in to the registration journey
    When I enter the UK revenue <UK Revenue> for the relevant accounting period
    Then I should see an error that says <Expected content>
    Examples:
      | UK Revenue | Expected content                                              |
      |            | Enter the total UK revenue                                    |
      | -1         | UK revenue must be between 0 and 99,999,999,999.99            |
      | asdfg      | The total UK revenue can only include pounds and pence        |
      | 99.999     | The total UK revenue can only include pounds and pence        |
@validations
  Scenario Outline: User enters an valid amount for UK revenue but less than 10.2M for their relevant accounting period
    Given I am signed in to the registration journey
    When I enter the UK revenue <UK Revenue> for the relevant accounting period
    Then I should be on the page that says Were you liable to pay the ECL from 1 April 2022 to 31 March 2023?
    Examples:
      | UK Revenue |
      | 0          |
      | 10199999   |
@validations
  Scenario: User does not select their entity type
    Given I am signed in to the registration journey
    When I do not select an option for my entity type
    Then I should see an error that says Please select your entity type
@validations
  Scenario: User does not select their business sector
    Given I am signed in to the registration journey
    When I do not select an option for my business sector
    Then I should see an error that says Select a business sector
@validations
  Scenario Outline: User does not provide their first contact person's valid name for the business sector page
    Given I am signed in to the registration journey
    When I enter the first contact person's name <Name> for my business
    Then I should see an error that says <Expected content>

    Examples:
      | Name                                                                                                                                                              | Expected content                         |
      |                                                                                                                                                                   | Enter a full name                        |
      | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstu1234567890!@£#$%^&*()-+={}[]"';:,.<>/? | Full name must be 160 characters or less |
@validations
  Scenario Outline: User does not provide their first contact person's valid role for the business sector page
    Given I am signed in to the registration journey
    When I enter the first contact person's role <Role> for my business
    Then I should see an error that says <Expected content>

    Examples:
      | Role                                                                                                                                                              | Expected content                    |
      |                                                                                                                                                                   | Enter a role                        |
      | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstu1234567890!@£#$%^&*()-+={}[]"';:,.<>/? | Role must be 160 characters or less |
@validations
  Scenario Outline: User does not provide their first contact person's valid email address for the business sector page
    Given I am signed in to the registration journey
    When I enter the first contact person's email address <Email address> for my business
    Then I should see an error that says <Expected content>

    Examples:
      | Email address | Expected content                                                    |
      |               | Enter an email address                                              |
      | email-address | Enter an email address in the correct format, like name@example.com |

@validations
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
    Then I should be on the page that says Check your answers

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
@validations
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
@validations
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

  Scenario Outline: User registers <Other Entity> as entity type for AML that is liable for ECL
    Given I am signed in to the registration journey
    When I provide details of my other entity is <Other Entity> that is supervised by HMRC and liable for ECL
    Then I should be on the page that says Registration received
    Examples:
      | Other Entity               |
      | Charity                    |
      | Unincorporated Association |
      | Trust                      |
      | Non-UK Establishment       |
@validations
  Scenario Outline: User does not provide their valid registered name for the other entity type <Other Entity> business
    Given I am signed in to the registration journey
    When I enter my registered name as <Name> for the other entity type business
    Then I should see an error that says <Expected content>

    Examples:
      | Other Entity               | Name                                                                                                                                                              | Expected content                                   |
      | Charity                    |                                                                                                                                                                   | Enter a business name                              |
      | Charity                    | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstu1234567890!@£#$%^&*()-+={}[]"';:,.<>/? | Business name must not be more than 160 characters |
      | Unincorporated Association |                                                                                                                                                                   | Enter a business name                              |
      | Unincorporated Association | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstu1234567890!@£#$%^&*()-+={}[]"';:,.<>/? | Business name must not be more than 160 characters |
      | Trust                      |                                                                                                                                                                   | Enter a business name                              |
      | Trust                      | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstuvwxyabcdefghijklmnopqrstu1234567890!@£#$%^&*()-+={}[]"';:,.<>/? | Business name must not be more than 160 characters |
@validations
  Scenario Outline: User does not provide their valid charity registration number for the other entity type business
    Given I am signed in to the registration journey
    When I enter my charity registration number as <CHRNumber> for the other entity type business
    Then I should see an error that says <Expected content>

    Examples:
      | CHRNumber | Expected content                                               |
      |           | Enter a charity registration number                            |
      | UKA99999  | Charity registration number must not be more than 7 characters |
@validations
  Scenario Outline: User does not provide their valid company registration number for the other entity type business
    Given I am signed in to the registration journey
    When I enter my company registration number as <CRNumber> for the other entity type business
    Then I should see an error that says <Expected content>

    Examples:
      | CRNumber  | Expected content                                                     |
      |           | Enter a company registration number                                  |
      | SCU123456 | Company registration number (CRN) must not be more than 8 characters |
@validations
  Scenario: User does not select whether or not they have a Corporation Tax Unique Taxpayer Reference?
    Given I am signed in to the registration journey
    When I do not select an option for whether or not I have a Corporation Tax Unique Taxpayer Reference
    Then I should see an error that says Select yes if you have a Corporation Tax Unique Taxpayer Reference

  Scenario: User selects no on whether or not they have a Corporation Tax Unique Taxpayer Reference?
    Given I am signed in to the registration journey
    When I select No on whether or not I have a Corporation Tax Unique Taxpayer Reference
    Then I should be on the page that says What is your business sector?
@validations
  Scenario Outline: User does not provide their valid Corporation Tax Unique Taxpayer Reference for the other entity type <Other Entity> business
    Given I am signed in to the registration journey
    When I enter my Corporation Tax Unique Taxpayer Reference as <CT UTR> for the other entity type <Other Entity> business
    Then I should see an error that says <Expected content>

    Examples:
      | Other Entity               | CT UTR     | Expected content                                                        |
      | Unincorporated Association |            | Enter a Corporation Tax (CT) Unique Taxpayer Reference (UTR)            |
      | Unincorporated Association | 012345678  | Corporation Tax (CT) Unique Taxpayer Reference (UTR) must be 10 numbers |
      | Unincorporated Association | SC01234567 | Corporation Tax (CT) Unique Taxpayer Reference (UTR) must be 10 numbers |
      | Trust                      |            | Enter a Corporation Tax (CT) Unique Taxpayer Reference (UTR)            |
      | Trust                      | 012345678  | Corporation Tax (CT) Unique Taxpayer Reference (UTR) must be 10 numbers |
      | Non-UK Establishment       |            | Enter a Self Assessment (SA) Unique Taxpayer Reference (UTR)            |
      | Non-UK Establishment       | SC01234567 | Self Assessment (SA) Unique Taxpayer Reference (UTR) must be 10 numbers |
@validations
  Scenario Outline: User does not provide their company's valid registered postcode
    Given I am signed in to the registration journey
    When I enter my company registered postcode as <Postcode> for the other entity type business
    Then I should see an error that says <Expected content>

    Examples:
      | Postcode  | Expected content      |
      |           | Enter a postcode      |
      | AB11 322YZ | Enter a real postcode |
@validations
  Scenario: User does not select their UK unique taxpayer reference
    Given I am signed in to the registration journey
    When I do not select an option for my UK unique taxpayer reference
    Then I should see an error that says Select yes if you have a UTR

  Scenario: Users who answer "NO" to AML question for the current FY but "YES" to previous FY
    Given I am signed in to the registration journey
    When I provide details of my limited company and indicate liability for previous year ECL
    Then I should be on the page that says Registration submitted

  Scenario: Users who answer "No" whether or not they started AML regulated activity in current FY and "No" to previous FY
    Given I am signed in to the registration journey
    When I select No on whether or not I carried out AML-regulated activity in current FY and in previous FY
    Then I should be on the page that says You do not need to register for the Economic Crime Levy

  Scenario: User registers a limited company supervised by HMRC for AML who have turnover of £10.2m and above that is liable for previous FY
    Given I am signed in to the registration journey
    When I provide Yes to AML question and the turnover is £10.2m and above and Yes liable for previous FY
    Then I should be on the page that says Registration submitted

  Scenario: User registers a limited company supervised by HMRC for AML who have turnover of £10.2m and above that is not liable for previous FY
    Given I am signed in to the registration journey
    When I provide Yes to AML question and the turnover is £10.2m and above and No liable for previous FY
    Then I should be on the page that says Registration submitted

  Scenario: User registers a limited company supervised by HMRC for AML who have turnover of below £10.2m and that is liable for previous FY
    Given I am signed in to the registration journey
    When I provide Yes to AML question and the turnover is below £10.2m threshold and Yes liable for previous FY
    Then I should be on the page that says Registration submitted

  Scenario: User registers a limited company supervised by HMRC for AML who have turnover of below £10.2m and that is not liable for previous FY
    Given I am signed in to the registration journey
    When I provide Yes to AML question and the turnover is below £10.2m threshold but No liability for previous year ECL
    Then I should be on the page that says You do not need to register for the Economic Crime Levy
@validations
  Scenario: User does not select whether or not they were liable to pay the ECL from 1 April 2022 to 31 March 2023
    Given I am signed in to the registration journey
    When I do not select an option for whether or not I liable to pay the ECL from 1 April 2022 to 31 March 2023
    Then I should see an error that says Select yes if you were liable to pay the Economic Crime Levy

  Scenario Outline: User registers a <Entity type> failed GRS identifiers and tries again
    Given I am signed in to the registration journey
    When I provide details of my <Entity type> and fail the GRS journey
    Then I should be on the page that says The details you have entered do not match our records
    And I click on the try again button
    Then I should be on the page that says What is your entity type?

    Examples:
      | Entity type                   |
      | Limited company               |
@validations
  Scenario: Error message display when the user does not select their option in UK Company Registration Number page
    Given I am signed in to the registration journey
    When I do not select an option for my UK company registration number
    Then I should see an error that says Select yes if you have a UK company registration number

  Scenario: User is able to cancel the amend registrations they have submitted through ECL account dashboard
    Given I am signed in to the account journey with my ECL reference as XMECL0000000001
    When I provide the details to amend the submitted economic crime levy registration
    And I decide to cancel this amendments
    Then I should be on the page that says Your Economic Crime Levy account

  Scenario: User amends the submitted registration via ECL account dashboard
    Given I am signed in to the account journey with my ECL reference as XMECL0000000001
    When I provide the details to amend the submitted economic crime levy registration
    And the amended registration information should display under Amended answers on the Check your answers page
      | First contact name | James Bond       |
      | First contact role                | Director         |
      | First contact email address       | confirm@test.com |
      | First contact telephone number    | 01475344272      |
    And I should be on the page that says Economic Crime Levy registration amendment requested