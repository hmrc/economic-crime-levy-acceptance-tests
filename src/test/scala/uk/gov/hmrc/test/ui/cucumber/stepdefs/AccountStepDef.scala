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

import uk.gov.hmrc.test.ui.pages.SharedActions
import uk.gov.hmrc.test.ui.pages.account.AccountPage._
import uk.gov.hmrc.test.ui.pages.account._

class AccountStepDef extends BaseStepDef {

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
    provideSubmitAnEclReturn()
  }

  When("""I click on the View or amend your returns link to view the (DUE|OVERDUE|SUBMITTED) return details$""") {
    (returnStatus: String) =>
      provideViewOrAmendAnEclReturn(returnStatus)
  }

  When("""I should see the return status as (.*)$""") { (returnStatus: String) =>
    validateReturnStatusDueBy(returnStatus)
  }

  When("""I provide the details to amend the returns through ECL dashboard link$""") { () =>
    provideViewOrAmendAnEclReturn("DUE")
      .provideAmendSubmitReturn()
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

}
