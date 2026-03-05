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
import io.cucumber.datatable.DataTable
import uk.gov.hmrc.test.ui.pages.SharedActions
import uk.gov.hmrc.test.ui.pages.account.AccountPage
import uk.gov.hmrc.test.ui.pages.returns.ReturnsPage._
import uk.gov.hmrc.test.ui.pages.returns._

object ReturnsStepDefSteps {

  // I am signed in to the return journey
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

  // I provide the details to submit the economic crime levy return
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

  // ^I enter 12 month accounting period revenue (.*) and select (.*) for my AML-regulated activity for the full financial year$
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

  // ^I enter the number of days (.*) I carried out AML regulated activity during the financial year$
  def andIEnterTheNumberOfDaysXICarriedOutAMLRegulatedActivityDuringTheFinancialYear(days: String): Unit = {
    provideAmlRegulatedActivityDays(days)
    onPage(AmountDuePage.heading)
  }

  // ^I select (.*) for my accounting period 12 months and enter the length of my accounting period as (.*) days$
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

  // ^I enter my UK revenue (.*) for the accounting period and select (.*) for my AML-regulated activity for the full financial year$
  def whenIEnterMyUKRevenueXForTheAccountingPeriodAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear(
    ukRevenue: String,
    value: String
  ): Unit = {
    provideUkRevenue(ukRevenue)
    onPage(AmlRegulatedActivityPage.heading)
    ReturnsPage
      .selectAmlRegulatedActivity(value)
  }

  // I go to the return submission check your answers page directly without providing answers for any of the previous page questions
  def andIGoToTheReturnSubmissionCheckYourAnswersPageDirectlyWithoutProvidingAnswersForAnyOfThePreviousPageQuestions()
    : Unit =
    CheckYourAnswersPage
      .navigateTo()

  // I click on the change link to modify my contact details
  def whenIClickOnTheChangeLinkToModifyMyContactDetails(): Unit = {
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeContactDetails("James Bond 007", "Compliance Officer", "verify@oc.com", "014753777777")
  }

  // I click on the change link to modify my economic crime levy accounting period
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

  // I click on the change link to modify my accounting period length
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

  // I click on the change link to modify my uk revenue
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

  // I click on the change link to modify my AML-regulated activity for the full financial year
  def whenIClickOnTheChangeLinkToModifyMyAMLregulatedActivityForTheFullFinancialYear(): Unit = {
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeAmlRegulatedActivity("No")
  }

  // I click on the change link to modify my AML-regulated activity length
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

  // ^I should be see the amount of ECL need to pay (.*)$
  def thenIShouldBeSeeTheAmountOfECLNeedToPayX(value: String): Unit =
    SharedActions
      .validateLevyAmount(value)

  // ^I enter 12 month accounting period revenue is (.*) that falls in the small band size$
  def whenIEnter12MonthAccountingPeriodRevenueIsXThatFallsInTheSmallBandSize(ukRevenue: String): Unit =
    selectAccountingPeriod("Yes")
      .provideUkRevenue(ukRevenue)

  // I click on the change link to edit my uk revenue from amount due page and select (.*) for my AML-regulated activity for the full financial year$
  def whenIClickOnTheChangeLinkToEditMyUkRevenueFromAmountDuePageAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear(
    value: String
  ): Unit =
    selectAccountingPeriod("Yes")
      .provideUkRevenue("10199999")
      .provideChangeUkRevenue("20200000")
      .selectAmlRegulatedActivity(value)

  // I click on the change link to edit my accounting period and select (.*) for my AML-regulated activity for the full financial year$
  def whenIClickOnTheChangeLinkToEditMyAccountingPeriodAndSelectXForMyAMLregulatedActivityForTheFullFinancialYear(
    value: String
  ): Unit =
    selectAccountingPeriod("Yes")
      .provideUkRevenue("10199999")
      .provideChangeAccountingPeriod("No")
      .selectAmlRegulatedActivity(value)

  // ^I should see my ecl return number is (.*) and the amount to pay is (.*)$
  def thenIShouldSeeMyEclReturnNumberIsXAndTheAmountToPayIsX(eclReturnNumber: String, amountToPay: String): Unit =
    ReturnsPage
      .assertEclReturnNumber(eclReturnNumber)
      .assertAmountNeedToPay(amountToPay)

  // I enter the information required to calculate the amount due
  def whenIEnterTheInformationRequiredToCalculateTheAmountDue(): Unit =
    selectAccountingPeriod("Yes")
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()

  // I provide the details for a return submission
  def whenIProvideTheDetailsForAReturnSubmission(): Unit =
    selectAccountingPeriod("Yes")
      .provideUkRevenueForNilReturnSubmission()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideCheckYourAnswers()

  // ^I should see the amount to pay is (.*)$
  def thenIShouldSeeTheAmountToPayIsX(amountToPay: String): Unit =
    SharedActions
      .assertTextByCssSelector(".govuk-label--m", amountToPay)

  // I provide the details to amend the submitted economic crime levy return
  def whenIProvideTheDetailsToAmendTheSubmittedEconomicCrimeLevyReturn(): Unit = {
    AccountPage
      .provideViewOrAmendAnEclReturn("amend")
      .provideAmendSubmitReturn()
    SharedActions
      .enterDetails("Revenue Changed in the current FY ")
    ReturnsPage
      .provideChangeContactDetails("James Bond 007", "Compliance Officer", "verify@oc.com", "014753777777")
  }

  // the amended return information should display under Amended answers on the Check your answers page$
  def andTheAmendedReturnInformationShouldDisplayUnderAmendedAnswersOnTheCheckYourAnswersPage(arg: DataTable): Unit =
    assertAmendedReturnAnswers(arg)
      .submitPage()

  // Overload for ScalaTest (no DataTable, accepts varargs)
//  def andTheAmendedReturnInformationShouldDisplayUnderAmendedAnswersOnTheCheckYourAnswersPage(links: (String, String)*): Unit = {
//    links.foreach { case (text, url) =>
//      val driverWait: WebDriverWait =
//        new WebDriverWait(Driver.instance, Duration.ofSeconds(10), Duration.ofSeconds(1))
//      driverWait.until(
//        ExpectedConditions.elementToBeClickable(
//          Driver.instance.findElement(By.id(url))
//        )
//      )
//      verifyLinkById(url, text)
//    }
//  }

  // I provide some details for the economic crime levy return submission and experience a system timeout
  def whenIProvideSomeDetailsForTheEconomicCrimeLevyReturnSubmissionAndExperienceASystemTimeout(): Unit = {
    selectAccountingPeriod("Yes")
    onPage(UkRevenuePage.heading)
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
  }

  // I return to the service to complete the the return submission
  def andIReturnToTheServiceToCompleteTheTheReturnSubmission(): Unit =
    provideReturnSubmissionAfterTimeout()
      .submitPage()

  // I should be able to resume the submission from where I left off
  def andIShouldBeAbleToResumeTheSubmissionFromWhereILeftOff(): Unit =
    SharedActions
      .selectContinueWithSavedAnswers()
      .submitPage()

}
