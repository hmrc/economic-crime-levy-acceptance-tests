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

import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

object ChangeOrganisationDetails extends BasePage {

  val cssForChangeBusinessSector: String       =
    "a[href='/register-for-economic-crime-levy/change-answer/what-is-your-business-sector']"
  val cssForChangeAmlSupervisor: String        =
    "a[href='/register-for-economic-crime-levy/change-answer/your-aml-supervisor']"
  val cssForChangeUkRevenue: String            =
    "a[href='/register-for-economic-crime-levy/change-answer/uk-revenue']"
  val cssForChangeAccountingPeriod: String     =
    "a[href='/register-for-economic-crime-levy/change-answer/accounting-period-question']"
  val cssForChangeAmlRegulatedActivity: String =
    "a[href='/register-for-economic-crime-levy/change-answer/aml-regulated-activity-question']"
  val cssForChangeEntityType: String           =
    "a[href='/register-for-economic-crime-levy/change-answer/what-is-your-entity-type']"
  val cssForSaveAndContinue                    = "button[class='govuk-button']"

  def changeBusinessSector(): this.type = {
    clickByCssSelector(cssForChangeBusinessSector)
    SharedActions
      .selectLabelByPartialText("Insolvency practitioner")
    submitPage()
    this
  }

  def changeAmlSupervisor(): this.type = {
    clickByCssSelector(cssForChangeAmlSupervisor)
    SharedActions
      .selectLabelByPartialText("Other")
    SharedActions
      .clickById("otherProfessionalBody")
    SharedActions
      .clickById("otherProfessionalBody__option--4")
    submitPage()
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
    clickByCssSelector(cssForSaveAndContinue)
//      .submitPage()
    this
  }

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }
}
