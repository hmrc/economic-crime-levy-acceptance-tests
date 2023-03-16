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

package uk.gov.hmrc.test.ui.pages.returns

import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

object ChangeContactDetails extends BasePage {

  val cssForChangeContactName: String            =
    "a[href='/submit-economic-crime-levy-return/change-answer/contact-name']"
  val cssForChangeContactRole: String            =
    "a[href='/submit-economic-crime-levy-return/change-answer/contact-role']"
  val cssForChangeContactEmail: String           =
    "a[href='/submit-economic-crime-levy-return/change-answer/contact-email-address']"
  val cssForChangeContactTelephoneNumber: String =
    "a[href='/submit-economic-crime-levy-return/change-answer/contact-telephone']"

  def changeContactName(name: String): this.type = {
    clickByCssSelector(cssForChangeContactName)
    ContactNamePage
      .provideContactName(name)
    onPage(CheckYourAnswersPage.heading)
    this
  }

  def changeContactRole(role: String): this.type = {
    clickByCssSelector(cssForChangeContactRole)
    ContactRolePage
      .provideContactRole(role)
    onPage(CheckYourAnswersPage.heading)
    this
  }

  def changeContactEmail(emailAddress: String): this.type = {
    clickByCssSelector(cssForChangeContactEmail)
    ContactEmailAddressPage
      .provideContactEmailAddress(emailAddress)
    onPage(CheckYourAnswersPage.heading)
    this
  }

  def changeContactTelephoneNumber(contactNumber: String): this.type = {
    clickByCssSelector(cssForChangeContactTelephoneNumber)
    ContactTelephonePage
      .provideContactNumber(contactNumber)
    onPage(CheckYourAnswersPage.heading)
    this
  }

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }

}
