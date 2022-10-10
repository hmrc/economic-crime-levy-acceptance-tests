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

import org.openqa.selenium.{By, WebElement}
import org.junit.Assert


object LoginPage extends BasePage {

  val authoritySubmitButton = By.id("submit-top")

  def navigateToUrl(): Unit = {
    driver.get(authLoginPageUrl)
  }

  def authorityWizardSubmitButton(): Unit = {
    clickElement(authoritySubmitButton)
  }

  def assertPartialTextIsDisplayed(): Unit ={
    val actualHeading = driver.findElement(By.cssSelector("h1")).getText()
    println("actual value:" + actualHeading)
    Assert.assertEquals("economic-crime-levy-registration-frontend",actualHeading)
  }
}
