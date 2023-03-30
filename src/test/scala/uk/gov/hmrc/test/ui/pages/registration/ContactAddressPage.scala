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

import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

object ContactAddressPage extends BasePage {

  val url =
    s"${TestConfiguration.url("economic-crime-levy-registration-frontend")}/register-for-economic-crime-levy/contact-address"

  val heading = "Do you want to use this registered address as the main contact address?"

  def navigateTo(): this.type = {
    navigateToClearAllUrl()
    driver.get(url)
    RegistrationPage
      .provideAccessCode("123456")
    this
  }

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }
}
