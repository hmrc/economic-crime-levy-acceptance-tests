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

package uk.gov.hmrc.test.ui.cucumber.stepdefs
import uk.gov.hmrc.test.ui.pages.registration.AmlActivityPage

class AmlActivityStepDef extends BaseStepDef {

  When("^I do not select an option for my AML regulated activity questions") { () =>
    AmlActivityPage
      .navigateTo()
      .submitPage()
  }

  When("^I select (.*) for my AML regulated activity questions$") { (value: String) =>
    AmlActivityPage
      .navigateTo()
      .selectYesOrNoAmlActivity(value)
      .submitPage()
  }

  And("^I enter start date for my AML regulated activities as date (.*) month (.*) and year (.*)$") {
    (day: String, month: String, year: String) =>
      AmlActivityPage
        .enterStartDateForAmlActivity(day, month, year)
      AmlActivityPage.submitPage()
  }
}
