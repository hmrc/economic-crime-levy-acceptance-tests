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

import io.cucumber.datatable.DataTable
import uk.gov.hmrc.test.ui.pages.SharedActions
import uk.gov.hmrc.test.ui.pages.account.AccountPage
import uk.gov.hmrc.test.ui.pages.registration.RegistrationPage._
import uk.gov.hmrc.test.ui.pages.registration._

class RegistrationStepDef extends BaseStepDef {
  val eclStartYear = previousEclTaxYearStartYear.getYear

  Given("""I am signed in to the registration journey""") { () =>
    RegistrationPage
      .navigateTo()
      .startAndSignIn()

  }

  When("""I provide details of my (.*) that is supervised by HMRC and liable for current ECL$""") {
    (entityType: String) =>
      provideEclLiableForCurrentFinancialYear()
        .provideEclLiabilityDate(
          liabilityStartDate = previousEclTaxYearStartYear.getDayOfMonth.toString,
          liabilityStartMonth = previousEclTaxYearStartYear.getMonthValue.toString,
          liabilityStartYear = previousEclTaxYearStartYear.getYear.toString
        )
        .provideEntityType(entityType)
        .provideGrsData()
        .provideBusinessSector("Credit institution")
        .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
        .provideAddAnotherContactYesOrNo("No")
        .provideRegisteredAddress("Yes")
        .submitPage()
        .provideCheckYourAnswers()
  }

  When(
    """I provide details of my limited company that is supervised by an other professional body and liable for ECL"""
  ) { () =>
    provideUkRevenue()
      .provideHmrcOrOtherAmlSupervisor("Other")
      .provideEntityType("Limited company")
      .provideGrsData()
  }

  And("I provide the details of another UK address as my main contact address") { () =>
    provideEclLiableForCurrentFinancialYear("No")
      .provideEclLiabilityDate(
        liabilityStartDate = previousEclTaxYearStartYear.getDayOfMonth.toString,
        liabilityStartMonth = previousEclTaxYearStartYear.getMonthValue.toString,
        liabilityStartYear = previousEclTaxYearStartYear.getYear.toString
      )
      .provideHmrcOrOtherAmlSupervisor()
      .provideEntityType("Limited liability partnership")
      .provideGrsData()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideSecondContactDetails("Mark 1", "Compliance Officer", "verify@verify.com", "+44 808 157 0192")
      .provideRegisteredAddress("No")
      .provideAnotherUkRegisteredAddress("No")
      .submitPage()
  }

  And("I provide the details of a non UK address as my main contact address") { () =>
    provideEclLiableForCurrentFinancialYear("No")
      .provideEclLiabilityDate(
        liabilityStartDate = previousEclTaxYearStartYear.getDayOfMonth.toString,
        liabilityStartMonth = previousEclTaxYearStartYear.getMonthValue.toString,
        liabilityStartYear = previousEclTaxYearStartYear.getYear.toString
      )
      .provideHmrcOrOtherAmlSupervisor()
      .provideEntityType("Limited partnership")
      .provideGrsData()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideAddAnotherContactYesOrNo("No")
      .provideRegisteredAddress("No")
      .provideAnotherUkRegisteredAddress("Yes")
      .submitPage()
  }

  And("I go to check your answers page directly without providing answers for any of the previous page questions") {
    () =>
      CheckYourAnswersPage
        .navigateTo()
  }

  When("I click on the change link and edit my contact details") { () =>
    provideEclLiableForCurrentFinancialYear()
      .provideEclLiabilityDate(
        liabilityStartDate = previousEclTaxYearStartYear.getDayOfMonth.toString,
        liabilityStartMonth = previousEclTaxYearStartYear.getMonthValue.toString,
        liabilityStartYear = previousEclTaxYearStartYear.getYear.toString
      )
      .provideEntityType("Registered society")
      .provideGrsData()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideSecondContactDetails("Mark 1", "Compliance Officer", "verify@verify.com", "+44 808 157 0192")
      .provideRegisteredAddress("Yes")
      .provideChangeFirstContactDetails()
      .provideChangeSecondContactDetails()
  }

