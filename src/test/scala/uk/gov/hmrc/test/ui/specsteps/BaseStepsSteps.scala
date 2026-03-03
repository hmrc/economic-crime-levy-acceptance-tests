package uk.gov.hmrc.test.ui.specsteps

import uk.gov.hmrc.test.ui.pages.BasePage
import uk.gov.hmrc.test.ui.pages.SharedActions.{clickBackButton, clickButton}

object BaseStepsSteps {

  // ^I click on the Back link$
  def thenIClickOnTheBackLink(): Unit = {
    clickBackButton()
  }

  // ^I click the Save and continue button$
  def thenIClickTheSaveAndContinueButton(): Unit = {
    clickButton()
  }

}
