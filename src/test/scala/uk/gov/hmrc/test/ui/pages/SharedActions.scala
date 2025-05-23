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
import org.openqa.selenium.By

object SharedActions extends BasePage {

  def clickLinkByPartialText(value: String): Unit =
    click(By.partialLinkText(value))

  def selectLabelByPartialText(value: String): Unit =
    click(By.xpath(s"//label[contains(text(), '$value')]"))

  def assertHtmlContains(value: String): Unit =
    assert(driver.getPageSource.contains(value))

  def assertPartialTextIsDisplayed(value: String): Unit =
    assert(getText(By.id("main-content")).contains(value))

  def clickById(id: String): Unit =
    driver.findElement(By.id(id)).click()

  def clickButton(): Unit =
    click(By.className("govuk-button"))

  def clickBackButton(): Unit =
    click(By.partialLinkText("Back"))

  def selectYesOrNo(value: String = "No"): this.type = {
    value match {
      case "Yes" =>
        SharedActions.selectLabelByPartialText("Yes")
      case _     =>
        SharedActions.selectLabelByPartialText("No")
    }
    submitPage()
    this
  }
  def enterDetails(name: String): Unit = {
    sendKeys(By.id("value"), name.trim())
    submitPage()
  }

  def confirmRegisteredAddress(value: String): this.type = {
    SharedActions
      .selectYesOrNo(value)
    this
  }

  def validateLevyAmount(value: String): Unit = {
    val actual = getText(
      By.xpath(s"//p[contains(text(),'The amount of levy you need to pay for this financ')]")
    )
    Assert.assertEquals(value, actual)
  }

  def assertTextByCssSelector(statusCssSelectorName: String, value: String): Unit =
    assert(getText(By.cssSelector(statusCssSelectorName)).contains(value))

  def clickTryAgainButton(): Unit =
    click(By.partialLinkText("Try again"))

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }

  def assertEclReferenceNumber(referenceNumber: String): this.type = {
    val actualReferenceNumber = getText(
      By.cssSelector(".govuk-caption-m")
    )
    actualReferenceNumber should be(referenceNumber)
    this
  }

  def waitForPageTitle(title: String): this.type = {
    val actualTitle = getText(
      By.cssSelector(".govuk-heading-L")
    )
    actualTitle should be(title)
    this
  }

  def selectContinueWithSavedAnswers(): this.type = {
    SharedActions
      .clickById("yes")
    submitPage()
    this
  }
}