  When("I click on the change link to modify my secondary contact") { () =>
    provideEclLiableForCurrentFinancialYear()
      .provideEclLiabilityDate(
        liabilityStartDate = previousEclTaxYearStartYear.getDayOfMonth.toString,
        liabilityStartMonth = previousEclTaxYearStartYear.getMonthValue.toString,
        liabilityStartYear = previousEclTaxYearStartYear.getYear.toString
      )
      .provideEntityType("Scottish limited partnership")
      .provideGrsData()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideSecondContactDetails("Mark 1", "Compliance Officer", "verify@verify.com", "+44 808 157 0192")
      .provideRegisteredAddress("Yes")
      .provideChangeFirstContactDetails()
      .provideChangeSecondContactDetails()
      .provideChangeSecondaryContact()
  }

  When("I select (.*) on whether or not to add a secondary contact details$") { (value: String) =>
    SharedActions
      .selectYesOrNo(value)
  }

  When("I click on the change link to modify the registered address") { () =>
    provideEclLiableForCurrentFinancialYear("No")
      .provideEclLiabilityDate(
        liabilityStartDate = previousEclTaxYearStartYear.getDayOfMonth.toString,
        liabilityStartMonth = previousEclTaxYearStartYear.getMonthValue.toString,
        liabilityStartYear = previousEclTaxYearStartYear.getYear.toString
      )
      .provideHmrcOrOtherAmlSupervisor()
      .provideEntityType("Unlimited company")
      .provideGrsData()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideAddAnotherContactYesOrNo("No")
      .provideRegisteredAddress("No")
      .provideAnotherUkRegisteredAddress("Yes")
      .submitPage()
      .provideChangeRegisteredAddress()
  }

  When("I select (.*) on whether or not to use a different UK address as my main contact address$") { (value: String) =>
    provideNonUkRegisteredAddress(value)
      .submitPage()
  }

  When("I click on the change link and edit my organisation details") { () =>
    provideEclLiableForCurrentFinancialYear()
      .provideEclLiabilityDate(
        liabilityStartDate = previousEclTaxYearStartYear.getDayOfMonth.toString,
        liabilityStartMonth = previousEclTaxYearStartYear.getMonthValue.toString,
        liabilityStartYear = previousEclTaxYearStartYear.getYear.toString
      )
      .provideEntityType("Limited company")
      .provideGrsData()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideAddAnotherContactYesOrNo("No")
      .provideRegisteredAddress("Yes")
      .provideChangeOrganisationDetails()
  }

  When(
    "I click on the change link and select (.*) on whether or not I carried out AML-regulated activity in current FY$"
  ) { (value: String) =>
    provideEclLiableForCurrentFinancialYear()
      .provideEclLiabilityDate(
        liabilityStartDate = previousEclTaxYearStartYear.getDayOfMonth.toString,
        liabilityStartMonth = previousEclTaxYearStartYear.getMonthValue.toString,
        liabilityStartYear = previousEclTaxYearStartYear.getYear.toString
      )
      .provideEntityType("Limited company")
      .provideGrsData()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideAddAnotherContactYesOrNo("No")
      .provideRegisteredAddress("Yes")
      .provideChangeAmlRegulatedActivity()
  }

  When("I click on the change link and select the new entity type") { () =>
    provideEclLiableForCurrentFinancialYear()
      .provideEclLiabilityDate(
        liabilityStartDate = previousEclTaxYearStartYear.getDayOfMonth.toString,
        liabilityStartMonth = previousEclTaxYearStartYear.getMonthValue.toString,
        liabilityStartYear = previousEclTaxYearStartYear.getYear.toString
      )
      .provideEntityType("Limited company")
      .provideGrsData()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideAddAnotherContactYesOrNo("No")
      .provideRegisteredAddress("Yes")
      .provideChangeEntityType()
  }

