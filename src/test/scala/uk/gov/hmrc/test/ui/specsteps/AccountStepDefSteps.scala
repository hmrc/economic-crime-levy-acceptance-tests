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

  
  def givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX(eclReference: String): Unit =
    AccountPage
      .navigateTo()
      .provideEnrolmentDetails(
        enrolmentKey = "HMRC-ECL-ORG",
        identifierName = "EclRegistrationReference",
        identifierValue = eclReference
      )
      .startAndSignIn()

  
  def whenIAmOnTheECLAccountDashboard(): Unit =
    onPage(AccountPage.heading)


  def whenIClickOnTheSubmitAnEconomicCrimeLevyReturnLink(): Unit = {
    provideSubmitAnEclReturn()
    submitPage()
  }
  
  def whenIClickOnTheViewOrAmendYourReturnsLinkToViewTheReturnDetails(returnStatus: String): Unit =
    provideViewOrAmendAnEclReturn(returnStatus)

  
  def whenIShouldSeeTheReturnStatusAsX(returnStatus: String): Unit =
    validateReturnStatusDueBy(returnStatus)

  
  def whenIProvideTheRegistrationDetailsToSubmitAReturnThroughECLDashboardLink(): Unit =
    provideViewOrAmendAnEclReturn("DUE")
      .provideSubmitReturn()

  
  def whenIClickOnTheViewYourPaymentsLinkToViewThePaymentDetails(paymentStatus: String): Unit =
    provideViewEclPayment(paymentStatus)

  
  def whenIShouldSeeThePaymentStatusAsX(paymentStatus: String): Unit =
    validatePaymentStatusDueBy(paymentStatus)

  
  def andIShouldSeeTheXPaymentAmountX(paymentStatus: String, amount: String): Unit =
    assertPayAmountValue(paymentStatus, amount)

  
  def whenIClickOnTheMakeAnECLPaymentLinkToPayThePayment(paymentStatus: String): Unit =
    provideMakeAnEclPayment(paymentStatus)

  
  def whenIClickOnTheViewYourPaymentsLinkToViewMyX(paymentStatus: String): Unit =
    provideViewEclPayment(paymentStatus)

  
  def andIClickOnTheViewYourPaymentsLink(): Unit =
    paymentHistoryLink()

  
  def thenTheInterestRowShouldDisplayThePartialInterestPaymentInformationUnderPaymentsYouOwe(
    arg: Map[String, String]
  ): Unit =
    assertPaymentHistoryForPartiallyPaidInterest(arg)



  
  def thenTheInterestRowShouldDisplayTheFullyPaidInterestPaymentInformationUnderPaymentHistory(
    arg: Map[String, String]
  ): Unit =
    assertPaymentHistoryForFullyPaidInterest(arg)



  
  def thenTheOverdueRowShouldDisplayTheOverduePaymentInformationUnderPaymentYouOwe(arg: Map[String, String]): Unit =
    assertPaymentYouOweForOverdue(arg)


  def thenThePenaltyDataShouldNotBeDisplayed(arg: Map[String, String]): Unit =
    penaltyVerification(arg)

  def andIClickMakeAPaymentLinkToPayTheOverduePayment(): Unit =
    provideMakeAPayment()

  
  def thenIShouldBeOnTheMostRecentReturnsDuePageForSubmitTheECL(): Unit =
    onPage(ReturnsPage.recentDueHeading)

}
