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

package uk.gov.hmrc.test.ui.pages.registration

import uk.gov.hmrc.test.ui.conf.TestConfiguration
import uk.gov.hmrc.test.ui.pages.registration.BusinessSectorPage.cssForSaveAndContinue
import uk.gov.hmrc.test.ui.pages.{BasePage, SharedActions}

object RegistrationPage extends BasePage {

  val url =
    s"${TestConfiguration.url("economic-crime-levy-registration-frontend")}/register-for-economic-crime-levy/"

  def navigateTo(): this.type = {
    navigateToClearAllUrl()
    get(url)
    this
  }

  def startAndSignIn(): this.type = {
    submitPage()
    SharedActions.clickById("submit-top")
    this
  }

  def provideUkRevenue(value: String = "10200000"): this.type = {
    value match {
      case "1020000" =>
        SharedActions.enterDetails(value)
      case _         =>
        SharedActions.enterDetails(value)
    }
    onPage(EclLiableForPreviousFinancialYearPage.heading)
    this
  }

  def provideHmrcOrOtherAmlSupervisor(value: String = "HMRC"): this.type = {
    value match {
      case "Other" =>
        SharedActions.selectLabelByPartialText("Other")
        SharedActions.clickById("otherProfessionalBody")
        SharedActions.clickById("otherProfessionalBody__option--0")
      case _       =>
        SharedActions.selectLabelByPartialText(value)
    }
    submitPage()
    this
  }

  def provideRelevantAccountingPeriod(): this.type = {
    SharedActions
      .selectYesOrNo("Yes")
    onPage(UkRevenuePage.heading)
    this
  }

  def provideEclLiableForPreviousFinancialYear(value: String = "Yes"): this.type = {
    value match {
      case "No" =>
        SharedActions
          .selectYesOrNo(value)
      case _    =>
        SharedActions
          .selectYesOrNo(value)
    }
    this
  }

  def provideEntityType(value: String): this.type = {
    SharedActions.selectLabelByPartialText(value)
    submitPage()
    this
  }

  def provideGrsData(): this.type = {
    clickByCssSelector(cssForSaveAndContinue)
    this
  }

  def provideAmlRegulated(value: String = "Yes"): this.type = {
    value match {
      case "No" =>
        SharedActions
          .selectYesOrNo("No")
        onPage(EclLiableForPreviousFinancialYearPage.heading)
      case _    =>
        SharedActions
          .selectYesOrNo(value)
        onPage(AmlSupervisorPage.heading)
    }
    this
  }

  def provideBusinessSector(value: String): this.type = {
    SharedActions.selectLabelByPartialText(value)
    submitPage()
    onPage(FirstContactNamePage.heading)
    this
  }

  def provideFirstContactDetails(
    contactName: String,
    contactRole: String,
    emailAddress: String,
    contactNumber: String
  ): this.type = {
    SharedActions.enterDetails(contactName)
    SharedActions.enterDetails(contactRole)
    SharedActions.enterDetails(emailAddress)
    SharedActions.enterDetails(contactNumber)
    onPage(SecondContactNamePage.heading)
    this
  }

  def provideSecondContactDetails(
    contactName: String,
    contactRole: String,
    emailAddress: String,
    contactNumber: String
  ): this.type = {
    SharedActions
      .selectYesOrNo("Yes")
    SharedActions.enterDetails(contactName)
    SharedActions.enterDetails(contactRole)
    SharedActions.enterDetails(emailAddress)
    SharedActions.enterDetails(contactNumber)
    onPage(ContactAddressPage.heading)
    this
  }

  def provideRegisteredAddress(value: String): this.type = {
    SharedActions
      .selectYesOrNo(value)
    this
  }

  def provideChangeFirstContactDetails(): this.type = {
    ChangeContactDetailsPage
      .changeFirstContactName()
      .changeFirstContactRole()
      .changeFirstContactEmail()
      .changeFirstContactTelephoneNumber()
    this
  }

