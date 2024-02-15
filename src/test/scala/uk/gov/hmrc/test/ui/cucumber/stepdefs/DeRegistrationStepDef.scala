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
import uk.gov.hmrc.test.ui.pages.deregistration.DeRegistrationPage._


class DeRegistrationStepDef extends BaseStepDef {

  Then("^I should see the de registered ECL reference number as (.*)$") { (value: String) =>
    SharedActions.assertEclReferenceNumber(value)
  }

  When("I click on the View your returns or View your payments link to view the deregistered (.*) details$") { (linkName: String) =>
    ProvideViewEclAccountAfterDeRegistration(linkName)
  }

  When("the links (.*) under the Action column should be completely hidden from the page$") { (linkName: String) =>
    getPaymentAndReturnLinks(linkName)
  }
}
