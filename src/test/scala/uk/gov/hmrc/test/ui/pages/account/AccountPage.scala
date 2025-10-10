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

package uk.gov.hmrc.test.ui.pages.account

import io.cucumber.datatable.DataTable
import org.junit.Assert
import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.returns.ReturnsPage
import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

object AccountPage extends BasePage {

  val url =
    s"${TestConfiguration.url("economic-crime-levy-account-frontend")}/economic-crime-levy-account"

  val heading = "Your Economic Crime Levy account"

  def navigateTo(): this.type = {
    get(url)
    this
  }

  def startAndSignIn(): this.type = {
    submitPage()
    this
  }

  def provideEnrolmentDetails(enrolmentKey: String, identifierName: String, identifierValue: String): this.type = {
    sendKeys(By.id("enrolment[0].name"), enrolmentKey)
    sendKeys(By.id("input-0-0-name"), identifierName)
    sendKeys(By.id("input-0-0-value"), identifierValue)
    this
  }

  def provideSubmitAnEclReturn(): this.type = {
    SharedActions.clickById("submit-return")
    onPage(ReturnsPage.recent2backDueHeading)
    this
  }

  def provideSubmitAltEclReturn(): this.type = {
    SharedActions.clickById("submit-return")
    onPage(ReturnsPage.recent3backDueHeading)
    this
  }

  def provideViewOrAmendAnEclReturn(returnStatus: String): this.type = {
    SharedActions.clickById("view-returns")
    this
  }

  def validateReturnStatusDueBy(returnStatus: String): this.type = {
    returnStatus match {
      case "DUE"     =>
        SharedActions
          .assertTextByCssSelector(".govuk-tag--blue", returnStatus)
      case "OVERDUE" =>
        SharedActions
          .assertTextByCssSelector(".govuk-tag--red", returnStatus)
      case _         =>
        SharedActions
          .assertTextByCssSelector(".govuk-tag--green", returnStatus)
    }
    this
  }

  def provideViewEclPayment(paymentStatus: String): this.type = {
    SharedActions.clickById("view-payment-history")
    this
  }

  def validatePaymentStatusDueBy(paymentStatus: String): this.type = {
    paymentStatus match {
      case "DUE"            =>
        SharedActions
          .assertTextByCssSelector(".govuk-tag--blue", paymentStatus)
      case "OVERDUE"        =>
        SharedActions
          .assertTextByCssSelector(".govuk-tag--red", paymentStatus)
      case "PARTIALLY PAID" =>
        SharedActions
          .assertTextByCssSelector(".govuk-tag--yellow", paymentStatus)
      case _                =>
        SharedActions
          .assertTextByCssSelector(".govuk-tag--green", paymentStatus)
    }
    this
  }

  def assertPayAmountValue(paymentStatus: String, amount: String): this.type = {
    var actual = ""
    paymentStatus match {
      case "DUE"            =>
        actual = getText(By.cssSelector("td:nth-child(4)"))
      case "OVERDUE"        =>
        actual = getText(By.xpath("//td[contains(text(),'£20,500')]"))
      case "PARTIALLY PAID" =>
        actual = getText(By.xpath("//td[contains(text(),'£2,400')]"))
      case _                =>
        actual = getText(By.xpath("//td[contains(text(),'£14,000')]"))
    }

    val regex        = """([\d\.\,]+)""".r
    val actualAmount = BigDecimal(
      regex
        .findFirstMatchIn(actual)
        .get
        .group(1)
        .replaceAll(",", "")
    )
    assert(actualAmount.toString() == amount)
    this
  }

  def provideMakeAnEclPayment(paymentStatus: String): this.type = {
    SharedActions.clickById("make-payment")
    this
  }

  def provideSubmitReturn(): this.type = {
    SharedActions
      .clickLinkByPartialText("Submit return")
    this
  }
  def provideAmendSubmitReturn(): this.type = {
    SharedActions
      .clickLinkByPartialText("Amend return")
    this
  }

  def validateAmendReturnNumber(amendReturnNumber: String): this.type = {
    val returnNumber = getText(By.cssSelector(".govuk-table__cell.govuk-body"))
    assert(returnNumber.equals(amendReturnNumber))
    this
  }

  def provideAmendAnEclRegistration(): this.type = {
    SharedActions.clickById("amend-registration")
    this
  }

  def validateAmendRegistrationNumber(amendRegistrationNumber: String): this.type = {
    val registrationNumber = getText(By.cssSelector(".govuk-table__cell.govuk-body"))
    assert(registrationNumber.equals(amendRegistrationNumber))
    this
  }

