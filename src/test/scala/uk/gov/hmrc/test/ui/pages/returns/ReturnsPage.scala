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

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

object ReturnsPage extends BasePage {

  val url =
    s"${TestConfiguration.url("economic-crime-levy-returns-frontend")}/submit-economic-crime-levy-return/period/22XY"

  val heading = "Submit your Economic Crime Levy return for 2022-2023"

  def navigateTo(): this.type = {
    navigateToClearAllUrl()
    driver.get(url)
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
    SharedActions.enterDetails(contactName)
    submitPage()
    SharedActions.enterDetails(contactRole)
    submitPage()
    SharedActions.enterDetails(emailAddress)
    submitPage()
    SharedActions.enterDetails(contactNumber)
    submitPage()
    onPage(CheckYourAnswersPage.heading)
    this
  }

  def provideUkRevenueInAccountingPeriod(value: String = "10200000"): this.type = {
    SharedActions.enterDetails(value)
    submitPage()
    onPage(AmlRegulatedActivityPage.heading)
    this
  }
  def selectAmlRegulatedActivity(): this.type = {
    SharedActions
      .selectYesOrNo("Yes")
      .submitPage()
    onPage(AmountDuePage.heading)
    this
  }

  def selectAccountingPeriod(value: String): this.type = {
    SharedActions
      .selectYesOrNo(value)
      .submitPage()
    this
  }

  def provideAccountingPeriod(accountingPeriod: String): this.type = {
    SharedActions
      .enterDetails(accountingPeriod)
    submitPage()
    this
  }

  def provideUkRevenue(ukRevenue: String): this.type = {
    SharedActions
      .enterDetails(ukRevenue)
    submitPage()
    this
  }

  def selectAmlRegulatedActivity(value: String): this.type = {
    SharedActions
      .selectYesOrNo(value)
      .submitPage()
    this
  }

  def provideAmlRegulatedActivityDays(days: String): this.type = {
    SharedActions
      .enterDetails(days)
    submitPage()
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
    submitPage()
    this
  }

  def provideCheckYourAnswers(): this.type = {
    submitPage()
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
}
