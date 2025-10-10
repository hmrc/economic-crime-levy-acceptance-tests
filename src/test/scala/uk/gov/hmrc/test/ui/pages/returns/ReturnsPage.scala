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

package uk.gov.hmrc.test.ui.pages.returns

import io.cucumber.datatable.DataTable
import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.utils.EclTaxYear
import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

import java.time.LocalDate

object ReturnsPage extends BasePage {

  //http://localhost:14002/submit-economic-crime-levy-return/period/23XY
  val url =
    s"${TestConfiguration.url("economic-crime-levy-returns-frontend")}/submit-economic-crime-levy-return/period/25XY"

  val eclTaxYear: EclTaxYear   = EclTaxYear.fromDate(LocalDate.now())
  val heading: String          =
    "Submit your Economic Crime Levy return for " + eclTaxYear.previous.startYear.toString + "-" + eclTaxYear.previous.finishYear.toString
  val recentDueHeading: String =
    "Submit your Economic Crime Levy return for " + eclTaxYear.startYear.toString + "-" + eclTaxYear.finishYear.toString
  val recent2backDueHeading: String =
    "Submit your Economic Crime Levy return for " + eclTaxYear.previous.previous.startYear.toString + "-" + eclTaxYear.previous.previous.finishYear.toString
  val recent3backDueHeading: String =
    "Submit your Economic Crime Levy return for " + eclTaxYear.previous.previous.previous.startYear.toString + "-" + eclTaxYear.previous.previous.previous.finishYear.toString


  def navigateTo(): this.type = {
    get(url)
    this
  }

  def startAndSignIn(): this.type = {
    submitPage()
    onPage(AccountingActivityPage.heading)
    this
  }

  def provideEnrolmentDetails(enrolmentKey: String, identifierName: String, identifierValue: String): this.type = {
    sendKeys(By.id("enrolment[0].name"), enrolmentKey)
    sendKeys(By.id("input-0-0-name"), identifierName)
    sendKeys(By.id("input-0-0-value"), identifierValue)
    this
  }

  def provideContactDetails(
    contactName: String,
    contactRole: String,
    emailAddress: String,
    contactNumber: String
  ): this.type = {
    onPage(ContactNamePage.heading)
    SharedActions.enterDetails(contactName)
    SharedActions.enterDetails(contactRole)
    SharedActions.enterDetails(emailAddress)
    SharedActions.enterDetails(contactNumber)
    onPage(CheckYourAnswersPage.heading)
    this
  }

  def provideUkRevenueInAccountingPeriod(value: String = "10200000"): this.type = {
    SharedActions.enterDetails(value)
    onPage(AmlRegulatedActivityPage.heading)
    this
  }
  def selectAmlRegulatedActivity(): this.type = {
    SharedActions
      .selectYesOrNo("Yes")
    onPage(AmountDuePage.heading)
    this
  }

  def selectAccountingPeriod(value: String): this.type = {
    SharedActions
      .selectYesOrNo(value)
    this
  }

  def provideAccountingPeriod(accountingPeriod: String): this.type = {
    SharedActions
      .enterDetails(accountingPeriod)
    this
  }

  def provideUkRevenue(ukRevenue: String): this.type = {
    SharedActions
      .enterDetails(ukRevenue)
    this
  }

  def selectAmlRegulatedActivity(value: String): this.type = {
    SharedActions
      .selectYesOrNo(value)
    this
  }

  def provideAmlRegulatedActivityDays(days: String): this.type = {
    SharedActions
      .enterDetails(days)
    this
  }

  def provideChangeContactDetails(
    name: String,
    role: String,
    emailAddress: String,
    contactNumber: String
  ): this.type = {
    ChangeContactDetails
      .changeContactName(name)
      .changeContactRole(role)
      .changeContactEmail(emailAddress)
      .changeContactTelephoneNumber(contactNumber)
    this
  }

  def provideChangeAccountingPeriod(value: String): this.type = {
    ChangeEconomicCrimeLevyDetails
      .changeAccountingPeriod(value)
    this
  }

  def provideChangeAccountingPeriodLength(days: String): this.type = {
    ChangeEconomicCrimeLevyDetails
      .changeAccountingPeriodLength(days)
    this
  }

  def provideChangeUkRevenue(ukRevenue: String): this.type = {
    ChangeEconomicCrimeLevyDetails
      .changeUkRevenue(ukRevenue)
    this
  }

  def provideChangeAmlRegulatedActivity(value: String): this.type = {
    ChangeEconomicCrimeLevyDetails
      .ChangeAmlRegulatedActivity(value)
    this
  }

  def provideChangeAmlRegulatedActivityLength(days: String): this.type = {
    ChangeEconomicCrimeLevyDetails
      .ChangeAmlRegulatedActivityLength(days)
    this
  }

  def provideAmountDue(): this.type = {
    onPage(AmountDuePage.heading)
    submitPage()
    this
  }

  def provideCheckYourAnswers(): this.type = {
    submitPage()
    this
  }

  def provideUkRevenueForNilReturnSubmission(value: String = "1019999"): this.type = {
    SharedActions.enterDetails(value)
    this
  }

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }

  def assertEclReturnNumber(value: String): this.type = {
    val actual = getText(
      By.xpath(s"//p[contains(text(),'ECL return number')]")
    )
    assert(actual.contains(value))
    this
  }

  def assertAmountNeedToPay(value: String): this.type = {
    val actual = getText(
      By.xpath(s"//p[contains(text(),'Amount you need to pay')]")
    )
    assert(actual.contains(value))
    this
  }

  def assertAmendedReturnAnswers(data: DataTable): this.type = {
    val returnCompletedBy = data.column(1).get(0)
    val role              = data.column(1).get(1)
    val emailAddress      = data.column(1).get(2)
    val telephoneNumber   = data.column(1).get(3)

    val actualReturnCompletedBy = getText(
      By.cssSelector("dl:nth-child(8) > div:nth-child(1) > dd:nth-child(2)")
    )
    actualReturnCompletedBy should be(returnCompletedBy)

    val actualRole = getText(
      By.cssSelector("dl:nth-child(8) > div:nth-child(2) > dd:nth-child(2)")
    )
    actualRole should be(role)

    val actualEmailAddress = getText(
      By.cssSelector("dl:nth-child(8) > div:nth-child(3) > dd:nth-child(2)")
    )
    actualEmailAddress should be(emailAddress)

    val actualTelephoneNumber = getText(
      By.cssSelector("dl:nth-child(8) > div:nth-child(4) > dd:nth-child(2)")
    )
    actualTelephoneNumber should be(telephoneNumber)

    this
  }

  def provideReturnSubmissionAfterTimeout(): this.type = {
    SharedActions
      .clickLinkByPartialText("Submit your Economic Crime Levy return")
    this
  }
}
