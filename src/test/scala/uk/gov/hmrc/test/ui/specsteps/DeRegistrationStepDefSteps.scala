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
import uk.gov.hmrc.test.ui.specpage.SharedActions
import uk.gov.hmrc.test.ui.specpage.deregistration.DeRegistrationPage
import uk.gov.hmrc.test.ui.specpage.deregistration.DeRegistrationPage._

import java.time.LocalDate.now

object DeRegistrationStepDefSteps {


  def thenIShouldSeeTheDeRegisteredECLReferenceNumberAsX(value: String): Unit =
    SharedActions.assertEclReferenceNumber(value)


  def whenIClickOnTheViewOrAmendYourReturnsOrViewYourPaymentsLinkToViewTheDeregisteredXDetails(linkName: String): Unit =
    ProvideViewEclAccountAfterDeRegistration(linkName)


  def whenTheLinksXUnderTheActionColumnShouldBeVisibleOnTheThePage(linkName: String): Unit =
    getPaymentAndReturnLinks(linkName)


  def whenIProvideTheDetailsToDeRegisterTheECLAccountFromTheSystem(): Unit =
    DeRegistrationPage
      .provideEclDeRegistration()
      .submitPage()
      .provideReasonForDeRegistering()
      .provideEclDeRegistrationDate(
        deRegistrationDate = (now.getDayOfMonth - 1).toString,
        deRegistrationMonth = now.getMonthValue.toString,
        deRegistrationYear = now.getYear.toString
      )
      .provideDeRegistrationFirstContactDetails("Tom Oliver", "Director", "verify@oc.com", "01632 000 001")
      .submitPage()

}