  def provideChangeSecondContactDetails(): this.type = {
    ChangeContactDetailsPage
      .changeSecondContactName()
      .changeSecondContactRole()
      .changeSecondContactEmail()
      .changeSecondContactTelephoneNumber()
    this
  }

  def provideChangeSecondaryContact(): this.type = {
    ChangeContactDetailsPage
      .changeSecondaryContact()
    this
  }

  def provideChangeRegisteredAddress(): this.type = {
    ChangeContactDetailsPage
      .changeRegisteredAddress()
    this
  }

  def provideChangeOrganisationDetails(): this.type = {
    ChangeOrganisationDetails
      .changeBusinessSector()
      .changeAmlSupervisor()
      .changeUkRevenue()
      .changeAccountingPeriod()
    this
  }
  def provideChangeAmlRegulatedActivity(): this.type = {
    ChangeOrganisationDetails
      .changeAmlRegulatedActivity()
    this
  }

  def provideChangeEntityType(): this.type = {
    ChangeOrganisationDetails
      .changeEntityType()
    this
  }

  def provideCheckYourAnswers(): this.type = {
    submitPage()
    this
  }

  def provideEntityTypeDetailsForGeneralOrScottishPartnership(value: String): this.type = {
    SharedActions.selectLabelByPartialText(value)
    submitPage()
    clickByCssSelector(cssForSaveAndContinue)
    SharedActions
      .enterDetails("A & J Company12")
    onPage(BusinessSectorPage.heading)
    this
  }

  def provideAddAnotherContactYesOrNo(value: String): this.type = {
    SharedActions
      .selectYesOrNo(value)
    this
  }

  def provideAnotherUkRegisteredAddress(value: String): this.type = {
    SharedActions
      .selectYesOrNo(value)
    this
  }

  def provideNonUkRegisteredAddress(value: String): this.type = {
    SharedActions
      .selectYesOrNo(value)
    this
  }

  def providePartnershipName(partnershipName: String): this.type = {
    SharedActions
      .enterDetails(partnershipName)
    this
  }

  def provideFirstContactName(contactName: String): this.type = {
    FirstContactNamePage
      .navigateTo()
    SharedActions
      .enterDetails(contactName)
    this
  }

  def provideFirstContactRole(contactRole: String): this.type = {
    SharedActions
      .enterDetails(contactRole)
    this
  }

  def provideFirstContactEmail(emailAddress: String): this.type = {
    SharedActions
      .enterDetails(emailAddress)
    this
  }

  def provideFirstContactTelephoneNumber(contactNumber: String): this.type = {
    SharedActions
      .enterDetails(contactNumber)
    this
  }

  def provideOtherEntityBusinessDetails(otherEntityType: String): this.type = {
    otherEntityType match {
      case "Charity"                    =>
        RegistrationPage
          .provideOtherEntityName("Charity")
          .provideRegisteredNameOfYourBusiness("ABC Company")
          .provideCharityRegistrationNumberOfYourBusiness("1234567")
          .doYouHaveUniqueTaxpayerReference("Yes")
          .provideCompanyRegistrationNumberOfYourBusiness("12345678")
      case "Unincorporated Association" =>
        RegistrationPage
          .provideOtherEntityName("Unincorporated Association")
          .provideRegisteredNameOfYourBusiness("OC Limited")
          .doYouHaveCorporationTaxUniqueTaxpayerReference("Yes")
          .provideCorporationTaxUniqueTaxpayerReference("0123456789")
          .providePostcodeToRegisterCompany("AB1 2YZ")
      case "Trust"                      =>
        RegistrationPage
          .provideOtherEntityName("Trust")
          .provideRegisteredNameOfYourBusiness("St Johns MTC Trust")
          .provideCorporationTaxUniqueTaxpayerReference("0123456789")
      case _                            =>
        RegistrationPage
          .provideOtherEntityName("Non-UK Establishment")
          .provideRegisteredNameOfYourBusiness("Non UK Company")
          .doYouHaveUkCompanyRegistrationNumber("Yes")
          .provideUkUniqueTaxpayerReference()
    }
    this
  }

