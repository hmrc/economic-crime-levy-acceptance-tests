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

object ChangeContactDetailsPage extends BasePage {

  val cssForChangeContactName: String =
    "a[href='/submit-economic-crime-levy-return/change-answer/contact-name']"

  val cssForChangeContactRole: String =
    "a[href='/submit-economic-crime-levy-return/change-answer/contact-role']"
  val cssForChangeContactEmail: String =
    "a[href='/submit-economic-crime-levy-return/change-answer/contact-email-address']"
  val cssForChangeContactTelephoneNumber: String =
    "a[href='/submit-economic-crime-levy-return/change-answer/contact-telephone']"


  def changeFirstContactName(): this.type = {
    clickByCssSelector(cssForChangeContactName)
    SharedActions
      .enterDetails("James Bond 007")
    submitPage()
    onPage(CheckYourAnswersPage.heading)
    this
  }

  def changeFirstContactRole(): this.type = {
    clickByCssSelector(cssForChangeContactRole)
    SharedActions
      .enterDetails("Compliance Office")
    submitPage()
    onPage(CheckYourAnswersPage.heading)
    this
  }

  def changeFirstContactEmail(): this.type = {
    clickByCssSelector(cssForChangeContactEmail)
    SharedActions
      .enterDetails("verify@test.com")
    submitPage()
    onPage(CheckYourAnswersPage.heading)
    this
  }

  def changeFirstContactTelephoneNumber(): this.type = {
    clickByCssSelector(cssForChangeContactTelephoneNumber)
    SharedActions
      .enterDetails("014753777777")
    submitPage()
    onPage(CheckYourAnswersPage.heading)
    this
  }

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }

}
