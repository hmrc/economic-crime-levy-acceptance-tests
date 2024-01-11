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

package uk.gov.hmrc.test.ui.pages.enrolment

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

object EnrolmentPage extends BasePage {

  val url =
    s"${TestConfiguration.url("economic-crime-levy-enrolment-frontend")}/add-economic-crime-levy/do-you-have-an-ecl-reference-number/"

  val heading = "Do you have an Economic Crime Levy (ECL) reference number?"

  def navigateTo(): this.type = {
    navigateToClearAllUrl()
    driver.get(url)
    this
  }

  def startAndSignIn(): this.type = {
    submitPage()
    onPage(EnrolmentPage.heading)
    this
  }

  def selectEclReferenceNumber(value: String = "Unknown"): this.type = {
    value match {
      case "Yes"     =>
        SharedActions
          .selectYesOrNo("Yes")
        onPage(EnrolmentReferenceNumberPage.heading)
      case "No"      =>
        SharedActions
          .selectYesOrNo("No")
        onPage(EnrolmentRegisterECLPage.heading)
      case "Unknown" =>
        SharedActions.clickById("value_2")
        submitPage()
        onPage(FindEclReferenceNumberPage.heading)
    }
    this
  }

  def selectUnknownEclReferenceNumber(): this.type =
    this

  def provideEclReferenceNumber(eclReferenceNumber: String): this.type = {
    SharedActions
      .enterDetails(eclReferenceNumber)
    onPage(EnrolmentRegistrationDatePage.heading)
    this
  }

  def provideEclRegistrationDate(
    registrationDate: String,
    registrationMonth: String,
    registrationYear: String
  ): this.type = {
    sendKeys(By.id("value.day"), registrationDate)
    sendKeys(By.id("value.month"), registrationMonth)
    sendKeys(By.id("value.year"), registrationYear)
    submitPage()
    this
  }

  def provideInvalidEclReferenceNumber(eclReferenceNumber: String): this.type = {
    EnrolmentReferenceNumberPage
      .navigateTo()
    SharedActions
      .enterDetails(eclReferenceNumber)
    this
  }

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }
}
