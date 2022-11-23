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

import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.BasePage

object GatewaySignInPage extends BasePage {

  val clearAllUrl =
    s"${TestConfiguration.url("auth-login-stub-reg")}/register-for-economic-crime-levy/test-only/clear-all"

  def navigateToClearAllUrl(): Unit = {
    driver.get(clearAllUrl)
  }

  def signInGateway(userID: String, password: String) = {
    sendKeys(By.id("user_id"), userID)
    sendKeys(By.id("password"), password)
    click(By.id("continue"))

  }

  def enterAccessCode(accessCode: String): Unit = {
    sendKeys(By.xpath("//input[@id='oneTimePassword']"), accessCode)
    click(By.id("continue"))
  }

}