  When("I select my entity type as (.*) and provide the registration details$") { (entityType: String) =>
    provideEclLiableForCurrentFinancialYear()
      .provideEclLiabilityDate(
        liabilityStartDate = previousEclTaxYearStartYear.getDayOfMonth.toString,
        liabilityStartMonth = previousEclTaxYearStartYear.getMonthValue.toString,
        liabilityStartYear = previousEclTaxYearStartYear.getYear.toString
      )
      .provideEntityTypeDetailsForGeneralOrScottishPartnership(entityType)
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideAddAnotherContactYesOrNo("No")
      .provideRegisteredAddress("Yes")
      .provideCheckYourAnswers()
  }

  When("I provide details of my other entity is (.*) that is supervised by HMRC and liable for ECL$") {
    (otherEntityType: String) =>
      provideEclLiableForCurrentFinancialYear("No")
        .provideEclLiabilityDate(
          liabilityStartDate = previousEclTaxYearStartYear.getDayOfMonth.toString,
          liabilityStartMonth = previousEclTaxYearStartYear.getMonthValue.toString,
          liabilityStartYear = previousEclTaxYearStartYear.getYear.toString
        )
        .provideHmrcOrOtherAmlSupervisor()
        .provideOtherEntityBusinessDetails(otherEntityType)
        .provideBusinessSector("Credit institution")
        .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
        .provideAddAnotherContactYesOrNo("No")
        .provideRegisteredAddress("Yes")
        .provideGrsData()
        .provideCheckYourAnswers()
  }

  When("^I enter my overseas tax identifier as (.*) for the Non-UK Establishment business$") {
    (overseasTaxIdentifier: String) =>
      OverseasTaxIdentifierPage
        .navigateTo()
      provideOverseasTaxIdentifier(overseasTaxIdentifier)
  }

  Then("^I should see an error that says (.*)$") { (value: String) =>
    SharedActions.assertPartialTextIsDisplayed(value)
  }

  Then("^I should be on the page that says (.*)$") { (value: String) =>
    SharedActions.assertPartialTextIsDisplayed(value)
  }

  Then("I should be on the placeholder page that mentions an overdue payment for previousYearECL") { () =>
    val assertion = "1 April " + 2023 + " to 31 March " + 2024
    print("previous Year ECL should be:  1 April 2022 to 31 March 2023   this assertion is: " + assertion)
    SharedActions.assertPartialTextIsDisplayed(assertion)
  }

  Then("I should be on the placeholder page that mentions an overdue payment for currentYearECL") { () =>
    val assertion = "1 April " + (eclStartYear + 1) + " to 31 March " + eclStartYear
    print("current Year ECL should be: 1 April 2023 to 31 March 2024 this one is: " + assertion)
    SharedActions.assertPartialTextIsDisplayed(assertion)
  }

  Then("^I should be on the placeholder page that says (.*)$") { (value: String) =>
    SharedActions.assertHtmlContains(value)
  }

  When("""I provide details of my limited company and indicate liability for previous year ECL""") { () =>
    areYouRegisteringForCurrentFinancialYear()
      .provideAmlRegulated("No")
      .provideEclLiableForPreviousFinancialYear()
      .provideEclLiabilityDate(
        liabilityStartDate = previousEclTaxYearStartYear.getDayOfMonth.toString,
        liabilityStartMonth = previousEclTaxYearStartYear.getMonthValue.toString,
        liabilityStartYear = previousEclTaxYearStartYear.getYear.toString
      )
      .provideHmrcOrOtherAmlSupervisor()
      .provideEntityType("Limited company")
      .provideGrsData()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideAddAnotherContactYesOrNo("No")
      .provideRegisteredAddress("Yes")
      .provideCheckYourAnswers()
  }

