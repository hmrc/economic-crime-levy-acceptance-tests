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

import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

object RegistrationPage extends BasePage {

  val url =
    s"${TestConfiguration.url("economic-crime-levy-registration-frontend")}/register-for-the-economic-crime-levy/"

  def navigateTo(): this.type = {
    navigateToClearAllUrl()
    driver.get(url)
    this
  }

  def startAndSignIn(): this.type = {
    submitPage()
    SharedActions.clickById("submit-top")
    onPage(UkRevenuePage.heading)
    this
  }

  def provideUkRevenue(value: String = "Equal to or more than £10.2 million"): this.type = {
    SharedActions.selectLabelByPartialText(value)
    submitPage()
    onPage(AmlSupervisorPage.heading)
    this
  }

  def provideHmrcOrOtherAmlSupervisor(value: String = "HMRC"): this.type = {
    value match {
      case "Other" =>
        SharedActions.selectLabelByPartialText("Other")
        SharedActions.clickById("otherProfessionalBody")
        SharedActions.clickById("otherProfessionalBody__option--0")
      case _       =>
        SharedActions.selectLabelByPartialText(value)
    }

    submitPage()
    onPage(EntityTypePage.heading)
    this
  }

  def provideEntityType(value: String): this.type = {
    SharedActions.selectLabelByPartialText(value)
    submitPage()
    onPage(StubGRSJourneyDataPage.heading)
    this
  }

  def provideGrsData(): this.type = {
    submitPage()
    onPage(AmlActivityPage.heading)
    this
  }

  def provideAmlRegulated(): this.type = {
    SharedActions
      .selectYesOrNo()
      .submitPage()
    onPage(BusinessSectorPage.heading)
    this
  }

  def provideBusinessSector(value: String): this.type = {
    SharedActions.selectLabelByPartialText(value)
    submitPage()
    onPage(FirstContactNamePage.heading)
    this
  }

  def provideFirstContactDetails(
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
    onPage(SecondContactNamePage.heading)
    this
  }

  def provideSecondContactDetails(
    contactName: String,
    contactRole: String,
    emailAddress: String,
    contactNumber: String
  ): this.type = {
    SharedActions
      .selectYesOrNo("Yes")
      .submitPage()
    SharedActions.enterDetails(contactName)
    submitPage()
    SharedActions.enterDetails(contactRole)
    submitPage()
    SharedActions.enterDetails(emailAddress)
    submitPage()
    SharedActions.enterDetails(contactNumber)
    submitPage()
    this
  }

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }

}
