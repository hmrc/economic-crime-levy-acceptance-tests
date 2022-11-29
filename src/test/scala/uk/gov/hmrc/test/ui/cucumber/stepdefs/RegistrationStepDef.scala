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

import uk.gov.hmrc.test.ui.pages.SharedActions
import uk.gov.hmrc.test.ui.pages.registration.{AMLSupervisorPage, GRSJourneyDataPage, GatewaySignInPage, RegistrationPage}

class RegistrationStepDef extends BaseStepDef {

  Given("""I am on the registration start page""") { () =>
    GatewaySignInPage.navigateToClearAllUrl()
    RegistrationPage.navigateToUrl()
  }

  When("""^I click on the (.*) button""") { (_: String) =>
    SharedActions.clickButton()
  }

  And("""^I enter the journey id is (.*) and business partner id is (.*)""") {
    (journeyId: String, businessPartnerId: String) =>
      GRSJourneyDataPage.enterJourneyIdAndBusinessPartnerId(journeyId, businessPartnerId)
  }

  And("^I select that my (.*) is (.*)$") { (_: String, value: String) =>
    SharedActions.selectLabelByPartialText(value)
  }

  And("""I click on the Submit button on the authority wizard page""") { () =>
    SharedActions.clickById("submit-top")
  }

  And("""I click and select the other professional body name is (.*)$""") { (value: String) =>
    SharedActions.clickById("otherProfessionalBody")
    SharedActions.clickById(value)
  }

  And("""^I click on the (.*) button on the AML supervisor page""") { (_: String) =>
    SharedActions.clickButton()
  }

  Then("^I should be on the page with the content (.*)$") { (value: String) =>
    SharedActions.assertPartialTextIsDisplayed(value)
  }

  Given("""I am on the AML supervisor page""") { () =>
    GatewaySignInPage.navigateToClearAllUrl()
    AMLSupervisorPage.navigateToAmlUrl()
  }

}
