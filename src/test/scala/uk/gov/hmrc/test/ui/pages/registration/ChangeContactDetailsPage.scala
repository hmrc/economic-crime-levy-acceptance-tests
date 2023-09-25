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

package uk.gov.hmrc.test.ui.pages.registration

import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

object ChangeContactDetailsPage extends BasePage {

  val cssForChangeFirstContactName: String            =
    "a[href='/register-for-economic-crime-levy/change-answer/contact-name']"
  val cssForChangeFirstContactRole: String            =
    "a[href='/register-for-economic-crime-levy/change-answer/contact-role']"
  val cssForChangeFirstContactEmail: String           =
    "a[href='/register-for-economic-crime-levy/change-answer/contact-email-address']"
  val cssForChangeFirstContactTelephoneNumber: String =
    "a[href='/register-for-economic-crime-levy/change-answer/contact-telephone']"

  val cssForChangeSecondaryContact: String =
    "a[href='/register-for-economic-crime-levy/change-answer/second-contact']"

  val cssForChangeSecondContactName: String            =
    "a[href='/register-for-economic-crime-levy/change-answer/second-contact-name']"
  val cssForChangeSecondContactRole: String            =
    "a[href='/register-for-economic-crime-levy/change-answer/second-contact-role']"
  val cssForChangeSecondContactEmail: String           =
    "a[href='/register-for-economic-crime-levy/change-answer/second-contact-email-address']"
  val cssForChangeSecondContactTelephoneNumber: String =
    "a[href='/register-for-economic-crime-levy/change-answer/second-contact-telephone']"

  val cssForChangeRegisteredAddress: String =
    "a[href='/register-for-economic-crime-levy/change-answer/contact-address']"

  def changeFirstContactName(): this.type = {
    clickByCssSelector(cssForChangeFirstContactName)
    SharedActions
      .enterDetails("James Bond")
    submitPage()
    this
  }

  def changeFirstContactRole(): this.type = {
    clickByCssSelector(cssForChangeFirstContactRole)
    SharedActions
      .enterDetails("Director")
    submitPage()
    this
  }

  def changeFirstContactEmail(): this.type = {
    clickByCssSelector(cssForChangeFirstContactEmail)
    SharedActions
      .enterDetails("confirm@test.com")
    submitPage()
    this
  }

  def changeFirstContactTelephoneNumber(): this.type = {
    clickByCssSelector(cssForChangeFirstContactTelephoneNumber)
    SharedActions
      .enterDetails("01475344272")
    submitPage()
    this
  }

  def changeSecondContactName(): this.type = {
    clickByCssSelector(cssForChangeSecondContactName)
    SharedActions
      .enterDetails("Alexander")
    submitPage()
    this
  }

  def changeSecondContactRole(): this.type = {
    clickByCssSelector(cssForChangeSecondContactRole)
    SharedActions
      .enterDetails("Accountant Manager")
    submitPage()
    this
  }

  def changeSecondContactEmail(): this.type = {
    clickByCssSelector(cssForChangeSecondContactEmail)
    SharedActions
      .enterDetails("test@verify.com")
    submitPage()
    this
  }

  def changeSecondContactTelephoneNumber(): this.type = {
    clickByCssSelector(cssForChangeSecondContactTelephoneNumber)
    SharedActions
      .enterDetails("07401733122")
    submitPage()
    this
  }

  def changeSecondaryContact(): this.type = {
    clickByCssSelector(cssForChangeSecondaryContact)
    this
  }

  def changeRegisteredAddress(): this.type = {
    clickByCssSelector(cssForChangeRegisteredAddress)
    this
  }

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }
}
