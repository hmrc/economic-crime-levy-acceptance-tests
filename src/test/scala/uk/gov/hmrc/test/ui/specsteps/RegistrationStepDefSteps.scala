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


  def givenIAmSignedInToTheRegistrationJourney(): Unit =
    RegistrationPage
      .navigateTo()
      .startAndSignIn()


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


  def whenIProvideDetailsOfMyLimitedCompanyThatIsSupervisedByAnOtherProfessionalBodyAndLiableForECL(): Unit =
    provideUkRevenue()
      .provideHmrcOrOtherAmlSupervisor("Other")
      .provideEntityType("Limited company")
      .provideGrsData()


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


  def andIGoToCheckYourAnswersPageDirectlyWithoutProvidingAnswersForAnyOfThePreviousPageQuestions(): Unit =
    CheckYourAnswersPage
      .navigateTo()


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


  def whenISelectXOnWhetherOrNotToAddASecondaryContactDetails(value: String): Unit =
    SharedActions
      .selectYesOrNo(value)


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


  def whenISelectXOnWhetherOrNotToUseADifferentUKAddressAsMyMainContactAddress(value: String): Unit =
    provideNonUkRegisteredAddress(value)
      .submitPage()


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


  def whenIEnterMyOverseasTaxIdentifierAsXForTheNonUKEstablishmentBusiness(overseasTaxIdentifier: String): Unit = {
    OverseasTaxIdentifierPage
      .navigateTo()
    provideOverseasTaxIdentifier(overseasTaxIdentifier)
  }


  def thenIShouldSeeAnErrorThatSaysX(value: String): Unit =
    SharedActions.assertPartialTextIsDisplayed(value)


  def thenIShouldBeOnThePageThatSaysX(value: String): Unit =
    SharedActions.assertPartialTextIsDisplayed(value)


  def thenIShouldBeOnThePageThatDisplaysX(value: String): Unit =
    SharedActions.penaltyInformation(value)


  def thenIShouldBeOnThePlaceholderPageThatMentionsAnOverduePaymentForPreviousYearECL(): Unit = {
    val assertion = "1 April " + 2023 + " to 31 March " + 2024
    print("previous Year ECL should be:  1 April 2022 to 31 March 2023   this assertion is: " + assertion)
    SharedActions.assertPartialTextIsDisplayed(assertion)
  }


  def thenIShouldBeOnThePlaceholderPageThatMentionsAnOverduePaymentForCurrentYearECL(): Unit = {
    val assertion = "1 April " + (eclStartYear + 1) + " to 31 March " + eclStartYear
    print("current Year ECL should be: 1 April 2023 to 31 March 2024 this one is: " + assertion)
    SharedActions.assertPartialTextIsDisplayed(assertion)
  }


  def thenIShouldBeOnThePlaceholderPageThatSaysX(value: String): Unit =
    SharedActions.assertHtmlContains(value)


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


  def whenIProvideYesToAMLQuestionAndTheTurnoverIsBelowThresholdButXLiabilityForPreviousYearECL(value: String): Unit =
    areYouRegisteringForCurrentFinancialYear()
      .provideAmlRegulated()
      .provideHmrcOrOtherAmlSupervisor()
      .provideRelevantAccountingPeriod()
      .provideUkRevenue("1020000")
      .provideEclLiableForPreviousFinancialYear(value)


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


  def whenIProvideTheDetailsToAmendTheSubmittedEconomicCrimeLevyRegistration(): Unit = {
    AccountPage
      .provideAmendAnEclRegistration()
    SharedActions
      .enterDetails("Amending registration details")
    RegistrationPage
      .provideChangeFirstContactDetails()
  }


  def andIDecideToCancelThisAmendments(): Unit =
    AmendmentPage
      .provideCancelAmendment()
      .provideSelectYesOrNo()


  def andIClickOnTheTryAgainButton(): Unit =
    SharedActions.clickTryAgainButton()


  def andTheAmendedRegistrationInformationShouldDisplayUnderAmendedAnswersOnTheCheckYourAnswersPage(
    arg: Map[String, String]
  ): Unit =
    assertAmendedRegistrationAnswers(arg)
      .submitPage()
















  def whenIProvideTheDetailsToAmendTheLiabilityStartDateForRegistration(): Unit = {
    AccountPage
      .provideAmendAnEclRegistration()
    SharedActions
      .enterDetails("Amending the liability start date to previous FY")
    RegistrationPage
      .provideChangeLiabilityStartDate()
      .submitPage()
  }


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


  def andIReturnToTheServiceToCompleteTheRegistration(): Unit =
    provideRegistrationSubmissionAfterTimeout()
      .submitPage()


  def andIShouldBeAbleToResumeTheRegistrationFromWhereILeftOff(): Unit =
    SharedActions
      .selectContinueWithSavedAnswers()
      .submitPage()


  def whenISelectXOnWhetherOrNotICarriedOutAMLregulatedActivityInCurrentFYAndInPreviousFY(value: String): Unit = {
    AmlRegulatedActivityPage
      .navigateTo()
    SharedActions
      .selectYesOrNo(value)
    SharedActions
      .selectYesOrNo(value)
  }

}
