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

package uk.gov.hmrc.test.ui.pages

import org.junit.Assert
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Wait, WebDriverWait}
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.scalatest.matchers.should.Matchers
import uk.gov.hmrc.test.ui.driver.BrowserDriver

import java.util
import java.time.Duration

trait BasePage extends BrowserDriver with Matchers {

  protected def get(url: String): Unit =
    driver.get(url)

  private val fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](driver)
    .withTimeout(Duration.ofSeconds(250))
    .pollingEvery(Duration.ofSeconds(20))

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

  def waitforTextBoxToBeAvailable(locator: By) =
    new WebDriverWait(driver, Duration.ofSeconds(20))
      .until(ExpectedConditions.visibilityOfElementLocated(locator))

  private def clear(locator: By): Unit = {
    findElement(locator).clear()
  }
  protected def sendKeys(locator: By, value: String): Unit = {
    clear(locator)
    findElement(locator).sendKeys(value)
  }

  protected def click(locator: By): Unit = {
    waitForElementToBeClickable(locator)
    findElement(locator).click()
  }

  protected def findElementByCssSelector(locator: String) =
    findElement(By.cssSelector(locator))

  protected def findElementsByCssSelector(css: String): util.List[WebElement] =
    driver.findElements(By.cssSelector(css))

  def onPage(heading: String): Unit =
    SharedActions.assertPartialTextIsDisplayed(heading)

  def clickByCssSelector(css: String): Unit =
    driver.findElement(By.cssSelector(css)).click()

  def confirmUrl(url: String): Unit = {
    fluentWait.until(ExpectedConditions.urlContains(url))
    val currentUrl = driver.getCurrentUrl
    Assert.assertEquals(currentUrl, url)
  }
}

case class PageNotFoundException(s: String) extends Exception(s)
