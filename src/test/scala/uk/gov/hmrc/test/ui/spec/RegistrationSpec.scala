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
import uk.gov.hmrc.test.ui.specsteps.AccountStepDefSteps.givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX
import uk.gov.hmrc.test.ui.specsteps.BaseStepsSteps.{thenIClickOnTheBackLink, thenIClickTheSaveAndContinueButton}
import uk.gov.hmrc.test.ui.specsteps.RegistrationStepDefSteps.{andIClickOnTheTryAgainButton, andIDecideToCancelThisAmendments, andIGoToCheckYourAnswersPageDirectlyWithoutProvidingAnswersForAnyOfThePreviousPageQuestions, andIProvideTheDetailsOfANonUKAddressAsMyMainContactAddress, andIProvideTheDetailsOfAnotherUKAddressAsMyMainContactAddress, andIReturnToTheServiceToCompleteTheRegistration, andIShouldBeAbleToResumeTheRegistrationFromWhereILeftOff, andTheAmendedRegistrationInformationShouldDisplayUnderAmendedAnswersOnTheCheckYourAnswersPage, givenIAmSignedInToTheRegistrationJourney, thenIShouldBeOnThePageThatSaysX, whenIClickOnTheChangeLinkAndEditMyContactDetails, whenIClickOnTheChangeLinkAndEditMyOrganisationDetails, whenIClickOnTheChangeLinkAndSelectTheNewEntityType, whenIClickOnTheChangeLinkAndSelectXOnWhetherOrNotICarriedOutAMLregulatedActivityInCurrentFY, whenIClickOnTheChangeLinkToModifyMySecondaryContact, whenIClickOnTheChangeLinkToModifyTheRegisteredAddress, whenIProvideDetailsOfMyLimitedCompanyAndIndicateLiabilityForPreviousYearECL, whenIProvideDetailsOfMyOtherEntityIsXThatIsSupervisedByHMRCAndLiableForECL, whenIProvideDetailsOfMyXAndFailTheGRSJourney, whenIProvideDetailsOfMyXThatIsSupervisedByHMRCAndLiableForCurrentECL, whenIProvideSomeDetailsForTheEconomicCrimeLevyRegistrationAndExperienceASystemTimeout, whenIProvideTheDetailsToAmendTheLiabilityStartDateForRegistration, whenIProvideTheDetailsToAmendTheSubmittedEconomicCrimeLevyRegistration, whenIProvideYesToAMLQuestionAndTheTurnoverIsBelowThresholdAndXLiableForPreviousFY, whenIProvideYesToAMLQuestionAndTheTurnoverIsBelowThresholdButXLiabilityForPreviousYearECL, whenIProvideYesToAMLQuestionAndTheTurnoverIsmAndAboveAndXLiableForPreviousFY, whenISelectMyEntityTypeAsXAndProvideTheRegistrationDetails, whenISelectXOnWhetherOrNotICarriedOutAMLregulatedActivityInCurrentFYAndInPreviousFY, whenISelectXOnWhetherOrNotToAddASecondaryContactDetails, whenISelectXOnWhetherOrNotToUseADifferentUKAddressAsMyMainContactAddress}

class RegistrationSpec extends BaseSpec with Matchers {

