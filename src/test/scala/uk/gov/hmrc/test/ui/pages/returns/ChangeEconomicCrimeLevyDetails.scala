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

import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

object ChangeEconomicCrimeLevyDetails extends BasePage {

  val cssForChangeAccountingPeriod: String           =
    "a[href='/submit-economic-crime-levy-return/change-answer/is-relevant-accounting-period-12-months']"
  val cssForChangeAccountingPeriodLength: String     =
    "a[href='/submit-economic-crime-levy-return/change-answer/relevant-accounting-period-length']"
  val cssForChangeUkRevenue: String                  =
    "a[href='/submit-economic-crime-levy-return/change-answer/uk-revenue-in-accounting-period']"
  val cssForChangeAmlRegulatedActivity: String       =
    "a[href='/submit-economic-crime-levy-return/change-answer/aml-regulated-activity']"
  val cssForChangeAmlRegulatedActivityLength: String =
    "a[href='/submit-economic-crime-levy-return/change-answer/aml-regulated-activity-days']"

  def changeAccountingPeriod(value: String): this.type = {
    clickByCssSelector(cssForChangeAccountingPeriod)
    ReturnsPage
      .selectAccountingPeriod(value)
      .provideAccountingPeriod("228")
    submitPage()
    onPage(CheckYourAnswersPage.heading)
    this
  }

  def changeAccountingPeriodLength(days: String): this.type = {
    clickByCssSelector(cssForChangeAccountingPeriodLength)
    ReturnsPage
      .provideAccountingPeriod(days)
    submitPage()
    onPage(CheckYourAnswersPage.heading)
    this
  }

  def changeUkRevenue(ukRevenue: String): this.type = {
    clickByCssSelector(cssForChangeUkRevenue)
    ReturnsPage
      .provideUkRevenue(ukRevenue)
    submitPage()
    onPage(CheckYourAnswersPage.heading)
    this
  }

  def ChangeAmlRegulatedActivity(value: String): this.type = {
    clickByCssSelector(cssForChangeAmlRegulatedActivity)
    ReturnsPage
      .selectAmlRegulatedActivity(value)
      .provideAmlRegulatedActivityDays("90")
    submitPage()
    onPage(CheckYourAnswersPage.heading)
    this
  }

  def ChangeAmlRegulatedActivityLength(days: String): this.type = {
    clickByCssSelector(cssForChangeAmlRegulatedActivityLength)
    ReturnsPage
      .provideAmlRegulatedActivityDays(days)
    submitPage()
    onPage(CheckYourAnswersPage.heading)
    this
  }

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }

}
