/*
 * Copyright 2022 HM Revenue & Customs
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

import org.openqa.selenium.By.{ByCssSelector, cssSelector, xpath}
import org.openqa.selenium.WebElement
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.BasePage

object AMLSupervisorPage extends BasePage{

  val amlUrl =
    s"${TestConfiguration.url("economic-crime-levy-registration-frontend")}/register-for-the-economic-crime-levy/who-is-your-aml-supervisor"

  def navigateToAmlUrl(): Unit = {
    driver.get(amlUrl)
  }

}