/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.test.ui.specsteps
import uk.gov.hmrc.test.ui.specpage.SharedActions
import uk.gov.hmrc.test.ui.specpage.account.AccountPage
import uk.gov.hmrc.test.ui.specpage.registration.RegistrationPage._
import uk.gov.hmrc.test.ui.specpage.registration._

object RegistrationStepDefSteps {

  val eclStartYear = previousEclTaxYearStartYear.getYear

  // I am signed in to the registration journey
  def givenIAmSignedInToTheRegistrationJourney(): Unit =
    RegistrationPage
      .navigateTo()
      .startAndSignIn()

  // I provide details of my (.*) that is supervised by HMRC and liable for current ECL$
  def whenIProvideDetailsOfMyXThatIsSupervisedByHMRCAndLiableForCurrentECL(entityType: String): Unit =
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

  // I provide details of my limited company that is supervised by an other professional body and liable for ECL
  def whenIProvideDetailsOfMyLimitedCompanyThatIsSupervisedByAnOtherProfessionalBodyAndLiableForECL(): Unit =
    provideUkRevenue()
      .provideHmrcOrOtherAmlSupervisor("Other")
      .provideEntityType("Limited company")
      .provideGrsData()

  // I provide the details of another UK address as my main contact address
  def andIProvideTheDetailsOfAnotherUKAddressAsMyMainContactAddress(): Unit =
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

  // I provide the details of a non UK address as my main contact address
  def andIProvideTheDetailsOfANonUKAddressAsMyMainContactAddress(): Unit =
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

  // I go to check your answers page directly without providing answers for any of the previous page questions
  def andIGoToCheckYourAnswersPageDirectlyWithoutProvidingAnswersForAnyOfThePreviousPageQuestions(): Unit =
    CheckYourAnswersPage
      .navigateTo()

  // I click on the change link and edit my contact details
  def whenIClickOnTheChangeLinkAndEditMyContactDetails(): Unit =
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

  // I click on the change link to modify my secondary contact
  def whenIClickOnTheChangeLinkToModifyMySecondaryContact(): Unit =
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

  // I select (.*) on whether or not to add a secondary contact details$
  def whenISelectXOnWhetherOrNotToAddASecondaryContactDetails(value: String): Unit =
    SharedActions
      .selectYesOrNo(value)

  // I click on the change link to modify the registered address
  def whenIClickOnTheChangeLinkToModifyTheRegisteredAddress(): Unit =
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

  // I select (.*) on whether or not to use a different UK address as my main contact address$
  def whenISelectXOnWhetherOrNotToUseADifferentUKAddressAsMyMainContactAddress(value: String): Unit =
    provideNonUkRegisteredAddress(value)
      .submitPage()

  // I click on the change link and edit my organisation details
  def whenIClickOnTheChangeLinkAndEditMyOrganisationDetails(): Unit =
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

  // I click on the change link and select (.*) on whether or not I carried out AML-regulated activity in current FY$
  def whenIClickOnTheChangeLinkAndSelectXOnWhetherOrNotICarriedOutAMLregulatedActivityInCurrentFY(value: String): Unit =
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

  // I click on the change link and select the new entity type
  def whenIClickOnTheChangeLinkAndSelectTheNewEntityType(): Unit =
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

  // I select my entity type as (.*) and provide the registration details$
  def whenISelectMyEntityTypeAsXAndProvideTheRegistrationDetails(entityType: String): Unit =
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

  // I provide details of my other entity is (.*) that is supervised by HMRC and liable for ECL$
  def whenIProvideDetailsOfMyOtherEntityIsXThatIsSupervisedByHMRCAndLiableForECL(otherEntityType: String): Unit =
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

  // ^I enter my overseas tax identifier as (.*) for the Non-UK Establishment business$
  def whenIEnterMyOverseasTaxIdentifierAsXForTheNonUKEstablishmentBusiness(overseasTaxIdentifier: String): Unit = {
    OverseasTaxIdentifierPage
      .navigateTo()
    provideOverseasTaxIdentifier(overseasTaxIdentifier)
  }

  // ^I should see an error that says (.*)$
  def thenIShouldSeeAnErrorThatSaysX(value: String): Unit =
    SharedActions.assertPartialTextIsDisplayed(value)

  // ^I should be on the page that says (.*)$
  def thenIShouldBeOnThePageThatSaysX(value: String): Unit =
    SharedActions.assertPartialTextIsDisplayed(value)

  // ^I should be on the page that displays (.*)$
  def thenIShouldBeOnThePageThatDisplaysX(value: String): Unit =
    SharedActions.penaltyInformation(value)

  // I should be on the placeholder page that mentions an overdue payment for previousYearECL
  def thenIShouldBeOnThePlaceholderPageThatMentionsAnOverduePaymentForPreviousYearECL(): Unit = {
    val assertion = "1 April " + 2023 + " to 31 March " + 2024
    print("previous Year ECL should be:  1 April 2022 to 31 March 2023   this assertion is: " + assertion)
    SharedActions.assertPartialTextIsDisplayed(assertion)
  }

