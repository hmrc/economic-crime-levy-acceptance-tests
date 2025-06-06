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

package uk.gov.hmrc.test.ui.cucumber.stepdefs

import io.cucumber.datatable.DataTable
import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.pages.account.AccountPage._
import uk.gov.hmrc.test.ui.pages.account._
import uk.gov.hmrc.test.ui.pages.returns.ReturnsPage
import java.time.LocalDate

class AccountStepDef extends ScalaDsl with EN with Matchers {

  Given("I am signed in to the account journey with my ECL reference as (.*)$") { (eclReference: String) =>
    AccountPage
      .navigateTo()
      .provideEnrolmentDetails(
        enrolmentKey = "HMRC-ECL-ORG",
        identifierName = "EclRegistrationReference",
        identifierValue = eclReference
      )
      .startAndSignIn()
  }

  When("""I am on the ECL account dashboard""") { () =>
    onPage(AccountPage.heading)
  }

  When("""I click on the Submit an Economic Crime Levy return link""") { () =>
    if (LocalDate.now().getMonthValue >= 8){
    provideSubmitAnEclReturn()
    } else {
    provideSubmitAltEclReturn()
    }
    submitPage()
  }

  When("""I click on the View or amend your returns link to view the (DUE|OVERDUE|SUBMITTED) return details$""") {
    (returnStatus: String) =>
      provideViewOrAmendAnEclReturn(returnStatus)
  }

  When("""I should see the return status as (.*)$""") { (returnStatus: String) =>
    validateReturnStatusDueBy(returnStatus)
  }

  When("""I provide the registration details to submit a return through ECL dashboard link$""") { () =>
    provideViewOrAmendAnEclReturn("DUE")
      .provideSubmitReturn()
  }

  When("""I click on the View your payments link to view the (DUE|OVERDUE|PARTIALLY PAID|PAID) payment details$""") {
    (paymentStatus: String) =>
      provideViewEclPayment(paymentStatus)
  }

  When("""I should see the payment status as (.*)$""") { (paymentStatus: String) =>
    validatePaymentStatusDueBy(paymentStatus)
  }

  And("""I should see the (.*) payment amount (.*)$""") { (paymentStatus: String, amount: String) =>
    assertPayAmountValue(paymentStatus, amount)
  }

  When("""I click on the Make an ECL payment link to pay the (DUE|OVERDUE) payment$""") { (paymentStatus: String) =>
    provideMakeAnEclPayment(paymentStatus)
  }

  When("I click on the View your payments link to view my (.*)$") { (paymentStatus: String) =>
    provideViewEclPayment(paymentStatus)
  }

  Then("""the interest row should display the partial interest payment information under Payments you owe$""") {
    (arg: DataTable) =>
      assertPaymentHistoryForPartiallyPaidInterest(arg)
  }

  Then("""the interest row should display the fully paid interest payment information under Payment History$""") {
    (arg: DataTable) =>
      assertPaymentHistoryForFullyPaidInterest(arg)
  }

  Then("""the overdue row should display the overdue payment information under Payment you owe$""") {
    (arg: DataTable) =>
      assertPaymentYouOweForOverdue(arg)
  }

 var currentYearECL = "1 April 2024 to 31 March 2025"
 var previousYearECL = " 1 April 2023 to 31 March 2024"
 var previousPreviousYearECL = " 1 April 2022 to 31 March 2023"

  var previousYearECLDate = "30 September 2024"
  var paymentDate =  "9 February 2023"

  And("I click make a payment link to pay the overdue payment") { () =>
    provideMakeAPayment()
  }

  Then("""I should be on the most recent returns due page for submit the ECL""") { () =>
    onPage(ReturnsPage.recentDueHeading)
  }

}
