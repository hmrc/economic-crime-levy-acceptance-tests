/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.specsteps

import uk.gov.hmrc.test.ui.specpage.account.AccountPage._
import uk.gov.hmrc.test.ui.specpage.account._
import uk.gov.hmrc.test.ui.specpage.returns.ReturnsPage
import java.time.LocalDate

object AccountStepDefSteps {

  // I am signed in to the account journey with my ECL reference as (.*)$
  def givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX(eclReference: String): Unit =
    AccountPage
      .navigateTo()
      .provideEnrolmentDetails(
        enrolmentKey = "HMRC-ECL-ORG",
        identifierName = "EclRegistrationReference",
        identifierValue = eclReference
      )
      .startAndSignIn()

  // I am on the ECL account dashboard
  def whenIAmOnTheECLAccountDashboard(): Unit =
    onPage(AccountPage.heading)

  // I click on the Submit an Economic Crime Levy return link
  def whenIClickOnTheSubmitAnEconomicCrimeLevyReturnLink(): Unit = {
    if (LocalDate.now().getMonthValue >= 8) {
      provideSubmitAnEclReturn()
    } else {
      provideSubmitAltEclReturn()
    }
    submitPage()
  }

  // I click on the View or amend your returns link to view the (DUE|OVERDUE|SUBMITTED) return details$
  def whenIClickOnTheViewOrAmendYourReturnsLinkToViewTheReturnDetails(returnStatus: String): Unit =
    provideViewOrAmendAnEclReturn(returnStatus)

  // I should see the return status as (.*)$
  def whenIShouldSeeTheReturnStatusAsX(returnStatus: String): Unit =
    validateReturnStatusDueBy(returnStatus)

  // I provide the registration details to submit a return through ECL dashboard link$
  def whenIProvideTheRegistrationDetailsToSubmitAReturnThroughECLDashboardLink(): Unit =
    provideViewOrAmendAnEclReturn("DUE")
      .provideSubmitReturn()

  // I click on the View your payments link to view the (DUE|OVERDUE|PARTIALLY PAID|PAID) payment details$
  def whenIClickOnTheViewYourPaymentsLinkToViewThePaymentDetails(paymentStatus: String): Unit =
    provideViewEclPayment(paymentStatus)

  // I should see the payment status as (.*)$
  def whenIShouldSeeThePaymentStatusAsX(paymentStatus: String): Unit =
    validatePaymentStatusDueBy(paymentStatus)

  // I should see the (.*) payment amount (.*)$
  def andIShouldSeeTheXPaymentAmountX(paymentStatus: String, amount: String): Unit =
    assertPayAmountValue(paymentStatus, amount)

  // I click on the Make an ECL payment link to pay the (DUE|OVERDUE) payment$
  def whenIClickOnTheMakeAnECLPaymentLinkToPayThePayment(paymentStatus: String): Unit =
    provideMakeAnEclPayment(paymentStatus)

  // I click on the View your payments link to view my (.*)$
  def whenIClickOnTheViewYourPaymentsLinkToViewMyX(paymentStatus: String): Unit =
    provideViewEclPayment(paymentStatus)

  // I click on the View your payments link
  def andIClickOnTheViewYourPaymentsLink(): Unit =
    paymentHistoryLink()

  // the interest row should display the partial interest payment information under Payments you owe$
  def thenTheInterestRowShouldDisplayThePartialInterestPaymentInformationUnderPaymentsYouOwe(
    arg: Map[String, String]
  ): Unit =
    assertPaymentHistoryForPartiallyPaidInterest(arg)

  // Overload for ScalaTest (no DataTable, accepts varargs)
//  def thenTheInterestRowShouldDisplayThePartialInterestPaymentInformationUnderPaymentsYouOwe(links: (String, String)*): Unit = {
//    links.foreach { case (text, url) =>
//      val driverWait: WebDriverWait =
//        new WebDriverWait(Driver.instance, Duration.ofSeconds(10), Duration.ofSeconds(1))
//      driverWait.until(
//        ExpectedConditions.elementToBeClickable(
//          Driver.instance.findElement(By.id(url))
//        )
//      )
//      verifyLinkById(url, text)
//    }
  // }

  // the interest row should display the fully paid interest payment information under Payment History$
  def thenTheInterestRowShouldDisplayTheFullyPaidInterestPaymentInformationUnderPaymentHistory(
    arg: Map[String, String]
  ): Unit =
    assertPaymentHistoryForFullyPaidInterest(arg)

  // Overload for ScalaTest (no DataTable, accepts varargs)
//  def thenTheInterestRowShouldDisplayTheFullyPaidInterestPaymentInformationUnderPaymentHistory(links: (String, String)*): Unit = {
//    links.foreach { case (text, url) =>
//      val driverWait: WebDriverWait =
//        new WebDriverWait(Driver.instance, Duration.ofSeconds(10), Duration.ofSeconds(1))
//      driverWait.until(
//        ExpectedConditions.elementToBeClickable(
//          Driver.instance.findElement(By.id(url))
//        )
//      )
//      verifyLinkById(url, text)
//    }
//  }

  // the overdue row should display the overdue payment information under Payment you owe$
  def thenTheOverdueRowShouldDisplayTheOverduePaymentInformationUnderPaymentYouOwe(arg: Map[String, String]): Unit =
    assertPaymentYouOweForOverdue(arg)

  // Overload for ScalaTest (no DataTable, accepts varargs)
//  def thenTheOverdueRowShouldDisplayTheOverduePaymentInformationUnderPaymentYouOwe(links: (String, String)*): Unit = {
//    links.foreach { case (text, url) =>
//      val driverWait: WebDriverWait =
//        new WebDriverWait(Driver.instance, Duration.ofSeconds(10), Duration.ofSeconds(1))
//      driverWait.until(
//        ExpectedConditions.elementToBeClickable(
//          Driver.instance.findElement(By.id(url))
//        )
//      )
//      verifyLinkById(url, text)
//    }
//  }

  // the penalty data should not be displayed
  def thenThePenaltyDataShouldNotBeDisplayed(arg: Map[String, String]): Unit =
    penaltyVerification(arg)

  // Overload for ScalaTest (no DataTable, accepts varargs)
//  def thenThePenaltyDataShouldNotBeDisplayed(links: (String, String)*): Unit = {
//    links.foreach { case (text, url) =>
//      val driverWait: WebDriverWait =
//        new WebDriverWait(Driver.instance, Duration.ofSeconds(10), Duration.ofSeconds(1))
//      driverWait.until(
//        ExpectedConditions.elementToBeClickable(
//          Driver.instance.findElement(By.id(url))
//        )
//      )
//      verifyLinkById(url, text)
//    }
//  }

  // I click make a payment link to pay the overdue payment
  def andIClickMakeAPaymentLinkToPayTheOverduePayment(): Unit =
    provideMakeAPayment()

  // I should be on the most recent returns due page for submit the ECL
  def thenIShouldBeOnTheMostRecentReturnsDuePageForSubmitTheECL(): Unit =
    onPage(ReturnsPage.recentDueHeading)

}
