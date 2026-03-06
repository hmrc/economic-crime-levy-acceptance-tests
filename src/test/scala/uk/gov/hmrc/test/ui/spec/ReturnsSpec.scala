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
import uk.gov.hmrc.test.ui.specsteps.RegistrationStepDefSteps.{andIDecideToCancelThisAmendments, thenIShouldBeOnThePageThatSaysX}
import uk.gov.hmrc.test.ui.specsteps.ReturnsStepDefSteps.{andIEnterTheNumberOfDaysXICarriedOutAMLRegulatedActivityDuringTheFinancialYear, andIGoToTheReturnSubmissionCheckYourAnswersPageDirectlyWithoutProvidingAnswersForAnyOfThePreviousPageQuestions, andIReturnToTheServiceToCompleteTheTheReturnSubmission, andIShouldBeAbleToResumeTheSubmissionFromWhereILeftOff, andTheAmendedReturnInformationShouldDisplayUnderAmendedAnswersOnTheCheckYourAnswersPage, givenIAmSignedInToTheReturnJourney, thenIShouldSeeMyEclReturnNumberIsXAndTheAmountToPayIsX, thenIShouldSeeTheAmountToPayIsX, whenIClickOnTheChangeLinkToEditMyAccountingPeriodAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear, whenIClickOnTheChangeLinkToEditMyUkRevenueFromAmountDuePageAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear, whenIClickOnTheChangeLinkToModifyMyAMLregulatedActivityForTheFullFinancialYear, whenIClickOnTheChangeLinkToModifyMyAMLregulatedActivityLength, whenIClickOnTheChangeLinkToModifyMyAccountingPeriodLength, whenIClickOnTheChangeLinkToModifyMyContactDetails, whenIClickOnTheChangeLinkToModifyMyEconomicCrimeLevyAccountingPeriod, whenIClickOnTheChangeLinkToModifyMyUkRevenue, whenIEnter12MonthAccountingPeriodRevenueIsXThatFallsInTheSmallBandSize, whenIEnter12MonthAccountingPeriodRevenueXAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear, whenIEnterMyUKRevenueXForTheAccountingPeriodAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear, whenIEnterTheInformationRequiredToCalculateTheAmountDue, whenIProvideSomeDetailsForTheEconomicCrimeLevyReturnSubmissionAndExperienceASystemTimeout, whenIProvideTheDetailsForAReturnSubmission, whenIProvideTheDetailsToAmendTheSubmittedEconomicCrimeLevyReturn, whenIProvideTheDetailsToSubmitTheEconomicCrimeLevyReturn, whenISelectXForMyAccountingPeriod12MonthsAndEnterTheLengthOfMyAccountingPeriodAsXDays}


class ReturnsSpec extends BaseSpec with Matchers {

