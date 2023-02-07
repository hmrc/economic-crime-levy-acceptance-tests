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

package uk.gov.hmrc.test.ui.pages.registration

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

object ChangeOrganisationDetails extends BasePage {

  val cssForChangeBusinessSector: String       =
    "a[href='/register-for-the-economic-crime-levy/change-answer/what-is-your-business-sector']"
  val cssForChangeAmlSupervisor: String        =
    "a[href='/register-for-the-economic-crime-levy/change-answer/who-is-your-aml-supervisor']"
  val cssForChangeUkRevenue: String            =
    "a[href='/register-for-the-economic-crime-levy/change-answer/uk-revenue-for-accounting-period']"
  val cssForChangeAccountingPeriod: String     =
    "a[href='/register-for-the-economic-crime-levy/change-answer/is-relevant-accounting-period-12-months']"
  val cssForChangeAmlRegulatedActivity: String =
    "a[href='/register-for-the-economic-crime-levy/change-answer/did-you-carry-out-aml-regulated-activity']"
  val cssForChangeEntityType: String           =
    "a[href='/register-for-the-economic-crime-levy/change-answer/what-is-your-entity-type']"

  def changeBusinessSector(): this.type = {
    clickByCssSelector(cssForChangeBusinessSector)
    SharedActions
      .selectLabelByPartialText("Insolvency practitioner")
    submitPage()
    this
  }

  def changeAmlSupervisor(): this.type = {
    clickByCssSelector(cssForChangeAmlSupervisor)
    RegistrationPage
      .provideHmrcOrOtherAmlSupervisor("Other")
    this
  }

  def changeUkRevenue(): this.type = {
    clickByCssSelector(cssForChangeUkRevenue)
    SharedActions
      .enterDetails("30200000")
    submitPage()
    this
  }

  def changeAccountingPeriod(): this.type = {
    clickByCssSelector(cssForChangeAccountingPeriod)
    SharedActions
      .selectYesOrNo()
      .submitPage()
      .enterDetails("123")
    submitPage()
    SharedActions
      .enterDetails("20200000")
    submitPage()
    this
  }

  def changeAmlRegulatedActivity(): this.type = {
    clickByCssSelector(cssForChangeAmlRegulatedActivity)
    SharedActions
      .selectYesOrNo()
      .submitPage()
    this
  }

  def changeEntityType(): this.type = {
    clickByCssSelector(cssForChangeEntityType)
    SharedActions
      .selectLabelByPartialText("Scottish limited partnership")
    submitPage()
      .submitPage()
    this
  }

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }
}
