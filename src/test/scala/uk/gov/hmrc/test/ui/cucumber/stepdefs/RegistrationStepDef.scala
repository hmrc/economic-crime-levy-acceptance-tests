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
import uk.gov.hmrc.test.ui.pages.registration._

class RegistrationStepDef extends BaseStepDef {

  Given("""I am signed in to the registration journey""") { () =>
    RegistrationPage
      .navigateTo()
      .startAndSignIn()

  }

  When("""I provide details of my (.*) that is supervised by HMRC and liable for current ECL$""") {
    (entityType: String) =>
      provideAmlRegulated()
        .provideHmrcOrOtherAmlSupervisor()
        .provideRelevantAccountingPeriod()
        .provideUkRevenue()
        .provideEclLiableForPreviousFinancialYear("Yes")
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
    provideUkRevenue("10200000")
      .provideHmrcOrOtherAmlSupervisor("Other")
      .provideEntityType("Limited company")
      .provideGrsData()
  }

  When("""^I say that my AML supervisor is (.*)$""") { (value: String) =>
    AmlSupervisorPage
      .navigateTo()
      .provideGcOrFcaAmlSupervisor(value)
  }

  When("""I do not select an other professional body when I have selected the Other option""") { () =>
    AmlSupervisorPage
      .navigateTo()
      .selectOtherWithNoProfessionalBodyAndSubmit
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
    provideFirstContactName(contactName)
  }

  When("^I enter the first contact person's role (.*) for my business$") { (contactRole: String) =>
    provideFirstContactName("James")
      .provideFirstContactRole(contactRole)
  }

  When("^I enter the first contact person's email address (.*) for my business$") { (emailAddress: String) =>
    provideFirstContactName("Tom")
      .provideFirstContactRole("Account Director")
      .provideFirstContactEmail(emailAddress)
  }

  When("^I enter the first contact person's contact number (.*) for my business$") { (contactNumber: String) =>
    provideFirstContactName("Paul")
      .provideFirstContactRole("Account Manager")
      .provideFirstContactEmail("verify@test.com")
      .provideFirstContactTelephoneNumber(contactNumber)
  }

  And("I provide the details of another UK address as my main contact address") { () =>
    provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue()
      .provideEclLiableForPreviousFinancialYear("Yes")
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
    provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue()
      .provideEclLiableForPreviousFinancialYear("Yes")
      .provideEntityType("Limited partnership")
      .provideGrsData()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideAddAnotherContactYesOrNo("No")
      .provideRegisteredAddress("No")
      .provideAnotherUkRegisteredAddress("Yes")
      .submitPage()
  }

  When("I enter the UK revenue (.*)for the relevant accounting period$") { (revenue: String) =>
    provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
    SharedActions
      .enterDetails(revenue)
    submitPage()
  }
  And("I go to check your answers page directly without providing answers for any of the previous page questions") {
    () =>
      CheckYourAnswersPage
        .navigateTo()
  }

  When("I click on the change link and edit my contact details") { () =>
    provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue()
      .provideEclLiableForPreviousFinancialYear("Yes")
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
    provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue()
      .provideEclLiableForPreviousFinancialYear("Yes")
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
    submitPage()
  }

  When("I click on the change link to modify the registered address") { () =>
    provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue()
      .provideEclLiableForPreviousFinancialYear("Yes")
      .provideEntityType("Unlimited company")
      .provideGrsData()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideAddAnotherContactYesOrNo("No")
      .provideRegisteredAddress("Yes")
      .provideChangeRegisteredAddress()
  }

  When("I select (.*) on whether or not to use a different UK address as my main contact address$") { (value: String) =>
    provideRegisteredAddress("No")
      .provideNonUkRegisteredAddress("Yes")
      .submitPage()
  }

  When("I click on the change link and edit my organisation details") { () =>
    provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue()
      .provideEclLiableForPreviousFinancialYear("Yes")
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
    provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue()
      .provideEclLiableForPreviousFinancialYear("Yes")
      .provideEntityType("Limited company")
      .provideGrsData()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideAddAnotherContactYesOrNo("No")
      .provideRegisteredAddress("Yes")
      .provideChangeAmlRegulatedActivity()
  }

  When("I click on the change link and select the new entity type") { () =>
    provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue()
      .provideEclLiableForPreviousFinancialYear("Yes")
      .provideEntityType("Limited company")
      .provideGrsData()
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideAddAnotherContactYesOrNo("No")
      .provideRegisteredAddress("Yes")
      .provideChangeEntityType()
  }

  When("I select my entity type as (.*) and provide the registration details$") { (entityType: String) =>
    provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue()
      .provideEclLiableForPreviousFinancialYear("Yes")
      .provideEntityTypeDetailsForGeneralOrScottishPartnership(entityType)
      .provideBusinessSector("Credit institution")
      .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
      .provideAddAnotherContactYesOrNo("No")
      .provideRegisteredAddress("Yes")
      .provideCheckYourAnswers()
  }

