package uk.gov.hmrc.test.ui.specsteps
import uk.gov.hmrc.test.ui.pages.enrolment.EnrolmentPage

object EnrolmentStepDefSteps {

  // I am signed in to the enrolment journey
  def givenIAmSignedInToTheEnrolmentJourney(): Unit = {
    EnrolmentPage
          .navigateTo()
          .startAndSignIn()
  }

  // I provide the details of my ECL reference number
  def whenIProvideTheDetailsOfMyECLReferenceNumber(): Unit = {
    EnrolmentPage
          .selectEclReferenceNumber("Yes")
          .provideEclReferenceNumber("XMECL0000000001")
          .provideEclRegistrationDate(registrationDate = "01", registrationMonth = "03", registrationYear = "2023")
  }

  // ^I select (No|Unknown) option for whether or not I have the ECL reference number$
  def whenISelectNoorUnknownOptionForWhetherOrNotIHaveTheECLReferenceNumber(value: String): Unit = {
    EnrolmentPage
          .selectEclReferenceNumber(value)
  }

  // ^I enter the economic crime levy reference number (.*)$
  def whenIEnterTheEconomicCrimeLevyReferenceNumberX(eclReferenceNumber: String): Unit = {
    EnrolmentPage
          .provideInvalidEclReferenceNumber(eclReferenceNumber)
  }

  // ^I enter the ECL registration date day as (.*) month as (.*) and year as (.*)$
  def whenIEnterTheECLRegistrationDateDayAsXMonthAsXAndYearAsX(day: String, month: String, year: String): Unit = {
    EnrolmentPage
            .selectEclReferenceNumber("Yes")
            .provideEclReferenceNumber("XMECL0000000001")
          EnrolmentPage
            .provideEclRegistrationDate(day, month, year)
  }

}
