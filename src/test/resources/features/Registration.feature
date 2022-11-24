@all @reg @accessibility @zap
Feature: Register for ECL service

  Scenario Outline: User is able to select whether their UK revenue is less than or more than/equal to £10.2m and proceed to the next page
    Given I am on the registration start page
    When I click on the Start now button
    And I click on the Submit button on the authority wizard page
    And I select that my UK revenue is <UK revenue>
    And I click on the Save and continue button
    Then I should be on the page with the content <Expected content>

    Examples:
      | UK revenue         | Expected content                                        |
      | less-than          | You do not need to register for the Economic Crime Levy |
      | equal-or-more-than | Who is your Anti-Money Laundering (AML) supervisor?     |

  Scenario: User is presented with an error if they submit the UK revenue form without selecting an option
    Given I am on the registration start page
    When I click on the Start now button
    And I click on the Submit button on the authority wizard page
    And I click on the Save and continue button
    Then I should be on the page with the content Select your UK turnover for 2022

  Scenario Outline: User is able to select their AML supervisor and proceed to the next page
    Given I am on the registration start page
    When I click on the Start now button
    And I click on the Submit button on the authority wizard page
    And I select that my UK revenue is equal-or-more-than
    And I click on the Save and continue button
    When I select that my AML supervisor is <AML supervisor>
    And I click on the Save and continue button
    Then I should be on the page with the content <Expected content>

    Examples:
      | AML supervisor | Expected content          |
      | value_0        | What is your entity type? |





