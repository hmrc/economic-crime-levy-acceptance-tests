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
import uk.gov.hmrc.test.ui.pages.SharedActions._
import uk.gov.hmrc.test.ui.pages.registration.RegistrationPage.provideRelevantAccountingPeriod
import uk.gov.hmrc.test.ui.pages.returns._

class ReturnsStepDef extends BaseStepDef {

  Given("""I am signed in to the return journey""") { () =>
    ReturnsPage
      .navigateTo()
      .provideEnrolmentDetails(
        enrolmentKey = "HMRC-ECL-ORG",
        identifierName = "EclRegistrationReference",
        identifierValue = "XMECL0000000001"
      )
      .submitPage()
      .startAndSignIn()
  }

  When("""I provide the details to submit the economic crime levy return""") { () =>
    provideRelevantAccountingPeriod()
    ReturnsPage
      .provideUkRevenueInAccountingPeriod()
      .provideAmlRegulatedActivity()
      .submitPage()
      .provideContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
  }

  And("^I enter the contact person's name (.*) for completing my ECL return$") { (contactName: String) =>
    ContactNamePage
      .navigateTo()
    SharedActions
      .enterDetails(contactName)
    submitPage()
  }

  And("^I enter the contact person's role (.*) for completing my ECL return$") { (contactRole: String) =>
    ContactNamePage
      .navigateTo()
    SharedActions
      .enterDetails("James")
    submitPage()
    SharedActions
      .enterDetails(contactRole)
    submitPage()

  }

  And("^I enter the contact person's email address (.*) for completing my ECL return$") { (emailAddress: String) =>
    ContactNamePage
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

  When("^I enter the contact person's contact number (.*) for completing my ECL return$") { (contactNumber: String) =>
    ContactNamePage
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

  When("^I do not select an option for my relevant accounting period 12 months") { () =>
    AccountingActivityPage
      .navigateTo()
      .submitPage()
  }
  When("^I select (.*) option for my relevant accounting period 12 months$") { (value: String) =>
    AccountingActivityPage
      .navigateTo()
    SharedActions
      .selectYesOrNo(value)
      .submitPage()
  }

  When("^I do not enter the length of my accounting period") { () =>
    AccountingPeriodPage
      .navigateTo()
      .submitPage()
  }

  When("^I enter the length of my relevant accounting period in days (.*)$") { (accountingPeriod: String) =>
    AccountingPeriodPage
      .navigateTo()
    SharedActions
      .enterDetails(accountingPeriod)
    submitPage()
  }
  When("^I enter the UK revenue (.*) for my relevant accounting period$") { (ukRevenue: String) =>
    UkRevenuePage
      .navigateTo()
    SharedActions
      .enterDetails(ukRevenue)
    submitPage()
  }

  When("""I do not select an option for whether or not I carry out AML-regulated activity for the full financial year?""") { () =>
    AmlRegulatedActivityPage
      .navigateTo()
      .submitPage()
  }

  When("^I select (.*) option for my AML-regulated activity for the full financial year$") { (value: String) =>
    AmlRegulatedActivityPage
      .navigateTo()
    SharedActions
      .selectYesOrNo(value)
      .submitPage()
    onPage(AmlRegulatedActivityDaysPage.heading)
  }

  When("^I enter the total number of days (.*) I carried out AML regulated activity$") { (days: String) =>
    AmlRegulatedActivityDaysPage
      .navigateTo()
    SharedActions
      .enterDetails(days)
    submitPage()
  }

}
