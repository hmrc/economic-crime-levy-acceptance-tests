@all @reg @accessibility @zap
Feature: Register for ECL

  Scenario Outline: User registers a <Entity type> supervised by HMRC for AML that is liable for ECL
    Given I am signed in to the registration journey
    When I provide details of my limited company that is supervised by HMRC and liable for ECL
    Then I should be on the placeholder page that says Success - you can continue registering for ECL

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
    Then I should be on the placeholder page that says Success - you can continue registering for ECL

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