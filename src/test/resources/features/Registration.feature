@all @registration
Feature: Register for ECL

  Scenario Outline: User registers a <Entity type> supervised by HMRC for AML that is liable for ECL
    Given I am signed in to the registration journey
    When I provide details of my <Entity type> that is supervised by HMRC and liable for current ECL
    Then I should be on the page that says Registration submitted

    Examples:
      | Entity type |
      | Sole trader |

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
    Then I should be on the page that says Are you liable for any previous financial years?

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

  Scenario Outline: User registers a <Entity type> failed GRS identifiers and tries again
    Given I am signed in to the registration journey
    When I provide details of my <Entity type> and fail the GRS journey
    Then I should be on the page that says The details you have entered do not match our records
    And I click on the try again button
    Then I should be on the page that says What is your entity type?
    Examples:
      | Entity type     |
      | Limited company |

  Scenario: User is able to cancel the amend registrations they have submitted through ECL account dashboard
    Given I am signed in to the account journey with my ECL reference as XMECL0000000001
    When I provide the details to amend the submitted economic crime levy registration
    And I decide to cancel this amendments
    Then I should be on the page that says Your Economic Crime Levy account

  Scenario: User amends the submitted registration via ECL account dashboard
    Given I am signed in to the account journey with my ECL reference as XMECL0000000001
    When I provide the details to amend the submitted economic crime levy registration
    And the amended registration information should display under Amended answers on the Check your answers page
      | First contact name             | James Bond       |
      | First contact role             | Director         |
      | First contact email address    | confirm@test.com |
      | First contact telephone number | 01475344272      |
    And I should be on the page that says Economic Crime Levy registration amendment requested

  Scenario: User is amend the liability start date for registrations to previous FY through ECL account dashboard
    Given I am signed in to the account journey with my ECL reference as XMECL0000000001
    When I provide the details to amend the liability start date for registration
    Then I should be on the page that says Economic Crime Levy registration amendment requested

  Scenario: User is able to save progress in the registration journey and resume later
    Given I am signed in to the registration journey
    When I provide some details for the economic crime levy registration and experience a system timeout
    And I return to the service to complete the registration
    Then I should be on the page that says Your answers have been saved
    And I should be able to resume the registration from where I left off
    Then I should be on the page that says Registration submitted
