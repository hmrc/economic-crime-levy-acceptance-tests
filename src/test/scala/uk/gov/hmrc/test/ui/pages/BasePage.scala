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

package uk.gov.hmrc.test.ui.pages

import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Wait}
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import java.time.Duration
import java.time.temporal.ChronoUnit

trait BasePage extends BrowserDriver with Matchers {

  val registerAuthLoginPageUrl =
    s"${TestConfiguration.url("auth-login-stub")}/gg-sign-in?continue=http%3A%2F%2Flocalhost%3A14000%2Fregister-for-economic-crime-levy%2F"
  val returnsAuthLoginPageUrl  =
    s"${TestConfiguration.url("auth-login-stub")}/gg-sign-in?continue=http%3A%2F%2Flocalhost%3A14002%2Fsubmit-economic-crime-levy-return%2F"

  val WAIT_POLLING_INTERVAL: Duration = Duration.of(250, ChronoUnit.MILLIS)
  val WAIT_TIME_OUT: Duration         = Duration.of(20, ChronoUnit.SECONDS)

  private val fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(WAIT_POLLING_INTERVAL)
    .pollingEvery(WAIT_TIME_OUT)

  def clickElement(locator: By): Unit = {
    waitForElementToBeClickable(locator)
    findElement(locator).click()
  }

  def findElement(locator: By): WebElement =
    driver.findElement(locator)

  def waitForElementToBeClickable(locator: By): WebElement =
    fluentWait.until(ExpectedConditions.elementToBeClickable(findElement(locator)))

  protected def getText(locator: By): String = {
    waitForElementToBePresent(locator)
    findElement(locator).getText
  }

  private def waitForElementToBePresent(locator: By): WebElement =
    fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator))

}

case class PageNotFoundException(s: String) extends Exception(s)
