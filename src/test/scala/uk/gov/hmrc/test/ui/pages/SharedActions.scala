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

import org.openqa.selenium.By

object SharedActions extends BasePage {

  val authoritySubmitButton = By.id("submit-top")
  def clickLinkByPartialText(value: String): Unit ={
    click(By.partialLinkText(value))
  }

  def authorityWizardSubmitButton(): Unit =
    clickElement(authoritySubmitButton)

  def assertPartialTextIsDisplayed(value: String): Unit =
    assert(getText(By.id("main-content")).contains(value))

  def clickById(id: String): Unit = {
    driver.findElement(By.id(id)).click()
  }

  def assertPage(value: String) = {
    assert(getText(By.id("main-content")).contains(value))
  }

  def selectLabelByPartialText(value: String): Unit = {
    if (value == "") {
      driver.findElement(By.cssSelector(".govuk-button")).click()
      assertPage("Select your UK turnover for {0}")
  }
    else {
    click(By.xpath(s"//label[contains(text(), '$value')]"))
    driver.findElement(By.cssSelector(".govuk-button")).click()
    value match {
        case "Less than £10.2 million" => assertPage("You do not need to register for the Economic Crime Levy")
        case "Equal to or more than £10.2 million" => assertPage("Who is your Anti-Money Laundering (AML) supervisor?")
    }
    }

  }
}