  def assertAmountOfInterestOwed(interest: String, financialYear: String): this.type = {
    val amount                = getText(By.xpath("//td[contains(text(),'£4.84')]"))
    val expectedFinancialYear = getText(
      By.cssSelector("table:nth-child(2) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(3)")
    )

    assert(amount == interest)
    assert(expectedFinancialYear == financialYear)
    this
  }

  def assertPaymentHistoryForPartiallyPaidInterest(data: DataTable): this.type = {
    val paymentType   = data.column(1).get(0)
    val paymentPeriod = data.column(1).get(1)
    val amountPaid    = data.column(1).get(2)

    val actualPaymentType = getText(
      By.cssSelector("tbody tr:nth-child(2) td:nth-child(2)")
    )
    actualPaymentType should be(paymentType)
    val actualPaymentPeriod = getText(
      By.cssSelector("tbody tr:nth-child(2) td:nth-child(3)")
    )
    actualPaymentPeriod should be(paymentPeriod)
    val actualAmountPaid = getText(
      By.cssSelector("tbody tr:nth-child(2) td:nth-child(4)")
    )
    actualAmountPaid should be(amountPaid)
    val actualPaymentStatus = getText(
      By.cssSelector("tbody tr:nth-child(2) td:nth-child(5)")
    )
    Assert.assertTrue(actualPaymentStatus.equals(""))
    val actualActions       = getText(
      By.cssSelector("tbody tr:nth-child(2) td:nth-child(6)")
    )
    Assert.assertTrue(actualActions.equals(" "))
    this
  }

  def assertPaymentHistoryForFullyPaidInterest(data: DataTable): this.type = {
    val paymentDate   = data.column(1).get(0)
    val paymentType   = data.column(1).get(1)
    val paymentPeriod = data.column(1).get(2)
    val youPaidHmrc   = data.column(1).get(3)
    val paymentStatus = data.column(1).get(4)
    val actions       = data.column(1).get(5)

    val actualPaymentDate = getText(
      By.cssSelector("tr:nth-child(1) td:nth-child(1)")
    )
    actualPaymentDate should be(paymentDate)
    val actualPaymentType = getText(
      By.cssSelector("tr:nth-child(1) td:nth-child(2)")
    )
    actualPaymentType should be(paymentType)
    val actualPaymentPeriod = getText(
      By.cssSelector("tr:nth-child(1) td:nth-child(3)")
    )
    actualPaymentPeriod should be(paymentPeriod)
    val actualYouPaidHmrc = getText(
      By.cssSelector("tr:nth-child(1) td:nth-child(4)")
    )
    actualYouPaidHmrc should be(youPaidHmrc)
    val actualPaymentStatus = getText(
      By.cssSelector("tr:nth-child(1) td:nth-child(5)")
    )
    actualPaymentStatus should be(paymentStatus)
    val actualActions = getText(
      By.cssSelector("tr:nth-child(1) td:nth-child(6)")
    )
    actualActions should be(actions)
    this
  }

  def assertPaymentYouOweForOverdue(data: DataTable): this.type = {
    val paymentDate   = data.column(1).get(0)
    val paymentType   = data.column(1).get(1)
    val paymentPeriod = data.column(1).get(2)
    val youPaidHmrc   = data.column(1).get(3)
    val paymentStatus = data.column(1).get(4)
    val actions       = data.column(1).get(5)

    val actualPaymentDate = getText(
      By.cssSelector(".govuk-table__cell.govuk-table__header")
    )
    actualPaymentDate should be(paymentDate)
    val actualPaymentType = getText(
      By.cssSelector(" table:nth-child(2) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(2)")
    )
    actualPaymentType should be(paymentType)
    val actualPaymentPeriod = getText(
      By.cssSelector(" table:nth-child(2) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(3)")
    )
    actualPaymentPeriod should be(paymentPeriod)
    val actualYouPaidHmrc = getText(
      By.cssSelector("  table:nth-child(2) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(4)")
    )
    actualYouPaidHmrc should be(youPaidHmrc)
    val actualPaymentStatus = getText(
      By.cssSelector(" table:nth-child(2) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(5)")
    )
    actualPaymentStatus should be(paymentStatus)
    val actualActions = getText(
      By.cssSelector(" table:nth-child(2) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(6)")
    )
    actualActions should be(actions)
    this
  }

  def provideMakeAPayment(): this.type = {
    SharedActions.clickLinkByPartialText("Make a payment")
    this
  }
  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }
}
