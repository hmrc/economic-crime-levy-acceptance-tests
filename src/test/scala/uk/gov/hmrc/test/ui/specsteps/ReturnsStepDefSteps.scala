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

package uk.gov.hmrc.test.ui.specsteps
import uk.gov.hmrc.test.ui.specpage.SharedActions
import uk.gov.hmrc.test.ui.specpage.account.AccountPage
import uk.gov.hmrc.test.ui.specpage.returns.ReturnsPage._
import uk.gov.hmrc.test.ui.specpage.returns._

object ReturnsStepDefSteps {


  def givenIAmSignedInToTheReturnJourney(): Unit = {
    ReturnsPage
      .navigateTo()
      .provideEnrolmentDetails(
        enrolmentKey = "HMRC-ECL-ORG",
        identifierName = "EclRegistrationReference",
        identifierValue = "XMECL0000000001"
      )
      .submitPage()
    onPage(ReturnsPage.recentDueHeading)
    ReturnsPage
      .startAndSignIn()
  }


  def whenIProvideTheDetailsToSubmitTheEconomicCrimeLevyReturn(): Unit = {
    selectAccountingPeriod("Yes")
    onPage(UkRevenuePage.heading)
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideCheckYourAnswers()
  }


  def whenIEnter12MonthAccountingPeriodRevenueXAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear(
    ukRevenue: String,
    value: String
  ): Unit = {
    selectAccountingPeriod("Yes")
    onPage(UkRevenuePage.heading)
    ReturnsPage
      .provideUkRevenue(ukRevenue)
    onPage(AmlRegulatedActivityPage.heading)
    ReturnsPage
      .selectAmlRegulatedActivity(value)
  }


  def andIEnterTheNumberOfDaysXICarriedOutAMLRegulatedActivityDuringTheFinancialYear(days: String): Unit = {
    provideAmlRegulatedActivityDays(days)
    onPage(AmountDuePage.heading)
  }


  def whenISelectXForMyAccountingPeriod12MonthsAndEnterTheLengthOfMyAccountingPeriodAsXDays(
    value: String,
    days: String
  ): Unit = {
    selectAccountingPeriod(value)
    onPage(AccountingPeriodPage.heading)
    ReturnsPage
      .provideAmlRegulatedActivityDays(days)
    onPage(UkRevenuePage.heading)
  }


  def whenIEnterMyUKRevenueXForTheAccountingPeriodAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear(
    ukRevenue: String,
    value: String
  ): Unit = {
    provideUkRevenue(ukRevenue)
    onPage(AmlRegulatedActivityPage.heading)
    ReturnsPage
      .selectAmlRegulatedActivity(value)
  }


  def andIGoToTheReturnSubmissionCheckYourAnswersPageDirectlyWithoutProvidingAnswersForAnyOfThePreviousPageQuestions()
    : Unit =
    CheckYourAnswersPage
      .navigateTo()


  def whenIClickOnTheChangeLinkToModifyMyContactDetails(): Unit = {
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeContactDetails("James Bond 007", "Compliance Officer", "verify@oc.com", "014753777777")
  }


  def whenIClickOnTheChangeLinkToModifyMyEconomicCrimeLevyAccountingPeriod(): Unit = {
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeAccountingPeriod("No")
      .submitPage()
  }


  def whenIClickOnTheChangeLinkToModifyMyAccountingPeriodLength(): Unit = {
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeAccountingPeriod("No")
      .provideChangeAccountingPeriodLength("364")
  }


  def whenIClickOnTheChangeLinkToModifyMyUkRevenue(): Unit = {
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeUkRevenue("20200000")
      .submitPage()
  }


  def whenIClickOnTheChangeLinkToModifyMyAMLregulatedActivityForTheFullFinancialYear(): Unit = {
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeAmlRegulatedActivity("No")
  }


  def whenIClickOnTheChangeLinkToModifyMyAMLregulatedActivityLength(): Unit = {
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeAmlRegulatedActivity("No")
      .provideChangeAmlRegulatedActivityLength("291")
  }


  def thenIShouldBeSeeTheAmountOfECLNeedToPayX(value: String): Unit =
    SharedActions
      .validateLevyAmount(value)


  def whenIEnter12MonthAccountingPeriodRevenueIsXThatFallsInTheSmallBandSize(ukRevenue: String): Unit =
    selectAccountingPeriod("Yes")
      .provideUkRevenue(ukRevenue)


  def whenIClickOnTheChangeLinkToEditMyUkRevenueFromAmountDuePageAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear(
    value: String
  ): Unit =
    selectAccountingPeriod("Yes")
      .provideUkRevenue("10199999")
      .provideChangeUkRevenue("20200000")
      .selectAmlRegulatedActivity(value)


  def whenIClickOnTheChangeLinkToEditMyAccountingPeriodAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear(
    value: String
  ): Unit =
    selectAccountingPeriod("Yes")
      .provideUkRevenue("10199999")
      .provideChangeAccountingPeriod("No")
      .selectAmlRegulatedActivity(value)


  def thenIShouldSeeMyEclReturnNumberIsXAndTheAmountToPayIsX(eclReturnNumber: String, amountToPay: String): Unit =
    ReturnsPage
      .assertEclReturnNumber(eclReturnNumber)
      .assertAmountNeedToPay(amountToPay)


  def whenIEnterTheInformationRequiredToCalculateTheAmountDue(): Unit =
    selectAccountingPeriod("Yes")
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()


  def whenIProvideTheDetailsForAReturnSubmission(): Unit =
    selectAccountingPeriod("Yes")
      .provideUkRevenueForNilReturnSubmission()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideCheckYourAnswers()


  def thenIShouldSeeTheAmountToPayIsX(amountToPay: String): Unit =
    SharedActions
      .assertTextByCssSelector(".govuk-label--m", amountToPay)


  def whenIProvideTheDetailsToAmendTheSubmittedEconomicCrimeLevyReturn(): Unit = {
    AccountPage
      .provideViewOrAmendAnEclReturn("amend")
      .provideAmendSubmitReturn()
    SharedActions
      .enterDetails("Revenue Changed in the current FY ")
    ReturnsPage
      .provideChangeContactDetails("James Bond 007", "Compliance Officer", "verify@oc.com", "014753777777")
  }


  def andTheAmendedReturnInformationShouldDisplayUnderAmendedAnswersOnTheCheckYourAnswersPage(arg: Map[String, String]): Unit =
    assertAmendedReturnAnswers(arg)
      .submitPage()
















  def whenIProvideSomeDetailsForTheEconomicCrimeLevyReturnSubmissionAndExperienceASystemTimeout(): Unit = {
    selectAccountingPeriod("Yes")
    onPage(UkRevenuePage.heading)
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
  }


  def andIReturnToTheServiceToCompleteTheTheReturnSubmission(): Unit =
    provideReturnSubmissionAfterTimeout()
      .submitPage()


  def andIShouldBeAbleToResumeTheSubmissionFromWhereILeftOff(): Unit =
    SharedActions
      .selectContinueWithSavedAnswers()
      .submitPage()

}
