/*
 * Copyright 2023 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.datatable.DataTable
import uk.gov.hmrc.test.ui.pages.SharedActions
import uk.gov.hmrc.test.ui.pages.account.AccountPage
import uk.gov.hmrc.test.ui.pages.returns.ReturnsPage._
import uk.gov.hmrc.test.ui.pages.returns._

class ReturnsStepDef extends BaseStepDef {

  Given("""I am signed in to the return journey""") { () =>
    ReturnsPage
      .navigateTo()
      .provideEnrolmentDetails(
        enrolmentKey = "HMRC-ECL-ORG",
        identifierName = "EclRegistrationReference",
        identifierValue = "XMECL0000000001"
      )
      .submitPage()
    onPage(ReturnsPage.heading)
    ReturnsPage
      .startAndSignIn()
  }

  When("""I provide the details to submit the economic crime levy return""") { () =>
    selectAccountingPeriod("Yes")
    onPage(UkRevenuePage.heading)
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideCheckYourAnswers()
  }

  When("^I do not select an option for my relevant accounting period 12 months") { () =>
    AccountingActivityPage
      .navigateTo()
      .submitPage()
  }
  When("^I select (.*) option for my relevant accounting period 12 months$") { (value: String) =>
    AccountingActivityPage
      .navigateTo()
    selectAccountingPeriod(value)
    onPage(AccountingPeriodPage.heading)
  }

  When(
    """I do not select an option for whether or not I carry out AML-regulated activity for the full financial year?"""
  ) { () =>
    AmlRegulatedActivityPage
      .navigateTo()
      .submitPage()
  }

  When("^I select (.*) option for my AML-regulated activity for the full financial year$") { (value: String) =>
    AmlRegulatedActivityPage
      .navigateTo()
    selectAmlRegulatedActivity(value)
    onPage(AmlRegulatedActivityDaysPage.heading)
  }

  When(
    "^I enter 12 month accounting period revenue (.*) and select (.*) for my AML-regulated activity for the full financial year$"
  ) { (ukRevenue: String, value: String) =>
    selectAccountingPeriod("Yes")
    onPage(UkRevenuePage.heading)
    ReturnsPage
      .provideUkRevenue(ukRevenue)
    onPage(AmlRegulatedActivityPage.heading)
    ReturnsPage
      .selectAmlRegulatedActivity(value)
  }

  And("^I enter the number of days (.*) I carried out AML regulated activity during the financial year$") {
    (days: String) =>
      provideAmlRegulatedActivityDays(days)
      onPage(AmountDuePage.heading)
  }

  When("^I select (.*) for my accounting period 12 months and enter the length of my accounting period as (.*) days$") {
    (value: String, days: String) =>
      selectAccountingPeriod(value)
      onPage(AccountingPeriodPage.heading)
      ReturnsPage
        .provideAmlRegulatedActivityDays(days)
      onPage(UkRevenuePage.heading)
  }

  When(
    "^I enter my UK revenue (.*) for the accounting period and select (.*) for my AML-regulated activity for the full financial year$"
  ) { (ukRevenue: String, value: String) =>
    provideUkRevenue(ukRevenue)
    onPage(AmlRegulatedActivityPage.heading)
    ReturnsPage
      .selectAmlRegulatedActivity(value)
  }

  And(
    "I go to the return submission check your answers page directly without providing answers for any of the previous page questions"
  ) { () =>
    CheckYourAnswersPage
      .navigateTo()
  }

  When("I click on the change link to modify my contact details") { () =>
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeContactDetails("James Bond 007", "Compliance Officer", "verify@oc.com", "014753777777")
  }

  When("I click on the change link to modify my economic crime levy accounting period") { () =>
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeAccountingPeriod("No")
      .submitPage()
  }

  When("I click on the change link to modify my accounting period length") { () =>
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeAccountingPeriod("No")
      .provideChangeAccountingPeriodLength("364")
  }

  When("I click on the change link to modify my uk revenue") { () =>
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeUkRevenue("20200000")
      .submitPage()
  }

  When("I click on the change link to modify my AML-regulated activity for the full financial year") { () =>
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeAmlRegulatedActivity("No")
  }

  When("I click on the change link to modify my AML-regulated activity length") { () =>
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeAmlRegulatedActivity("No")
      .provideChangeAmlRegulatedActivityLength("291")

  }

  Then("^I should be see the amount of ECL need to pay (.*)$") { (value: String) =>
    SharedActions
      .validateLevyAmount(value)
  }

  When("^I enter 12 month accounting period revenue is (.*) that falls in the small band size$") {
    (ukRevenue: String) =>
      selectAccountingPeriod("Yes")
        .provideUkRevenue(ukRevenue)
  }

  When(
    "I click on the change link to edit my uk revenue from amount due page and select (.*) for my AML-regulated activity for the full financial year$"
  ) { (value: String) =>
    selectAccountingPeriod("Yes")
      .provideUkRevenue("10199999")
      .provideChangeUkRevenue("20200000")
      .selectAmlRegulatedActivity(value)
  }

  When(
    "I click on the change link to edit my accounting period and select (.*) for my AML-regulated activity for the full financial year$"
  ) { (value: String) =>
    selectAccountingPeriod("Yes")
      .provideUkRevenue("10199999")
      .provideChangeAccountingPeriod("No")
      .selectAmlRegulatedActivity(value)
  }

  Then("^I should see my ecl return number is (.*) and the amount to pay is (.*)$") {
    (eclReturnNumber: String, amountToPay: String) =>
      ReturnsPage
        .assertEclReturnNumber(eclReturnNumber)
        .assertAmountNeedToPay(amountToPay)
  }

  When("I enter the information required to calculate the amount due") { () =>
    selectAccountingPeriod("Yes")
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
  }

  When("""I provide the details for a return submission""") { () =>
    selectAccountingPeriod("Yes")
      .provideUkRevenueForNilReturnSubmission()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideCheckYourAnswers()
  }

  Then("^I should see the amount to pay is (.*)$") { (amountToPay: String) =>
    SharedActions
      .assertTextByCssSelector(".govuk-label--m", amountToPay)
  }

  When("""I provide the details to amend the submitted economic crime levy return""") { () =>
    AccountPage
      .provideViewOrAmendAnEclReturn("amend")
      .provideAmendSubmitReturn()
    SharedActions
      .enterDetails("Revenue Changed in the current FY ")
    ReturnsPage
      .provideChangeContactDetails("James Bond 007", "Compliance Officer", "verify@oc.com", "014753777777")
  }
  And("""the amended return information should display under Amended answers on the Check your answers page$""") {
    (arg: DataTable) => assertAmendedReturnAnswers(arg)
      .submitPage()
  }

  When("""I provide some details for the economic crime levy return submission and experience a system timeout""") { () =>
    selectAccountingPeriod("Yes")
    onPage(UkRevenuePage.heading)
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .provideAmountDue()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
  }

  And("""I return to the service to complete the the return submission""") { () =>
      provideReturnSubmissionAfterTimeout()
        .submitPage()
  }

  And("""I should be able to resume the submission from where I left off""") { () =>
    SharedActions
        .selectContinueWithSavedAnswers()
        .submitPage()
  }

}
