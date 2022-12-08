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
      | UK revenue                          | Expected content                                        |
      | Less than £10.2 million             | You do not need to register for the Economic Crime Levy |
      | Equal to or more than £10.2 million | Who is your Anti-Money Laundering (AML) supervisor?     |

  Scenario: User is presented with an error if they submit the UK revenue form without selecting an option
    Given I am on the registration start page
    When I click on the Start now button
    And I click on the Submit button on the authority wizard page
    And I click on the Save and continue button
    Then I should be on the page with the content Select your UK revenue for 2022

  Scenario: User is presented with an error if they submit the AML supervisor form without selecting an option
    Given I am on the registration start page
    When I click on the Start now button
    And I click on the Submit button on the authority wizard page
    And I select that my UK revenue is Equal to or more than £10.2 million
    And I click on the Save and continue button
    And I click on the Save and continue button on the AML supervisor page
    Then I should be on the page with the content Select an AML supervisor

  Scenario Outline: User is able to select their AML supervisor as <AML supervisor> and proceed to the next page
    Given I am on the registration start page
    When I click on the Start now button
    And I click on the Submit button on the authority wizard page
    And I select that my UK revenue is Equal to or more than £10.2 million
    And I click on the Save and continue button
    When I select that my AML supervisor is <AML supervisor>
    And I click on the Save and continue button
    Then I should be on the page with the content <Expected content>

    Examples:
      | AML supervisor              | Expected content                                                                |
      | HMRC                        | What is your entity type?                                                       |
      | Gambling Commission         | You need to register with the Gambling Commission (GC) to pay the levy          |
      | Financial Conduct Authority | You need to register with the Financial Conduct Authority (FCA) to pay the levy |

  Scenario Outline: User is able to select their AML supervisor as Other and proceed to the next page
    Given I am authorised and on the AML supervisor page
    When I select that my AML supervisor is Other
    And I click and select the other professional body name is <Professional body name>
    And I click on the Save and continue button
    Then I should be on the page with the content <Expected content>

    Examples:
      | Professional body name            | Expected content          |
      | otherProfessionalBody__option--0  | What is your entity type? |
      | otherProfessionalBody__option--10 | What is your entity type? |
      | otherProfessionalBody__option--20 | What is your entity type? |

  Scenario Outline: User is able to select their entity type as <Entity type> and proceed to the next page
    Given I am authorised and on the AML supervisor page
    When I select that my AML supervisor is HMRC
    And I click on the Save and continue button
    And I select that my entity type is <Entity type>
    And I click on the Save and continue button
    Then I should be on the page with the content <Expected content>

    Examples:
      | Entity type                   | Expected content                                 |
      | Limited company               | Stub GRS Journey Data                            |
      | Limited liability partnership | Stub GRS Journey Data                            |
      | Limited partnership           | Stub GRS Journey Data                            |
      | Scottish limited partnership  | Stub GRS Journey Data                            |
      | General partnership           | Stub GRS Journey Data                            |
      | Scottish partnership          | Stub GRS Journey Data                            |
      | Sole trader                   | Stub GRS Journey Data                            |
      | Other                         | Sorry, we’re experiencing technical difficulties |
