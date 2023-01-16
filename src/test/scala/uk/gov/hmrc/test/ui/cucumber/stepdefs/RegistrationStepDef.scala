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
import uk.gov.hmrc.test.ui.pages.registration.RegistrationPage._
import uk.gov.hmrc.test.ui.pages.registration.{AmlSupervisorPage, BusinessSectorPage, EntityTypePage, FirstContactNamePage, RegistrationPage, UkRevenuePage}

class RegistrationStepDef extends BaseStepDef {

  Given("""I am signed in to the registration journey""") { () =>
    RegistrationPage
      .navigateTo()
      .startAndSignIn()
  }

  When("""I provide details of my limited company that is supervised by HMRC and liable for ECL""") { () =>
    provideUkRevenue()
      .provideHmrcOrOtherAmlSupervisor()
      .provideEntityType("Limited company")
      .provideGrsData()
      .provideAmlRegulated()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideSecondContactDetails("Mark 1", "Compliance Officer", "verify@verify.com", "+44 808 157 0192")
      .provideRegisteredAddress("Yes")
  }

  When(
    """I provide details of my limited company that is supervised by an other professional body and liable for ECL"""
  ) { () =>
    provideUkRevenue()
      .provideHmrcOrOtherAmlSupervisor("Other")
      .provideEntityType("Limited company")
      .provideGrsData()
  }

  When("""I say that my UK revenue is less than £10.2 million""") { () =>
    UkRevenuePage
      .navigateTo()
      .ukRevenueLessThan()
  }

  When("""^I say that my AML supervisor is (.*)$""") { (value: String) =>
    AmlSupervisorPage
      .navigateTo()
      .provideGcOrFcaAmlSupervisor(value)
  }

  When("""I say that my entity type is Other""") { () =>
    EntityTypePage
      .navigateTo()
      .otherEntityType()
  }

  When("""I do not select an other professional body when I have selected the Other option""") { () =>
    AmlSupervisorPage
      .navigateTo()
      .selectOtherWithNoProfessionalBodyAndSubmit
  }

  And("^I do not select an option for my UK revenue") { () =>
    UkRevenuePage
      .navigateTo()
      .submitPage()
  }

  And("^I do not select an option for my AML supervisor") { () =>
    AmlSupervisorPage
      .navigateTo()
      .submitPage()
  }

  And("^I do not select an option for my entity type") { () =>
    EntityTypePage
      .navigateTo()
      .submitPage()
  }

  And("^I do not select an option for my business sector") { () =>
    BusinessSectorPage
      .navigateTo()
      .submitPage()
  }

  And("^I enter the first contact person's name (.*) for my business$") { (contactName: String) =>
    FirstContactNamePage
      .navigateTo()
    SharedActions
      .enterDetails(contactName)
    submitPage()
  }

  When("^I enter the first contact person's role (.*) for my business$") { (contactRole: String) =>
    FirstContactNamePage
      .navigateTo()
    SharedActions
      .enterDetails("James")
    submitPage()
    SharedActions
      .enterDetails(contactRole)
    submitPage()
  }

  When("^I enter the first contact person's email address (.*) for my business$") { (emailAddress: String) =>
    FirstContactNamePage
      .navigateTo()
    SharedActions
      .enterDetails("Tom")
    submitPage()
    SharedActions
      .enterDetails("Account Director")
    submitPage()
    SharedActions
      .enterDetails(emailAddress)
    submitPage()
  }

  When("^I enter the first contact person's contact number (.*) for my business$") { (contactNumber: String) =>
    FirstContactNamePage
      .navigateTo()
    SharedActions
      .enterDetails("Paul")
    submitPage()
    SharedActions
      .enterDetails("Account Manager")
    submitPage()
    SharedActions
      .enterDetails("verify@test.com")
    submitPage()
    SharedActions
      .enterDetails(contactNumber)
    submitPage()
  }

  When("^I select (.*) to use my registered address as the main contact address$") { (value: String) =>
    provideUkRevenue()
      .provideHmrcOrOtherAmlSupervisor()
      .provideEntityType("Limited company")
      .provideGrsData()
      .provideAmlRegulated()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideSecondContactDetails("Mark 1", "Compliance Officer", "verify@verify.com", "+44 808 157 0192")
      .provideRegisteredAddress(value)
  }

  And("I select (.*) for whether or not my contact address is based in the UK$") { (value: String) =>
    SharedActions
      .selectYesOrNo(value)
      .submitPage()
  }

  Then("^I should be on the page that asks (.*)$") { (value: String) =>
    SharedActions.assertPartialTextIsDisplayed(value)
  }

  Then("^I should see an error that says (.*)$") { (value: String) =>
    SharedActions.assertPartialTextIsDisplayed(value)
  }

  Then("^I should be on the page that says (.*)$") { (value: String) =>
    SharedActions.assertPartialTextIsDisplayed(value)
  }

  Then("^I should be on the placeholder page that says (.*)$") { (value: String) =>
    SharedActions.assertHtmlContains(value)
  }

}
