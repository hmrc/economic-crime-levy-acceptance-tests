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
import uk.gov.hmrc.test.ui.pages.utils.EclTaxYear
import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

import java.time.LocalDate

object RegisterForCurrentFinancialYearPage extends BasePage {

  val url =
    s"${TestConfiguration.url("economic-crime-levy-registration-frontend")}/register-for-economic-crime-levy/register-for-current-financial-year"

  val eclTaxYear: EclTaxYear = EclTaxYear.fromCurrentDate(LocalDate.now())
  val heading: String        =
    "Are you registering for the 1 April " + eclTaxYear.startYear.toString + " to 31 March " + eclTaxYear.finishYear.toString + " financial year?"

  def navigateTo(): this.type = {
    get(url)
    this
  }

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }

}