  // I should be on the placeholder page that mentions an overdue payment for currentYearECL
  def thenIShouldBeOnThePlaceholderPageThatMentionsAnOverduePaymentForCurrentYearECL(): Unit = {
    val assertion = "1 April " + (eclStartYear + 1) + " to 31 March " + eclStartYear
    print("current Year ECL should be: 1 April 2023 to 31 March 2024 this one is: " + assertion)
    SharedActions.assertPartialTextIsDisplayed(assertion)
  }

  // ^I should be on the placeholder page that says (.*)$
  def thenIShouldBeOnThePlaceholderPageThatSaysX(value: String): Unit =
    SharedActions.assertHtmlContains(value)

  // I provide details of my limited company and indicate liability for previous year ECL
  def whenIProvideDetailsOfMyLimitedCompanyAndIndicateLiabilityForPreviousYearECL(): Unit =
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

  // I provide Yes to AML question and the turnover is £10.2m and above and (.*) liable for previous FY$
  def whenIProvideYesToAMLQuestionAndTheTurnoverIsmAndAboveAndXLiableForPreviousFY(value: String): Unit =
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

  // I provide Yes to AML question and the turnover is below £10.2m threshold and (.*) liable for previous FY$
  def whenIProvideYesToAMLQuestionAndTheTurnoverIsBelowThresholdAndXLiableForPreviousFY(value: String): Unit =
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

  // I provide Yes to AML question and the turnover is below £10.2m threshold but (.*) liability for previous year ECL$
  def whenIProvideYesToAMLQuestionAndTheTurnoverIsBelowThresholdButXLiabilityForPreviousYearECL(value: String): Unit =
    areYouRegisteringForCurrentFinancialYear()
      .provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue("1020000")
      .provideEclLiableForPreviousFinancialYear(value)

  // I provide details of my (.*) and fail the GRS journey$
  def whenIProvideDetailsOfMyXAndFailTheGRSJourney(entityType: String): Unit =
    areYouRegisteringForCurrentFinancialYear()
      .provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue()
      .areYouLiableForPreviousFinancialYear()
      .provideEntityType(entityType)
      .provideGrsDataForIdentifiersDoNotMatch()
      .provideGrsData()

  // I provide the details to amend the submitted economic crime levy registration
  def whenIProvideTheDetailsToAmendTheSubmittedEconomicCrimeLevyRegistration(): Unit = {
    AccountPage
      .provideAmendAnEclRegistration()
    SharedActions
      .enterDetails("Amending registration details")
    RegistrationPage
      .provideChangeFirstContactDetails()
  }

  // ^I decide to cancel this amendments
  def andIDecideToCancelThisAmendments(): Unit =
    AmendmentPage
      .provideCancelAmendment()
      .provideSelectYesOrNo()

  // ^I click on the try again button
  def andIClickOnTheTryAgainButton(): Unit =
    SharedActions.clickTryAgainButton()

  // the amended registration information should display under Amended answers on the Check your answers page$
  def andTheAmendedRegistrationInformationShouldDisplayUnderAmendedAnswersOnTheCheckYourAnswersPage(
    arg: Map[String, String]
  ): Unit =
    assertAmendedRegistrationAnswers(arg)
      .submitPage()

  // Overload for ScalaTest (no DataTable, accepts varargs)
//  def andTheAmendedRegistrationInformationShouldDisplayUnderAmendedAnswersOnTheCheckYourAnswersPage(links: (String, String)*): Unit = {
//    links.foreach { case (text, url) =>
//      val driverWait: WebDriverWait =
//        new WebDriverWait(Driver.instance, Duration.ofSeconds(10), Duration.ofSeconds(1))
//      driverWait.until(
//        ExpectedConditions.elementToBeClickable(
//          Driver.instance.findElement(By.id(url))
//        )
//      )
//      verifyLinkById(url, text)
//    }
//  }

  // I provide the details to amend the liability start date for registration
  def whenIProvideTheDetailsToAmendTheLiabilityStartDateForRegistration(): Unit = {
    AccountPage
      .provideAmendAnEclRegistration()
    SharedActions
      .enterDetails("Amending the liability start date to previous FY")
    RegistrationPage
      .provideChangeLiabilityStartDate()
      .submitPage()
  }

  // I provide some details for the economic crime levy registration and experience a system timeout
  def whenIProvideSomeDetailsForTheEconomicCrimeLevyRegistrationAndExperienceASystemTimeout(): Unit =
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

  // I return to the service to complete the registration
  def andIReturnToTheServiceToCompleteTheRegistration(): Unit =
    provideRegistrationSubmissionAfterTimeout()
      .submitPage()

  // I should be able to resume the registration from where I left off
  def andIShouldBeAbleToResumeTheRegistrationFromWhereILeftOff(): Unit =
    SharedActions
      .selectContinueWithSavedAnswers()
      .submitPage()

  // ^I select (.*) on whether or not I carried out AML-regulated activity in current FY and in previous FY$
  def whenISelectXOnWhetherOrNotICarriedOutAMLregulatedActivityInCurrentFYAndInPreviousFY(value: String): Unit = {
    AmlRegulatedActivityPage
      .navigateTo()
    SharedActions
      .selectYesOrNo(value)
    SharedActions
      .selectYesOrNo(value)
  }

}
