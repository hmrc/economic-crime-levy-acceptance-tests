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
import uk.gov.hmrc.test.ui.pages.enrolment.EnrolmentPage

object EnrolmentStepDefSteps {

  // I am signed in to the enrolment journey
  def givenIAmSignedInToTheEnrolmentJourney(): Unit =
    EnrolmentPage
      .navigateTo()
      .startAndSignIn()

  // I provide the details of my ECL reference number
  def whenIProvideTheDetailsOfMyECLReferenceNumber(): Unit =
    EnrolmentPage
      .selectEclReferenceNumber("Yes")
      .provideEclReferenceNumber("XMECL0000000001")
      .provideEclRegistrationDate(registrationDate = "01", registrationMonth = "03", registrationYear = "2023")

  // ^I select (No|Unknown) option for whether or not I have the ECL reference number$
  def whenISelectNoorUnknownOptionForWhetherOrNotIHaveTheECLReferenceNumber(value: String): Unit =
    EnrolmentPage
      .selectEclReferenceNumber(value)

  // ^I enter the economic crime levy reference number (.*)$
  def whenIEnterTheEconomicCrimeLevyReferenceNumberX(eclReferenceNumber: String): Unit =
    EnrolmentPage
      .provideInvalidEclReferenceNumber(eclReferenceNumber)

  // ^I enter the ECL registration date day as (.*) month as (.*) and year as (.*)$
  def whenIEnterTheECLRegistrationDateDayAsXMonthAsXAndYearAsX(day: String, month: String, year: String): Unit = {
    EnrolmentPage
      .selectEclReferenceNumber("Yes")
      .provideEclReferenceNumber("XMECL0000000001")
    EnrolmentPage
      .provideEclRegistrationDate(day, month, year)
  }

}
