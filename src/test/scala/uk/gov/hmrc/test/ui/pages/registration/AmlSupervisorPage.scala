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

object AmlSupervisorPage extends BasePage {

  val url =
    s"${TestConfiguration.url("economic-crime-levy-registration-frontend")}/register-for-economic-crime-levy/your-aml-supervisor/Initial"

  val heading = "Your anti-money laundering (AML) supervisor"

  def navigateTo(): this.type = {
    get(url)
    this
  }

  def provideGcOrFcaAmlSupervisor(value: String): this.type = {
    SharedActions.selectLabelByPartialText(value)
    submitPage()
    this
  }

  def selectOtherWithNoProfessionalBodyAndSubmit: this.type = {
    SharedActions.selectLabelByPartialText("Other")
    submitPage()
  }

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }

}
