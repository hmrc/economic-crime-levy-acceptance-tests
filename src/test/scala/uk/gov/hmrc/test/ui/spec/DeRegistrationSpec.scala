package uk.gov.hmrc.test.ui.spec

import org.scalatest.matchers.should.Matchers
import org.scalatest.featurespec.AnyFeatureSpec

class DeRegistrationSpec extends BaseSpec with Matchers {

  Feature("ECL account Dashboard after De-registration") {

    Scenario("User view their dashboard after successful de-registration") {
      Given("I am signed in to the account journey with my ECL reference as XMECL00000000019")
      When("I am on the ECL account dashboard")
      Then("I should see the de registered ECL reference number as ECL reference number: XMECL00000000019")
      And("I should be on the page that says You deregistered this account.")
      And("I should be on the page that says You have no returns due.")
      And("I should be on the page that says You have an overdue payment for 1 April 2023 to 31 March 2024.")
    }

    Scenario("User views payments after successful de-registration [link=Returns]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL00000000019")
      When("I click on the View or amend your returns or View your payments link to view the deregistered Returns details")
      Then("the links Returns under the Action column should be visible on the the page")
    }

    Scenario("User views payments after successful de-registration [link=Payments]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL00000000019")
      When("I click on the View or amend your returns or View your payments link to view the deregistered Payments details")
      Then("the links Payments under the Action column should be visible on the the page")
    }

    Scenario("User able to request ECL de-registration") {
      Given("I am signed in to the account journey with my ECL reference as XMECL00000000002")
      When("I provide the details to de register the ECL account from the system")
      Then("I should be on the page that says Deregistration requested")
    }
  }
}