  Feature("Submit ECL Return") {

    Scenario("User that is registered for ECL starts a return submission") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I provide the details to submit the economic crime levy return")
      whenIProvideTheDetailsToSubmitTheEconomicCrimeLevyReturn()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says Return submitted")
      thenIShouldBeOnThePageThatSaysX("Return submitted")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I should see my ecl return number is ECL return number and the amount to pay is Amount you need to pay")
      thenIShouldSeeMyEclReturnNumberIsXAndTheAmountToPayIsX("ECL return number", "Amount you need to pay")  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=10200000, Expected content=You need to pay £10,000]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I enter 12 month accounting period revenue 10200000 and select Yes for my AML-regulated activity for the full financial year")
      whenIEnter12MonthAccountingPeriodRevenueXAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("10200000", "Yes")  // auto-chosen (score=0.90, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £10,000")
      thenIShouldBeOnThePageThatSaysX("You need to pay £10,000")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=35999999, Expected content=You need to pay £10,000]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I enter 12 month accounting period revenue 35999999 and select Yes for my AML-regulated activity for the full financial year")
      whenIEnter12MonthAccountingPeriodRevenueXAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("35999999", "Yes")  // auto-chosen (score=0.90, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £10,000")
      thenIShouldBeOnThePageThatSaysX("You need to pay £10,000")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=36000000, Expected content=You need to pay £36,000]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I enter 12 month accounting period revenue 36000000 and select Yes for my AML-regulated activity for the full financial year")
      whenIEnter12MonthAccountingPeriodRevenueXAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("36000000", "Yes")  // auto-chosen (score=0.90, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £36,000")
      thenIShouldBeOnThePageThatSaysX("You need to pay £36,000")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=999999999, Expected content=You need to pay £36,000]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I enter 12 month accounting period revenue 999999999 and select Yes for my AML-regulated activity for the full financial year")
      whenIEnter12MonthAccountingPeriodRevenueXAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("999999999", "Yes")  // auto-chosen (score=0.90, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £36,000")
      thenIShouldBeOnThePageThatSaysX("You need to pay £36,000")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=1000000000, Expected content=You need to pay £500,000]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I enter 12 month accounting period revenue 1000000000 and select Yes for my AML-regulated activity for the full financial year")
      whenIEnter12MonthAccountingPeriodRevenueXAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("1000000000", "Yes")  // auto-chosen (score=0.90, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £500,000")
      thenIShouldBeOnThePageThatSaysX("You need to pay £500,000")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the non-full financial year [UK Revenue=10200000, AMLDays=60, Expected content=You need to pay £1,643.83]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I enter 12 month accounting period revenue 10200000 and select No for my AML-regulated activity for the full financial year")
      whenIEnter12MonthAccountingPeriodRevenueXAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("10200000", "No")  // auto-chosen (score=0.90, ReturnsStepDefSteps.scala)

      And("I enter the number of days 60 I carried out AML regulated activity during the financial year")
      andIEnterTheNumberOfDaysXICarriedOutAMLRegulatedActivityDuringTheFinancialYear("60")  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £1,643.83")
      thenIShouldBeOnThePageThatSaysX("You need to pay £1,643.83")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the non-full financial year [UK Revenue=999999999, AMLDays=204, Expected content=You need to pay £20,120.54]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I enter 12 month accounting period revenue 999999999 and select No for my AML-regulated activity for the full financial year")
      whenIEnter12MonthAccountingPeriodRevenueXAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("999999999", "No")  // auto-chosen (score=0.90, ReturnsStepDefSteps.scala)

      And("I enter the number of days 204 I carried out AML regulated activity during the financial year")
      andIEnterTheNumberOfDaysXICarriedOutAMLRegulatedActivityDuringTheFinancialYear("204")  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £20,120.54")
      thenIShouldBeOnThePageThatSaysX("You need to pay £20,120.54")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the non-full financial year [UK Revenue=1000000000, AMLDays=330, Expected content=You need to pay £452,054.79]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I enter 12 month accounting period revenue 1000000000 and select No for my AML-regulated activity for the full financial year")
      whenIEnter12MonthAccountingPeriodRevenueXAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("1000000000", "No")  // auto-chosen (score=0.90, ReturnsStepDefSteps.scala)

      And("I enter the number of days 330 I carried out AML regulated activity during the financial year")
      andIEnterTheNumberOfDaysXICarriedOutAMLRegulatedActivityDuringTheFinancialYear("330")  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £452,054.79")
      thenIShouldBeOnThePageThatSaysX("You need to pay £452,054.79")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Return submission for non 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=10000000, APDays=182, Expected content=You need to pay £10,000]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I select No for my accounting period 12 months and enter the length of my accounting period as 182 days")
      whenISelectXForMyAccountingPeriod12MonthsAndEnterTheLengthOfMyAccountingPeriodAsXDays("No", "182")  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      And("I enter my UK revenue 10000000 for the accounting period and select Yes for my AML-regulated activity for the full financial year")
      whenIEnterMyUKRevenueXForTheAccountingPeriodAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("10000000", "Yes")  // auto-chosen (score=0.90, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £10,000")
      thenIShouldBeOnThePageThatSaysX("You need to pay £10,000")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Return submission for non 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=8000000, APDays=73, Expected content=You need to pay £36,000]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I select No for my accounting period 12 months and enter the length of my accounting period as 73 days")
      whenISelectXForMyAccountingPeriod12MonthsAndEnterTheLengthOfMyAccountingPeriodAsXDays("No", "73")  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      And("I enter my UK revenue 8000000 for the accounting period and select Yes for my AML-regulated activity for the full financial year")
      whenIEnterMyUKRevenueXForTheAccountingPeriodAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("8000000", "Yes")  // auto-chosen (score=0.90, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £36,000")
      thenIShouldBeOnThePageThatSaysX("You need to pay £36,000")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Return submission for non 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=1300000000, APDays=450, Expected content=You need to pay £500,000]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I select No for my accounting period 12 months and enter the length of my accounting period as 450 days")
      whenISelectXForMyAccountingPeriod12MonthsAndEnterTheLengthOfMyAccountingPeriodAsXDays("No", "450")  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      And("I enter my UK revenue 1300000000 for the accounting period and select Yes for my AML-regulated activity for the full financial year")
      whenIEnterMyUKRevenueXForTheAccountingPeriodAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("1300000000", "Yes")  // auto-chosen (score=0.90, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £500,000")
      thenIShouldBeOnThePageThatSaysX("You need to pay £500,000")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Return submission for non 12 month accounting period and AML-regulated activity for the non-full financial year [UK Revenue=10000000, APDays=113, AMLDays=198, Expected content=You need to pay £5,424.65]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I select No for my accounting period 12 months and enter the length of my accounting period as 113 days")
      whenISelectXForMyAccountingPeriod12MonthsAndEnterTheLengthOfMyAccountingPeriodAsXDays("No", "113")  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      And("I enter my UK revenue 10000000 for the accounting period and select No for my AML-regulated activity for the full financial year")
      whenIEnterMyUKRevenueXForTheAccountingPeriodAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("10000000", "No")  // auto-chosen (score=0.90, ReturnsStepDefSteps.scala)

      And("I enter the number of days 198 I carried out AML regulated activity during the financial year")
      andIEnterTheNumberOfDaysXICarriedOutAMLRegulatedActivityDuringTheFinancialYear("198")  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £5,424.65")
      thenIShouldBeOnThePageThatSaysX("You need to pay £5,424.65")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Return submission for non 12 month accounting period and AML-regulated activity for the non-full financial year [UK Revenue=31000000, APDays=284, AMLDays=300, Expected content=You need to pay £29,589.04]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I select No for my accounting period 12 months and enter the length of my accounting period as 284 days")
      whenISelectXForMyAccountingPeriod12MonthsAndEnterTheLengthOfMyAccountingPeriodAsXDays("No", "284")  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      And("I enter my UK revenue 31000000 for the accounting period and select No for my AML-regulated activity for the full financial year")
      whenIEnterMyUKRevenueXForTheAccountingPeriodAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("31000000", "No")  // auto-chosen (score=0.90, ReturnsStepDefSteps.scala)

      And("I enter the number of days 300 I carried out AML regulated activity during the financial year")
      andIEnterTheNumberOfDaysXICarriedOutAMLRegulatedActivityDuringTheFinancialYear("300")  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £29,589.04")
      thenIShouldBeOnThePageThatSaysX("You need to pay £29,589.04")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Return submission for non 12 month accounting period and AML-regulated activity for the non-full financial year [UK Revenue=350000000, APDays=91, AMLDays=256, Expected content=You need to pay £350,684.93]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I select No for my accounting period 12 months and enter the length of my accounting period as 91 days")
      whenISelectXForMyAccountingPeriod12MonthsAndEnterTheLengthOfMyAccountingPeriodAsXDays("No", "91")  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      And("I enter my UK revenue 350000000 for the accounting period and select No for my AML-regulated activity for the full financial year")
      whenIEnterMyUKRevenueXForTheAccountingPeriodAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("350000000", "No")  // auto-chosen (score=0.90, ReturnsStepDefSteps.scala)

      And("I enter the number of days 256 I carried out AML regulated activity during the financial year")
      andIEnterTheNumberOfDaysXICarriedOutAMLRegulatedActivityDuringTheFinancialYear("256")  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £350,684.93")
      thenIShouldBeOnThePageThatSaysX("You need to pay £350,684.93")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to go to check your answers page directly without providing any of the previous pages details") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I go to the return submission check your answers page directly without providing answers for any of the previous page questions")
      andIGoToTheReturnSubmissionCheckYourAnswersPageDirectlyWithoutProvidingAnswersForAnyOfThePreviousPageQuestions()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says The answers you provided are not valid")
      thenIShouldBeOnThePageThatSaysX("The answers you provided are not valid")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to change their ECL contact details before submitting the returns") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I click on the change link to modify my contact details")
      whenIClickOnTheChangeLinkToModifyMyContactDetails()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to change their ECL accounting period before submitting the returns") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I click on the change link to modify my economic crime levy accounting period")
      whenIClickOnTheChangeLinkToModifyMyEconomicCrimeLevyAccountingPeriod()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I click on the Back link")
      thenIClickOnTheBackLink()  // auto-chosen (score=1.00, BaseStepsSteps.scala)

      Then("I should be on the page that says Amount of Economic Crime Levy you need to pay")
      thenIShouldBeOnThePageThatSaysX("Amount of Economic Crime Levy you need to pay")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I click the Save and continue button")
      thenIClickTheSaveAndContinueButton()  // auto-chosen (score=1.00, BaseStepsSteps.scala)

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to change their ECL accounting period length before submitting the returns") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I click on the change link to modify my accounting period length")
      whenIClickOnTheChangeLinkToModifyMyAccountingPeriodLength()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to change their ECL UK revenue before submitting the returns") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I click on the change link to modify my uk revenue")
      whenIClickOnTheChangeLinkToModifyMyUkRevenue()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to change their AML-regulated activity for the full financial year before submitting the returns") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I click on the change link to modify my AML-regulated activity for the full financial year")
      whenIClickOnTheChangeLinkToModifyMyAMLregulatedActivityForTheFullFinancialYear()

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to change their AML-regulated activity length before submitting the returns") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I click on the change link to modify my AML-regulated activity length")
      whenIClickOnTheChangeLinkToModifyMyAMLregulatedActivityLength()

      Then("I should be on the page that says Check your answers")
      thenIShouldBeOnThePageThatSaysX("Check your answers")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("Return submission for users who falls in the small band size (less than 10.2M)") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I enter 12 month accounting period revenue is 10199999 that falls in the small band size")
      whenIEnter12MonthAccountingPeriodRevenueIsXThatFallsInTheSmallBandSize("10199999")  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You do not need to pay the Economic Crime Levy (ECL)")
      thenIShouldBeOnThePageThatSaysX("You do not need to pay the Economic Crime Levy (ECL)")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to change their UK revenue (greater than or equal to 10.2M) from amount due page") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I click on the change link to edit my uk revenue from amount due page and select Yes for my AML-regulated activity for the full financial year")
      whenIClickOnTheChangeLinkToEditMyUkRevenueFromAmountDuePageAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("Yes")  // auto-chosen (score=0.85, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £10,000")
      thenIShouldBeOnThePageThatSaysX("You need to pay £10,000")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User wants to change the accounting period from amount due page for their UK revenue less than 10.2M") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I click on the change link to edit my accounting period and select Yes for my AML-regulated activity for the full financial year")
      whenIClickOnTheChangeLinkToEditMyAccountingPeriodAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear("Yes")  // auto-chosen (score=0.85, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says You need to pay £10,000")
      thenIShouldBeOnThePageThatSaysX("You need to pay £10,000")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User is on the amount due page with content explaining how it was calculated [Expected content=Amount of Economic Crime Levy you need to pay]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I enter the information required to calculate the amount due")
      whenIEnterTheInformationRequiredToCalculateTheAmountDue()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says Amount of Economic Crime Levy you need to pay")
      thenIShouldBeOnThePageThatSaysX("Amount of Economic Crime Levy you need to pay")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User is on the amount due page with content explaining how it was calculated [Expected content=Your band size]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I enter the information required to calculate the amount due")
      whenIEnterTheInformationRequiredToCalculateTheAmountDue()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says Your band size")
      thenIShouldBeOnThePageThatSaysX("Your band size")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User is on the amount due page with content explaining how it was calculated [Expected content=How we worked this out]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I enter the information required to calculate the amount due")
      whenIEnterTheInformationRequiredToCalculateTheAmountDue()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says How we worked this out")
      thenIShouldBeOnThePageThatSaysX("How we worked this out")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User is on the amount due page with content explaining how it was calculated [Expected content=How the size bands affect what you need to pay]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I enter the information required to calculate the amount due")
      whenIEnterTheInformationRequiredToCalculateTheAmountDue()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says How the size bands affect what you need to pay")
      thenIShouldBeOnThePageThatSaysX("How the size bands affect what you need to pay")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User is on the amount due page with content explaining how it was calculated [Expected content=What you need to do next]") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I enter the information required to calculate the amount due")
      whenIEnterTheInformationRequiredToCalculateTheAmountDue()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says What you need to do next")
      thenIShouldBeOnThePageThatSaysX("What you need to do next")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User that is registered for ECL starts for a nil return submission") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I provide the details for a return submission")
      whenIProvideTheDetailsForAReturnSubmission()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says Return submitted")
      thenIShouldBeOnThePageThatSaysX("Return submitted")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I should see the amount to pay is Amount you need to pay: £0")
      thenIShouldSeeTheAmountToPayIsX("Amount you need to pay: £0")  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

    }

    Scenario("User cancels amendments to the submitted economic crime levy return") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000007")
      givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000007")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I provide the details to amend the submitted economic crime levy return")
      whenIProvideTheDetailsToAmendTheSubmittedEconomicCrimeLevyReturn()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      And("I decide to cancel this amendments")
      andIDecideToCancelThisAmendments()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      Then("I should be on the page that says Your Economic Crime Levy account")
      thenIShouldBeOnThePageThatSaysX("Your Economic Crime Levy account")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User amends the submitted returns via ECL account dashboard") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000007")
      givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000007")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I provide the details to amend the submitted economic crime levy return")
      whenIProvideTheDetailsToAmendTheSubmittedEconomicCrimeLevyReturn()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)


      val contactDetails: Map[String, String] = Map(
        "First contact name"             -> "James Bond 007",
        "First contact role"             -> "Compliance Officer",
        "First contact email address"    -> "verify@oc.com",
        "First contact telephone number" -> "014753777777"
      )


      And("the amended return information should display under Amended answers on the Check your answers page")
      andTheAmendedReturnInformationShouldDisplayUnderAmendedAnswersOnTheCheckYourAnswersPage(contactDetails)  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      And("I should be on the page that says Economic Crime Levy return amendment requested")
      thenIShouldBeOnThePageThatSaysX("Economic Crime Levy return amendment requested")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("User can save progress in the return submission journey and resume later") {
      Given("I am signed in to the return journey")
      givenIAmSignedInToTheReturnJourney()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      When("I provide some details for the economic crime levy return submission and experience a system timeout")
      whenIProvideSomeDetailsForTheEconomicCrimeLevyReturnSubmissionAndExperienceASystemTimeout()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)
      // --- Other possible matches ---
      // whenIProvideSomeDetailsForTheEconomicCrimeLevyRegistrationAndExperienceASystemTimeout() [0.80] (RegistrationStepDefSteps.scala) pattern: I provide some details for the economic crime levy registration and experience a system timeout

      And("I return to the service to complete the the return submission")
      andIReturnToTheServiceToCompleteTheTheReturnSubmission()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says Your answers have been saved")
      thenIShouldBeOnThePageThatSaysX("Your answers have been saved")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I should be able to resume the submission from where I left off")
      andIShouldBeAbleToResumeTheSubmissionFromWhereILeftOff()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says Return submitted")
      thenIShouldBeOnThePageThatSaysX("Return submitted")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }
  }
}