  When("I provide details of my other entity is (.*) that is supervised by HMRC and liable for ECL$") {
    (otherEntityType: String) =>
      provideAmlRegulated()
        .provideHmrcOrOtherAmlSupervisor()
        .provideRelevantAccountingPeriod()
        .provideUkRevenue()
        .provideEclLiableForPreviousFinancialYear("Yes")
        .provideOtherEntityBusinessDetails(otherEntityType)
        .provideOtherEntityCheckYourAnswers()
        .provideBusinessSector("Credit institution")
        .provideFirstContactDetails("Oliver Tom", "Account Manager", "test@test.com", "01632 960 001")
        .provideAddAnotherContactYesOrNo("No")
        .provideRegisteredAddress("Yes")
        .provideGrsData()
        .provideCheckYourAnswers()
  }

  When("I enter my registered name as (.*) for the other entity type business$") { (registeredBusinessName: String) =>
    BusinessNamePage
      .navigateTo()
    provideRegisteredNameOfYourBusiness(registeredBusinessName)
  }

  When("I enter my charity registration number as (.*) for the other entity type business$") {
    (charityRegistrationNumber: String) =>
      CharityRegistrationNumberPage
        .navigateTo()
      provideCharityRegistrationNumberOfYourBusiness(charityRegistrationNumber)
  }

  When("I enter my company registration number as (.*) for the other entity type business$") {
    (companyRegistrationNumber: String) =>
      CompanyRegistrationNumberPage
        .navigateTo()
      provideCompanyRegistrationNumberOfYourBusiness(companyRegistrationNumber)
  }

  When("I do not select an option for whether or not I have a Corporation Tax Unique Taxpayer Reference") { () =>
    DoYouHaveCorporationTaxUtrPage
      .navigateTo()
    submitPage()
  }

  When("^I select (.*) on whether or not I have a Corporation Tax Unique Taxpayer Reference$") { (value: String) =>
    DoYouHaveCorporationTaxUtrPage
      .navigateTo()
    doYouHaveCorporationTaxUniqueTaxpayerReference(value)
  }

  When("^I enter my Corporation Tax Unique Taxpayer Reference as (.*) for the other entity type (.*) business$") {
    (uniqueTaxpayerReference: String, otherEntityType: String) =>
      otherEntityType match {
        case "Unincorporated Association" =>
          DoYouHaveCorporationTaxUtrPage
            .navigateTo()
          doYouHaveCorporationTaxUniqueTaxpayerReference("Yes")
            .provideCorporationTaxUniqueTaxpayerReference(uniqueTaxpayerReference)
        case "Trust"                      =>
          CorporationTaxUtrPage
            .navigateTo()
          provideCorporationTaxUniqueTaxpayerReference(uniqueTaxpayerReference)
        case _                            =>
          SelfAssessmentUtrPage
            .navigateTo()
          provideCorporationTaxUniqueTaxpayerReference(uniqueTaxpayerReference)
      }

  }

  When("^I enter my company registered postcode as (.*) for the other entity type business$") { (postcode: String) =>
    OtherEntityPostcodePage
      .navigateTo()
    providePostcodeToRegisterCompany(postcode)
  }

  When("^I do not select an option for my UK unique taxpayer reference") { () =>
    UkUniqueTaxpayerPage
      .navigateTo()
      .submitPage()
  }

  When("^I do not select an option for my UK company registration number") { () =>
    DoYouHaveCrnPage
      .navigateTo()
      .submitPage()
  }

  When("^I enter my overseas tax identifier as (.*) for the Non-UK Establishment business$") {
    (overseasTaxIdentifier: String) =>
      OverseasTaxIdentifierPage
        .navigateTo()
      provideOverseasTaxIdentifier(overseasTaxIdentifier)
  }

  When("I enter my (.*)'s name as (.*)$") { (_: String, partnershipName: String) =>
    PartnershipNamePage
      .navigateTo()
    providePartnershipName(partnershipName)
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

  When("""I provide details of my limited company and indicate liability for previous year ECL""") { () =>
    provideAmlRegulated("No")
      .provideEclLiableForPreviousFinancialYear("Yes")
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
      provideAmlRegulated()
        .provideHmrcOrOtherAmlSupervisor()
        .provideRelevantAccountingPeriod()
        .provideUkRevenue()
        .provideEclLiableForPreviousFinancialYear(value)
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
    provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue("1020000")
      .provideEclLiableForPreviousFinancialYear(value)
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
    provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue("1020000")
      .provideEclLiableForPreviousFinancialYear(value)
  }

  When(
    "^I do not select an option for whether or not I liable to pay the ECL from 1 April 2022 to 31 March 2023"
  ) { () =>
    EclLiableForPreviousFinancialYearPage
      .navigateTo()
      .submitPage()
  }

  When("""I provide details of my (.*) and fail the GRS journey$""") { (entityType: String) =>
    provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue()
      .provideEclLiableForPreviousFinancialYear("Yes")
      .provideEntityType(entityType)
      .provideGrsDataForIdentifiersDoNotMatch()
      .provideGrsData()
  }

  And("^I click on the try again button") { () =>
    SharedActions.clickTryAgainButton()
  }

}
