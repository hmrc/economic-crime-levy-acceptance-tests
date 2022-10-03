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
import uk.gov.hmrc.test.ui.pages.LoginPage
import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import uk.gov.hmrc.test.ui.pages.LoginPage
import uk.gov.hmrc.test.ui.pages.LoginPage.authLoginPageUrl



class LoginStepDef extends BaseStepDef{

  Given("""I launch the login page""") { () =>

    LoginPage.navigateToUrl()
  }

    When("""I click on submit button""") { () =>

      LoginPage.authorityWizardSubmitButton()
    }

  Then("""I am on levy screen""") { () =>

    LoginPage.assertPartialTextIsDisplayed()

  }


}