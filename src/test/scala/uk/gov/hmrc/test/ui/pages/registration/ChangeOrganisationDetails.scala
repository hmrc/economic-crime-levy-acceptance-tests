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

import uk.gov.hmrc.test.ui.cucumber.stepdefs.BaseStepDef
import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

object ChangeOrganisationDetails extends BasePage with BaseStepDef {

  val cssForChangeBusinessSector: String       =
    "a[href='/register-for-economic-crime-levy/change-answer/what-is-your-business-sector']"
  val cssForChangeAmlSupervisor: String        =
    "a[href='/register-for-economic-crime-levy/change-answer/your-aml-supervisor/Initial']"
  val cssForChangeUkRevenue: String            =
    "a[href='/register-for-economic-crime-levy/change-answer/uk-revenue-in-accounting-period']"
  val cssForChangeAccountingPeriod: String     =
    "a[href='/register-for-economic-crime-levy/change-answer/accounting-period-question']"
  val cssForChangeAmlRegulatedActivity: String =
    "a[href='/register-for-economic-crime-levy/change-answer/aml-regulated-activity-question']"
  val cssForChangeEntityType: String           =
    "a[href='/register-for-economic-crime-levy/change-answer/what-is-your-entity-type']"
  val cssForChangeLiabilityStartDate: String   =
    "a[href='/register-for-economic-crime-levy/change-answer/liability-start-date']"
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
    this
  }

  def changeAccountingPeriod(): this.type = {
    clickByCssSelector(cssForChangeAccountingPeriod)
    SharedActions
      .selectYesOrNo()
      .enterDetails("123")
    SharedActions
      .enterDetails("20200000")
    this
  }

  def changeAmlRegulatedActivity(): this.type = {
    clickByCssSelector(cssForChangeAmlRegulatedActivity)
    SharedActions
      .selectYesOrNo()
    this
  }

  def changeEntityType(): this.type = {
    clickByCssSelector(cssForChangeEntityType)
    SharedActions
      .selectLabelByPartialText("Scottish limited partnership")
    submitPage()
    clickByCssSelector(cssForSaveAndContinue)
    this
  }

  def changeLiabilityStartDate(): this.type = {
    clickByCssSelector(cssForChangeLiabilityStartDate)
    RegistrationPage
      .provideEclLiabilityDate(
        liabilityStartDate = now.getDayOfMonth.toString,
        liabilityStartMonth = now.getMonthValue.toString,
        liabilityStartYear = now.getYear.toString
      )
//    submitPage()
    this
  }
  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }
}
