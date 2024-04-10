/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.pages.deregistration

import org.junit.Assert
import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

object DeRegistrationPage extends BasePage {

  val url =
    s"${TestConfiguration.url("economic-crime-levy-registration-frontend")}/register-for-economic-crime-levy/deregister-start"
  val heading = "Request to deregister from HMRC for the Economic Crime Levy"
  def navigateTo(): this.type = {
    get(url)
    this
  }

  def ProvideViewEclAccountAfterDeRegistration(linkName: String = "Payments"): this.type = {
    linkName match {
      case "Returns" =>
        SharedActions
          .clickById("view-returns")
      case _ =>
        SharedActions
          .clickById("view-payment-history")
    }
    this
  }

  def getPaymentAndReturnLinks(linkName: String = "Returns"): this.type = {
    linkName match {
      case "Payments" =>
        val paymentElements = driver.findElements(By.linkText("Make a payment"))
        Assert.assertTrue(paymentElements. size() > 0)

        val elements = driver.findElements(By.linkText("Request a refund"))
        Assert.assertTrue(elements. size() > 0)
      case _ =>
        val amendElements = driver.findElements(By.linkText("Amend return"))
        Assert.assertTrue(amendElements. size() > 0)
    }
    this
  }

  def provideEclDeRegistration(): this.type = {
    SharedActions.clickById("deregister")
    onPage(DeRegistrationPage.heading)
    this
  }

  def provideReasonForDeRegistering(value: String = "value_0"): this.type = {
    value match {
      case "value_1" =>
        SharedActions
          .clickById("value_1")
      case "value_2" =>
        SharedActions
          .clickById("value_2")
      case _ =>
        SharedActions
          .clickById("value_0")
    }
    onPage(ReasonForDeRegistrationPage.heading)
    submitPage()
    this
  }

  def provideEclDeRegistrationDate(
    deRegistrationDate: String,
    deRegistrationMonth: String,
    deRegistrationYear: String ): this.type = {
    onPage(DeRegisterDateNoLongerLiablePage.heading)
    sendKeys(By.id("value.day"), deRegistrationDate)
    sendKeys(By.id("value.month"), deRegistrationMonth)
    sendKeys(By.id("value.year"), deRegistrationYear)
    submitPage()
    this
  }

  def provideDeRegistrationFirstContactDetails(
    contactName: String,
    contactRole: String,
    emailAddress: String,
    contactNumber: String): this.type = {
    SharedActions.enterDetails(contactName)
    SharedActions.enterDetails(contactRole)
    SharedActions.enterDetails(emailAddress)
    SharedActions.enterDetails(contactNumber)
    this
  }
  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }
}
