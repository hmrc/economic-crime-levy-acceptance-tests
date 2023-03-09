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

import uk.gov.hmrc.test.ui.pages.SharedActions
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
      .startAndSignIn()
  }

  When("""I provide the details to submit the economic crime levy return""") { () =>
    selectAccountingPeriod("Yes")
    onPage(UkRevenuePage.heading)
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .submitPage()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
  }

  And("^I enter the contact person's name (.*) for completing my ECL return$") { (contactName: String) =>
    ContactNamePage
      .navigateTo()
      .provideContactName(contactName)
    confirmUrl(ContactNamePage.url)

  }

  And("^I enter the contact person's role (.*) for completing my ECL return$") { (contactRole: String) =>
    ContactNamePage
      .navigateTo()
      .provideContactName("James")
    ContactRolePage
      .provideContactRole(contactRole)
    confirmUrl(ContactRolePage.url)
  }

  And("^I enter the contact person's email address (.*) for completing my ECL return$") { (emailAddress: String) =>
    ContactNamePage
      .navigateTo()
      .provideContactName("Tom")
      ContactRolePage
        .provideContactRole("Account Director")
      ContactEmailAddressPage
        .provideContactEmailAddress(emailAddress)
    confirmUrl(ContactEmailAddressPage.url)
  }

  When("^I enter the contact person's contact number (.*) for completing my ECL return$") { (contactNumber: String) =>
    ContactNamePage
      .navigateTo()
      .provideContactName("Paul")
    ContactRolePage
        .provideContactRole("Account Manager")
    ContactEmailAddressPage
        .provideContactEmailAddress("verify@test.com")
    ContactTelephonePage
        .provideContactNumber(contactNumber)
    confirmUrl(ContactTelephonePage.url)
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

  When("^I do not enter the length of my accounting period") { () =>
    AccountingPeriodPage
      .navigateTo()
      .submitPage()
  }

  When("^I enter the length of my relevant accounting period as (.*) days$") { (accountingPeriod: String) =>
    AccountingPeriodPage
      .navigateTo()
    provideAccountingPeriod(accountingPeriod)
  }
  When("^I enter the UK revenue (.*) for my relevant accounting period$") { (ukRevenue: String) =>
    UkRevenuePage
      .navigateTo()
    provideUkRevenue(ukRevenue)
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

  When("^I enter the total number of days (.*) I carried out AML regulated activity$") { (days: String) =>
    AmlRegulatedActivityDaysPage
      .navigateTo()
    provideAmlRegulatedActivityDays(days)
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

  And("I go to the return submission check your answers page directly without providing answers for any of the previous page questions") {
    () =>
      CheckYourAnswersPage
        .navigateTo()
  }

  When("I click on the change link to modify my contact details") { () =>
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .submitPage()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeContactDetails("James Bond 007", "Compliance Officer", "verify@oc.com", "014753777777")
  }

  When("I click on the change link to modify my economic crime levy accounting period") { () =>
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .submitPage()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeAccountingPeriod("No")
  }

  When("I click on the change link to modify my accounting period length") { () =>
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .submitPage()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeAccountingPeriod("No")
      .provideChangeAccountingPeriodLength("364")
  }

  When("I click on the change link to modify my uk revenue") { () =>
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .submitPage()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeUkRevenue("20200000")
  }

  When("I click on the change link to modify my AML-regulated activity for the full financial year") { () =>
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .submitPage()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeAmlRegulatedActivity("No")
  }

  When("I click on the change link to modify my AML-regulated activity length") { () =>
    selectAccountingPeriod("Yes")
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .selectAmlRegulatedActivity()
      .submitPage()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideChangeAmlRegulatedActivity("No")
      .provideChangeAmlRegulatedActivityLength("291")

  }

  Then("^I should be see the amount of ECL need to pay (.*)$") { (value: String) =>
    SharedActions
      .validateLevyAmount(value)
  }
}