  def provideOtherEntityName(otherEntityName: String): this.type = {
    SharedActions
      .selectLabelByPartialText(otherEntityName)
    submitPage()
    this
  }
  def provideRegisteredNameOfYourBusiness(businessName: String): this.type = {
    SharedActions
      .enterDetails(businessName)
    this
  }

  def provideCharityRegistrationNumberOfYourBusiness(charityRegistrationNumber: String): this.type = {
    SharedActions
      .enterDetails(charityRegistrationNumber)
    this
  }

  def provideCompanyRegistrationNumberOfYourBusiness(companyRegistrationNumber: String): this.type = {
    SharedActions
      .enterDetails(companyRegistrationNumber)
    this
  }

  def provideCorporationTaxUniqueTaxpayerReference(uniqueTaxpayerReference: String): this.type = {
    SharedActions
      .enterDetails(uniqueTaxpayerReference)
    this
  }

  def doYouHaveCorporationTaxUniqueTaxpayerReference(value: String): this.type = {
    SharedActions
      .selectYesOrNo(value)
    this
  }

  def doYouHaveUkCompanyRegistrationNumber(value: String = "Yes"): this.type = {
    value match {
      case "No" =>
        SharedActions
          .selectYesOrNo(value)
      case _    =>
        SharedActions
          .selectYesOrNo(value)
        provideCompanyRegistrationNumberOfYourBusiness("12345678")
    }
    this
  }

  def providePostcodeToRegisterCompany(postcode: String): this.type = {
    SharedActions
      .enterDetails(postcode)
    this
  }

  def provideUkUniqueTaxpayerReference(
    value: String = "Self Assessment (SA) Unique Taxpayer Reference (UTR)"
  ): this.type = {
    value match {
      case "Company Tax (CT) Unique Taxpayer Reference (UTR)" =>
        SharedActions.selectLabelByPartialText("Company Tax (CT) Unique Taxpayer Reference (UTR)")
        submitPage()
        provideCorporationTaxUniqueTaxpayerReference("1234567890")
      case _                                                  =>
        SharedActions.selectLabelByPartialText(value)
        submitPage()
        provideSelfAssessmentTaxpayerReference("0123456789")
    }
    this
  }

  def provideSelfAssessmentTaxpayerReference(uniqueTaxpayerReference: String): this.type = {
    SharedActions
      .enterDetails(uniqueTaxpayerReference)
    this
  }
  def provideOverseasTaxIdentifier(overseasTaxIdentifier: String): this.type = {
    SharedActions
      .enterDetails(overseasTaxIdentifier)
    this
  }
  def provideOtherEntityCheckYourAnswers(): this.type = {
    submitPage()
    this
  }

  def provideSelectYesOrNo(value: String): this.type = {
    SharedActions
      .selectYesOrNo(value)
    this
  }

  def provideAmendHmrcOrOtherAmlSupervisor(): this.type = {
    onPage(AmendmentPage.heading)
    SharedActions.clickById("value_0")
    submitPage()
    this
  }

  def submitPage(): this.type = {
    SharedActions.clickButton()
    this
  }

  def provideGrsDataForIdentifiersDoNotMatch(): this.type = {
    SharedActions.clickById("registrationNotCalledIdentifierMismatch")
    this
  }

  def doYouHaveUniqueTaxpayerReference(value: String): this.type = {
    value match {
      case "No" =>
        SharedActions
          .selectYesOrNo(value)
      case _    =>
        SharedActions
          .selectYesOrNo(value)
        provideUtrReference("0123456789")
    }
    this
  }

  def provideUtrReference(companyRegistrationNumber: String): this.type = {
    SharedActions
      .enterDetails(companyRegistrationNumber)
    this
  }

  def provideAnswerToCancelAmendment(value: String = "Yes"): this.type = {
    value match {
      case "No" =>
        SharedActions
          .selectYesOrNo(value)
      case _    =>
        SharedActions
          .selectYesOrNo(value)
    }
    this
  }
}
