/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.test.ui.spec

import org.scalatest.matchers.should.Matchers
import org.scalatest.featurespec.AnyFeatureSpec
import uk.gov.hmrc.test.ui.specsteps.AccountStepDefSteps.{givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX, whenIAmOnTheECLAccountDashboard}
import uk.gov.hmrc.test.ui.specsteps.DeRegistrationStepDefSteps.{thenIShouldSeeTheDeRegisteredECLReferenceNumberAsX, whenIClickOnTheViewOrAmendYourReturnsOrViewYourPaymentsLinkToViewTheDeregisteredXDetails, whenIProvideTheDetailsToDeRegisterTheECLAccountFromTheSystem, whenTheLinksXUnderTheActionColumnShouldBeVisibleOnTheThePage}
import uk.gov.hmrc.test.ui.specsteps.RegistrationStepDefSteps.thenIShouldBeOnThePageThatSaysX

class DeRegistrationSpec extends BaseSpec with Matchers {

  Feature("ECL account Dashboard after De-registration") {

    Scenario("User view their dashboard after successful de-registration") {
      Given("I am signed in to the account journey with my ECL reference as XMECL00000000019")
      givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL00000000019")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
      whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("I should see the de registered ECL reference number as ECL reference number: XMECL00000000019")
      thenIShouldSeeTheDeRegisteredECLReferenceNumberAsX("ECL reference number: XMECL00000000019")  // auto-chosen (score=1.00, DeRegistrationStepDefSteps.scala)

      And("I should be on the page that says You deregistered this account.")
      thenIShouldBeOnThePageThatSaysX("You deregistered this account.")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I should be on the page that says You have no returns due.")
      thenIShouldBeOnThePageThatSaysX("You have no returns due.")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I should be on the page that says You have an overdue payment for 1 April 2023 to 31 March 2024.")
      thenIShouldBeOnThePageThatSaysX("You have an overdue payment for 1 April 2023 to 31 March 2024.")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User views payments after successful de-registration [link=Returns]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL00000000019")
      givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL00000000019")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I click on the View or amend your returns or View your payments link to view the deregistered Returns details")
      whenIClickOnTheViewOrAmendYourReturnsOrViewYourPaymentsLinkToViewTheDeregisteredXDetails("Returns")  // auto-chosen (score=1.00, DeRegistrationStepDefSteps.scala)

      Then("the links Returns under the Action column should be visible on the the page")
      whenTheLinksXUnderTheActionColumnShouldBeVisibleOnTheThePage("Returns")  // auto-chosen (score=1.00, DeRegistrationStepDefSteps.scala)

    }

    Scenario("User views payments after successful de-registration [link=Payments]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL00000000019")
      givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL00000000019")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I click on the View or amend your returns or View your payments link to view the deregistered Payments details")
      whenIClickOnTheViewOrAmendYourReturnsOrViewYourPaymentsLinkToViewTheDeregisteredXDetails("Payments")  // auto-chosen (score=1.00, DeRegistrationStepDefSteps.scala)

      Then("the links Payments under the Action column should be visible on the the page")
      whenTheLinksXUnderTheActionColumnShouldBeVisibleOnTheThePage("Payments")  // auto-chosen (score=1.00, DeRegistrationStepDefSteps.scala)

    }

    Scenario("User able to request ECL de-registration") {
      Given("I am signed in to the account journey with my ECL reference as XMECL00000000002")
      givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL00000000002")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I provide the details to de register the ECL account from the system")
      whenIProvideTheDetailsToDeRegisterTheECLAccountFromTheSystem()  // auto-chosen (score=1.00, DeRegistrationStepDefSteps.scala)

      Then("I should be on the page that says Deregistration requested")
      thenIShouldBeOnThePageThatSaysX("Deregistration requested")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }
  }
}