  When("""I provide Yes to AML question and the turnover is £10.2m and above and (.*) liable for previous FY$""") {
    (value: String) =>
      areYouRegisteringForCurrentFinancialYear()
        .provideAmlRegulated()
        .provideHmrcOrOtherAmlSupervisor()
        .provideRelevantAccountingPeriod()
        .provideUkRevenue()
        .areYouLiableForPreviousFinancialYear(value)
        .provideEntityType("Limited company")
        .provideGrsData()
        .provideBusinessSector("Credit institution")
        .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
        .provideAddAnotherContactYesOrNo("No")
        .provideRegisteredAddress("Yes")
        .provideCheckYourAnswers()
  }

  When(
    """I provide Yes to AML question and the turnover is below £10.2m threshold and (.*) liable for previous FY$"""
  ) { (value: String) =>
    areYouRegisteringForCurrentFinancialYear()
      .provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue("1020000")
      .areYouLiableForPreviousFinancialYear(value)
      .provideEntityType("Limited company")
      .provideGrsData()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideAddAnotherContactYesOrNo("No")
      .provideRegisteredAddress("Yes")
      .provideCheckYourAnswers()
  }

  When(
    """I provide Yes to AML question and the turnover is below £10.2m threshold but (.*) liability for previous year ECL$"""
  ) { (value: String) =>
    areYouRegisteringForCurrentFinancialYear()
      .provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue("1020000")
      .provideEclLiableForPreviousFinancialYear(value)
  }

  When("""I provide details of my (.*) and fail the GRS journey$""") { (entityType: String) =>
    areYouRegisteringForCurrentFinancialYear()
      .provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue()
      .areYouLiableForPreviousFinancialYear()
      .provideEntityType(entityType)
      .provideGrsDataForIdentifiersDoNotMatch()
      .provideGrsData()
  }

  When("""I provide the details to amend the submitted economic crime levy registration""") { () =>
    AccountPage
      .provideAmendAnEclRegistration()
    SharedActions
      .enterDetails("Amending registration details")
    RegistrationPage
      .provideChangeFirstContactDetails()
  }

  And("^I decide to cancel this amendments") { () =>
    AmendmentPage
      .provideCancelAmendment()
      .provideSelectYesOrNo()
  }

  And("^I click on the try again button") { () =>
    SharedActions.clickTryAgainButton()
  }

  And("""the amended registration information should display under Amended answers on the Check your answers page$""") {
    (arg: DataTable) =>
      assertAmendedRegistrationAnswers(arg)
        .submitPage()
  }

  When("""I provide the details to amend the liability start date for registration""") { () =>
    AccountPage
      .provideAmendAnEclRegistration()
    SharedActions
      .enterDetails("Amending the liability start date to previous FY")
    RegistrationPage
      .provideChangeLiabilityStartDate()
      .submitPage()
  }

  When("""I provide some details for the economic crime levy registration and experience a system timeout""") { () =>
    provideEclLiableForCurrentFinancialYear()
      .provideEclLiabilityDate(
        liabilityStartDate = previousEclTaxYearStartYear.getDayOfMonth.toString,
        liabilityStartMonth = previousEclTaxYearStartYear.getMonthValue.toString,
        liabilityStartYear = previousEclTaxYearStartYear.getYear.toString
      )
      .provideEntityType("Limited company")
      .provideGrsData()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideAddAnotherContactYesOrNo("No")
      .provideRegisteredAddress("Yes")
  }

  And("""I return to the service to complete the registration""") { () =>
    provideRegistrationSubmissionAfterTimeout()
      .submitPage()
  }

  And("""I should be able to resume the registration from where I left off""") { () =>
    SharedActions
      .selectContinueWithSavedAnswers()
      .submitPage()
  }

  When("^I select (.*) on whether or not I carried out AML-regulated activity in current FY and in previous FY$") {
    (value: String) =>
      AmlRegulatedActivityPage
        .navigateTo()
      SharedActions
        .selectYesOrNo(value)
      SharedActions
        .selectYesOrNo(value)
  }
}
