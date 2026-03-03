package uk.gov.hmrc.test.ui.specsteps
import uk.gov.hmrc.test.ui.pages.SharedActions
import uk.gov.hmrc.test.ui.pages.deregistration.DeRegistrationPage
import uk.gov.hmrc.test.ui.pages.deregistration.DeRegistrationPage._
import uk.gov.hmrc.test.ui.utils.DateUtil

import java.time.LocalDate.now

object DeRegistrationStepDefSteps {

  // ^I should see the de registered ECL reference number as (.*)$
  def thenIShouldSeeTheDeRegisteredECLReferenceNumberAsX(value: String): Unit = {
    SharedActions.assertEclReferenceNumber(value)
  }

  // I click on the View or amend your returns or View your payments link to view the deregistered (.*) details$
  def whenIClickOnTheViewOrAmendYourReturnsOrViewYourPaymentsLinkToViewTheDeregisteredXDetails(linkName: String): Unit = {
    ProvideViewEclAccountAfterDeRegistration(linkName)
  }

  // the links (.*) under the Action column should be visible on the the page$
  def whenTheLinksXUnderTheActionColumnShouldBeVisibleOnTheThePage(linkName: String): Unit = {
    getPaymentAndReturnLinks(linkName)
  }

  // I provide the details to de register the ECL account from the system
  def whenIProvideTheDetailsToDeRegisterTheECLAccountFromTheSystem(): Unit = {
    DeRegistrationPage
          .provideEclDeRegistration()
          .submitPage()
          .provideReasonForDeRegistering()
          .provideEclDeRegistrationDate(
            deRegistrationDate = (now.getDayOfMonth - 1).toString,
            deRegistrationMonth = now.getMonthValue.toString,
            deRegistrationYear = now.getYear.toString
          )
          .provideDeRegistrationFirstContactDetails("Tom Oliver", "Director", "verify@oc.com", "01632 000 001")
          .submitPage()
  }

}
