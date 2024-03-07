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

package uk.gov.hmrc.test.ui.cucumber.stepdefs
import uk.gov.hmrc.test.ui.pages.SharedActions
import uk.gov.hmrc.test.ui.pages.registration._
class AmlActivityStepDef extends BaseStepDef {

  When(
    "^I select (.*) on whether or not I carried out AML-regulated activity in current FY$"
  ) { (value: String) =>
    AmlRegulatedActivityPage
      .navigateTo()
    SharedActions
      .selectYesOrNo(value)
  }

  When(
    "^I select (.*) on whether or not I carried out AML-regulated activity in current FY and in previous FY$"
  ) { (value: String) =>
    AmlRegulatedActivityPage
      .navigateTo()
    SharedActions
      .selectYesOrNo(value)
    SharedActions
      .selectYesOrNo(value)
  }

  When(
    "^I select (.*) on whether or not my relevant accounting period 12 months$"
  ) { (value: String) =>
    AmlAccountingActivityPage
      .navigateTo()
    SharedActions
      .selectYesOrNo(value)
  }
}
