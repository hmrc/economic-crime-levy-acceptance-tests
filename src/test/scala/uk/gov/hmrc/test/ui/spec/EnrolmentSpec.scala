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
import uk.gov.hmrc.test.ui.spec.BaseSpec
import uk.gov.hmrc.test.ui.specsteps.BaseStepsSteps.{thenIClickOnTheBackLink, thenIClickTheSaveAndContinueButton}
import uk.gov.hmrc.test.ui.specsteps.EnrolmentStepDefSteps.{givenIAmSignedInToTheEnrolmentJourney, whenIEnterTheECLRegistrationDateDayAsXMonthAsXAndYearAsX, whenIEnterTheEconomicCrimeLevyReferenceNumberX, whenIProvideTheDetailsOfMyECLReferenceNumber, whenISelectNoorUnknownOptionForWhetherOrNotIHaveTheECLReferenceNumber}
import uk.gov.hmrc.test.ui.specsteps.RegistrationStepDefSteps.thenIShouldBeOnThePageThatSaysX

class EnrolmentSpec extends BaseSpec with Matchers {

  Feature("Claim enrolment for ECL") {

    Scenario("User that is registered for ECL starts the claim enrolment journey") {
      Given("I am signed in to the enrolment journey")
      givenIAmSignedInToTheEnrolmentJourney()  // auto-chosen (score=1.00, EnrolmentStepDefSteps.scala)

      When("I provide the details of my ECL reference number")
      whenIProvideTheDetailsOfMyECLReferenceNumber()  // auto-chosen (score=1.00, EnrolmentStepDefSteps.scala)

      Then("I should be on the page that says Your details have been confirmed")
      thenIShouldBeOnThePageThatSaysX("Your details have been confirmed")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User selects the answer No for do they have an Economic Crime Levy reference number?") {
      Given("I am signed in to the enrolment journey")
      givenIAmSignedInToTheEnrolmentJourney()  // auto-chosen (score=1.00, EnrolmentStepDefSteps.scala)

      When("I select No option for whether or not I have the ECL reference number")
      whenISelectNoorUnknownOptionForWhetherOrNotIHaveTheECLReferenceNumber("No")

      Then("I should be on the page that says You need to register for the Economic Crime Levy")
      thenIShouldBeOnThePageThatSaysX("You need to register for the Economic Crime Levy")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I click on the Back link")
      thenIClickOnTheBackLink()  // auto-chosen (score=1.00, BaseStepsSteps.scala)

      Then("I should be on the page that says Do you have an Economic Crime Levy (ECL) reference number?")
      thenIShouldBeOnThePageThatSaysX("Do you have an Economic Crime Levy (ECL) reference number?")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I click the Save and continue button")
      thenIClickTheSaveAndContinueButton()  // auto-chosen (score=1.00, BaseStepsSteps.scala)

      Then("I should be on the page that says You need to register for the Economic Crime Levy")
      thenIShouldBeOnThePageThatSaysX("You need to register for the Economic Crime Levy")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User selects the answer I do not know for do they have an Economic Crime Levy reference number?") {
      Given("I am signed in to the enrolment journey")
      givenIAmSignedInToTheEnrolmentJourney()  // auto-chosen (score=1.00, EnrolmentStepDefSteps.scala)

      When("I select Unknown option for whether or not I have the ECL reference number")
      whenISelectNoorUnknownOptionForWhetherOrNotIHaveTheECLReferenceNumber("Unknown")

      Then("I should be on the page that says How to find your Economic Crime Levy reference number")
      thenIShouldBeOnThePageThatSaysX("How to find your Economic Crime Levy reference number")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User enters a valid date that does not match ECL records") {
      Given("I am signed in to the enrolment journey")
      givenIAmSignedInToTheEnrolmentJourney()  // auto-chosen (score=1.00, EnrolmentStepDefSteps.scala)

      When("I enter the ECL registration date day as 10 month as 10 and year as 2022")
      whenIEnterTheECLRegistrationDateDayAsXMonthAsXAndYearAsX("10", "10", "2022")  // auto-chosen (score=1.00, EnrolmentStepDefSteps.scala)

      Then("I should be on the page that says Your details do not match our records")
      thenIShouldBeOnThePageThatSaysX("Your details do not match our records")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User enters a valid ECL reference number that does not match ECL records") {
      Given("I am signed in to the enrolment journey")
      givenIAmSignedInToTheEnrolmentJourney()  // auto-chosen (score=1.00, EnrolmentStepDefSteps.scala)

      When("I enter the economic crime levy reference number XMECL0000000002")
      whenIEnterTheEconomicCrimeLevyReferenceNumberX("XMECL0000000002")  // auto-chosen (score=1.00, EnrolmentStepDefSteps.scala)

      Then("I should be on the page that says Your details do not match our records")
      thenIShouldBeOnThePageThatSaysX("Your details do not match our records")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }
  }
}