  Feature("Register for ECL") {

    Scenario("User registers a <Entity type> supervised by HMRC for AML that is liable for ECL [Entity type=Sole trader]") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I provide details of my Sole trader that is supervised by HMRC and liable for current ECL")
      whenIProvideDetailsOfMyXThatIsSupervisedByHMRCAndLiableForCurrentECL("Sole trader")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Registration submitted")
      thenIShouldBeOnThePageThatSaysX("Registration submitted")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to use another UK address as his registered address for the main contact") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I provide the details of another UK address as my main contact address")
      andIProvideTheDetailsOfAnotherUKAddressAsMyMainContactAddress()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to use another non UK address as his registered address for the main contact") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I provide the details of a non UK address as my main contact address")
      andIProvideTheDetailsOfANonUKAddressAsMyMainContactAddress()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to go to check your answers page directly without providing any of the previous pages details") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I go to check your answers page directly without providing answers for any of the previous page questions")
      andIGoToCheckYourAnswersPageDirectlyWithoutProvidingAnswersForAnyOfThePreviousPageQuestions()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says The answers you provided are not valid")
      thenIShouldBeOnThePageThatSaysX("The answers you provided are not valid")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to change the contact details before submitting the registration") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I click on the change link and edit my contact details")
      whenIClickOnTheChangeLinkAndEditMyContactDetails()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to remove the secondary contact details before submitting the registration") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I click on the change link to modify my secondary contact")
      whenIClickOnTheChangeLinkToModifyMySecondaryContact()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I select No on whether or not to add a secondary contact details")
      whenISelectXOnWhetherOrNotToAddASecondaryContactDetails("No")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to change the contact address before submitting the registration") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I click on the change link to modify the registered address")
      whenIClickOnTheChangeLinkToModifyTheRegisteredAddress()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I select No on whether or not to use a different UK address as my main contact address")
      whenISelectXOnWhetherOrNotToUseADifferentUKAddressAsMyMainContactAddress("No")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to change the the organisation details (Business sector, AML supervisor, UK revenue and Accounting Period) before submitting the registration") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I click on the change link and edit my organisation details")
      whenIClickOnTheChangeLinkAndEditMyOrganisationDetails()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to change the AML regulated activity of the organisation before submitting the registration") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I click on the change link and select No on whether or not I carried out AML-regulated activity in current FY")
      whenIClickOnTheChangeLinkAndSelectXOnWhetherOrNotICarriedOutAMLregulatedActivityInCurrentFY("No")  // auto-chosen (score=0.85, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Are you liable for any previous financial years?")
      thenIShouldBeOnThePageThatSaysX("Are you liable for any previous financial years?")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I click on the Back link")
      thenIClickOnTheBackLink()  // auto-chosen (score=1.00, BaseStepsSteps.scala)

      Then("I should be on the page that says Did you carry out anti-money laundering (AML) regulated activity between 1 April 2025 and 31 March 2026?")
      thenIShouldBeOnThePageThatSaysX("Did you carry out anti-money laundering (AML) regulated activity between 1 April 2025 and 31 March 2026?")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I click the Save and continue button")
      thenIClickTheSaveAndContinueButton()  // auto-chosen (score=1.00, BaseStepsSteps.scala)

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to change the entity type of the organisation before submitting the registration") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I click on the change link and select the new entity type")
      whenIClickOnTheChangeLinkAndSelectTheNewEntityType()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User selects their entity type as General or Scottish Partnership [Entity type=General partnership]") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I select my entity type as General partnership and provide the registration details")
      whenISelectMyEntityTypeAsXAndProvideTheRegistrationDetails("General partnership")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User selects their entity type as General or Scottish Partnership [Entity type=Scottish partnership]") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I select my entity type as Scottish partnership and provide the registration details")
      whenISelectMyEntityTypeAsXAndProvideTheRegistrationDetails("Scottish partnership")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User registers <Other Entity> as entity type for AML that is liable for ECL [Other Entity=Charity]") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I provide details of my other entity is Charity that is supervised by HMRC and liable for ECL")
      whenIProvideDetailsOfMyOtherEntityIsXThatIsSupervisedByHMRCAndLiableForECL("Charity")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)
      // --- Other possible matches ---
      // whenIProvideDetailsOfMyXThatIsSupervisedByHMRCAndLiableForCurrentECL() [0.76] (RegistrationStepDefSteps.scala) pattern: I provide details of my (.*) that is supervised by HMRC and liable for current ECL

      Then("I should be on the page that says Registration received")
      thenIShouldBeOnThePageThatSaysX("Registration received")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User registers <Other Entity> as entity type for AML that is liable for ECL [Other Entity=Unincorporated Association]") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I provide details of my other entity is Unincorporated Association that is supervised by HMRC and liable for ECL")
      whenIProvideDetailsOfMyOtherEntityIsXThatIsSupervisedByHMRCAndLiableForECL("Unincorporated Association")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)
      // --- Other possible matches ---
      // whenIProvideDetailsOfMyXThatIsSupervisedByHMRCAndLiableForCurrentECL() [0.76] (RegistrationStepDefSteps.scala) pattern: I provide details of my (.*) that is supervised by HMRC and liable for current ECL

      Then("I should be on the page that says Registration received")
      thenIShouldBeOnThePageThatSaysX("Registration received")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User registers <Other Entity> as entity type for AML that is liable for ECL [Other Entity=Trust]") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I provide details of my other entity is Trust that is supervised by HMRC and liable for ECL")
      whenIProvideDetailsOfMyOtherEntityIsXThatIsSupervisedByHMRCAndLiableForECL("Trust")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)
      // --- Other possible matches ---
      // whenIProvideDetailsOfMyXThatIsSupervisedByHMRCAndLiableForCurrentECL() [0.76] (RegistrationStepDefSteps.scala) pattern: I provide details of my (.*) that is supervised by HMRC and liable for current ECL

      Then("I should be on the page that says Registration received")
      thenIShouldBeOnThePageThatSaysX("Registration received")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User registers <Other Entity> as entity type for AML that is liable for ECL [Other Entity=Non-UK Establishment]") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I provide details of my other entity is Non-UK Establishment that is supervised by HMRC and liable for ECL")
      whenIProvideDetailsOfMyOtherEntityIsXThatIsSupervisedByHMRCAndLiableForECL("Non-UK Establishment")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)
      // --- Other possible matches ---
      // whenIProvideDetailsOfMyXThatIsSupervisedByHMRCAndLiableForCurrentECL() [0.76] (RegistrationStepDefSteps.scala) pattern: I provide details of my (.*) that is supervised by HMRC and liable for current ECL

      Then("I should be on the page that says Registration received")
      thenIShouldBeOnThePageThatSaysX("Registration received")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Users who answer NO to AML question for the current FY but YES to previous FY") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I provide details of my limited company and indicate liability for previous year ECL")
      whenIProvideDetailsOfMyLimitedCompanyAndIndicateLiabilityForPreviousYearECL()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Registration submitted")
      thenIShouldBeOnThePageThatSaysX("Registration submitted")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Users who answer No whether or not they started AML regulated activity in current FY and No to previous FY") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I select No on whether or not I carried out AML-regulated activity in current FY and in previous FY")
      whenISelectXOnWhetherOrNotICarriedOutAMLregulatedActivityInCurrentFYAndInPreviousFY("No")  // auto-chosen (score=0.85, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says You do not need to register for the Economic Crime Levy")
      thenIShouldBeOnThePageThatSaysX("You do not need to register for the Economic Crime Levy")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User registers a limited company supervised by HMRC for AML who have turnover of £10.2m and above that is liable for previous FY") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I provide Yes to AML question and the turnover is £10.2m and above and Yes liable for previous FY")
      whenIProvideYesToAMLQuestionAndTheTurnoverIsmAndAboveAndXLiableForPreviousFY("Yes")  // auto-chosen (score=0.85, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Registration submitted")
      thenIShouldBeOnThePageThatSaysX("Registration submitted")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User registers a limited company supervised by HMRC for AML who have turnover of £10.2m and above that is not liable for previous FY") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I provide Yes to AML question and the turnover is £10.2m and above and No liable for previous FY")
      whenIProvideYesToAMLQuestionAndTheTurnoverIsmAndAboveAndXLiableForPreviousFY("No")  // auto-chosen (score=0.85, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Registration submitted")
      thenIShouldBeOnThePageThatSaysX("Registration submitted")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User registers a limited company supervised by HMRC for AML who have turnover of below £10.2m and that is liable for previous FY") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I provide Yes to AML question and the turnover is below £10.2m threshold and Yes liable for previous FY")
      whenIProvideYesToAMLQuestionAndTheTurnoverIsBelowThresholdAndXLiableForPreviousFY("Yes")  // auto-chosen (score=0.85, RegistrationStepDefSteps.scala)
      // --- Other possible matches ---
      // whenIProvideYesToAMLQuestionAndTheTurnoverIsmAndAboveAndXLiableForPreviousFY() [0.78] (RegistrationStepDefSteps.scala) pattern: I provide Yes to AML question and the turnover is £10.2m and above and (.*) liable for previous FY

      Then("I should be on the page that says Registration submitted")
      thenIShouldBeOnThePageThatSaysX("Registration submitted")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User registers a limited company supervised by HMRC for AML who have turnover of below £10.2m and that is not liable for previous FY") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I provide Yes to AML question and the turnover is below £10.2m threshold but No liability for previous year ECL")
      whenIProvideYesToAMLQuestionAndTheTurnoverIsBelowThresholdButXLiabilityForPreviousYearECL("No")  // auto-chosen (score=0.85, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says You do not need to register for the Economic Crime Levy")
      thenIShouldBeOnThePageThatSaysX("You do not need to register for the Economic Crime Levy")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User registers a Limited company failed GRS identifiers and tries again") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I provide details of my Limited company and fail the GRS journey")
      whenIProvideDetailsOfMyXAndFailTheGRSJourney("Limited company")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says The details you have entered do not match our records")
      thenIShouldBeOnThePageThatSaysX("The details you have entered do not match our records")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I click on the try again button")
      andIClickOnTheTryAgainButton()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says What is your entity type?")
      thenIShouldBeOnThePageThatSaysX("What is your entity type?")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User is able to cancel the amend registrations they have submitted through ECL account dashboard") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000001")
      givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000001")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I provide the details to amend the submitted economic crime levy registration")
      whenIProvideTheDetailsToAmendTheSubmittedEconomicCrimeLevyRegistration()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I decide to cancel this amendments")
      andIDecideToCancelThisAmendments()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Your Economic Crime Levy account")
      thenIShouldBeOnThePageThatSaysX("Your Economic Crime Levy account")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User amends the submitted registration via ECL account dashboard") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000001")
      givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000001")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I provide the details to amend the submitted economic crime levy registration")
      whenIProvideTheDetailsToAmendTheSubmittedEconomicCrimeLevyRegistration()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)


      val contactDetails: Map[String, String] = Map(
        "First contact name"             -> "James Bond",
        "First contact role"             -> "Director",
        "First contact email address"    -> "confirm@test.com",
        "First contact telephone number" -> "01475344272"
      )


      And("the amended registration information should display under Amended answers on the Check your answers page")
      andTheAmendedRegistrationInformationShouldDisplayUnderAmendedAnswersOnTheCheckYourAnswersPage(contactDetails)  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I should be on the page that says Economic Crime Levy registration amendment requested")
      thenIShouldBeOnThePageThatSaysX("Economic Crime Levy registration amendment requested")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User is amend the liability start date for registrations to previous FY through ECL account dashboard") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000001")
      givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000001")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I provide the details to amend the liability start date for registration")
      whenIProvideTheDetailsToAmendTheLiabilityStartDateForRegistration()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Economic Crime Levy registration amendment requested")
      thenIShouldBeOnThePageThatSaysX("Economic Crime Levy registration amendment requested")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User is able to save progress in the registration journey and resume later") {
      Given("I am signed in to the registration journey")
      givenIAmSignedInToTheRegistrationJourney()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I provide some details for the economic crime levy registration and experience a system timeout")
      whenIProvideSomeDetailsForTheEconomicCrimeLevyRegistrationAndExperienceASystemTimeout()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)
      // --- Other possible matches ---
      // whenIProvideSomeDetailsForTheEconomicCrimeLevyReturnSubmissionAndExperienceASystemTimeout() [0.76] (ReturnsStepDefSteps.scala) pattern: I provide some details for the economic crime levy return submission and experience a system timeout

      And("I return to the service to complete the registration")
      andIReturnToTheServiceToCompleteTheRegistration()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Your answers have been saved")
      thenIShouldBeOnThePageThatSaysX("Your answers have been saved")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I should be able to resume the registration from where I left off")
      andIShouldBeAbleToResumeTheRegistrationFromWhereILeftOff()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Registration submitted")
      thenIShouldBeOnThePageThatSaysX("Registration submitted")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }
  }
}
