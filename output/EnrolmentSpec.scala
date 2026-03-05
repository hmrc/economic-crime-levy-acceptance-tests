package uk.gov.hmrc.test.ui.spec

import org.scalatest.matchers.should.Matchers
import org.scalatest.featurespec.AnyFeatureSpec
import uk.gov.hmrc.test.ui.spec.BaseSpec

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
        // ⚠️ No step-def match found for: I select No option for whether or not I have the ECL reference number

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
        // ⚠️ No step-def match found for: I select Unknown option for whether or not I have the ECL reference number

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
