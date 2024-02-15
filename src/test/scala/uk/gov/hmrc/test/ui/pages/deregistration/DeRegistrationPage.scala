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
import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

import scala.jdk.CollectionConverters.CollectionHasAsScala

object DeRegistrationPage extends BasePage {

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

  def paymentAndReturnLinkName : List[String] =
    List(
      s"Amend Return",
      s"Make a payment"
    )

  def getPaymentAndReturnLinks(linkName: String = "Returns"): this.type = {
    linkName match {
      case "Payments" =>
        lazy val textElements = driver.findElements(By.cssSelector("td:nth-child(6)"))
        paymentAndReturnLinkName.foreach(linkName =>
          Assert.assertFalse(textElements.asScala.exists(_.getText.contentEquals(linkName))))
      case _ =>
        lazy val textElements = driver.findElements(By.cssSelector("td:nth-child(4)"))
        paymentAndReturnLinkName.foreach(linkName =>
          Assert.assertFalse(textElements.asScala.exists(_.getText.contentEquals(linkName))))
    }
    this
  }

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }
}
