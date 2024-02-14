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

import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

object AccountingPeriodPage extends BasePage {
  val url =
    s"${TestConfiguration.url("economic-crime-levy-returns-frontend")}/submit-economic-crime-levy-return/relevant-accounting-period-length"

  val heading = "How long is your relevant accounting period?"

  def navigateTo(): this.type = {
    get(url)
    this
  }

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }

}
