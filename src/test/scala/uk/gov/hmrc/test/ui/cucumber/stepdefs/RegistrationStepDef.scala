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
import uk.gov.hmrc.test.ui.pages.registration.{GatewaySignInPage, RegistrationPage}

class RegistrationStepDef extends BaseStepDef {

  Given("""I am on the registration start page""") { () =>
    GatewaySignInPage.navigateToClearAllUrl()
    RegistrationPage.navigateToUrl()
  }

  When("""^I click on (.*) button""") { (value: String) =>
    SharedActions.clickLinkByPartialText(value)
  }

  And("""^I enter valid login credentials""") { () =>
    GatewaySignInPage.signInGateway(userID = "67 03 89 79 83 09", password = "Opencast123")
    GatewaySignInPage.enterAccessCode(accessCode = "123456")
  }

  And("""^I select a (.*) category for ECL payments""") { value: String =>
      SharedActions.selectLabelByPartialText(value)
  }

  And("""I click Submit button on authority wizard page""") { () =>
    SharedActions.authorityWizardSubmitButton()
  }

  Then("^I should see a message, (.*)$") { (value: String) =>
    SharedActions.assertPartialTextIsDisplayed(value)
  }

}
