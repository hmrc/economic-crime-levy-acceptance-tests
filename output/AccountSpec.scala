package uk.gov.hmrc.test.ui.spec

import org.scalatest.matchers.should.Matchers
import org.scalatest.featurespec.AnyFeatureSpec

class AccountSpec extends BaseSpec with Matchers {

  Feature("ECL Dashboard details") {

    Scenario("1. User that is registered for ECL can view the information about returns on ECL dashboard") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000005")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000005")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("I should be on the page that says Your Economic Crime Levy account")
        thenIShouldBeOnThePageThatSaysX("Your Economic Crime Levy account")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("2. User is able to submit most recent returns") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000005")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000005")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I click on the Submit an Economic Crime Levy return link")
        whenIClickOnTheSubmitAnEconomicCrimeLevyReturnLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I provide the details to submit the economic crime levy return")
        whenIProvideTheDetailsToSubmitTheEconomicCrimeLevyReturn()  // auto-chosen (score=1.00, ReturnsStepDefSteps.scala)

      Then("I should be on the page that says Return submitted")
        thenIShouldBeOnThePageThatSaysX("Return submitted")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("3.User is able to see their returns details for the previous and current financial years [return status=OVERDUE]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000005")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000005")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I click on the View or amend your returns link to view the OVERDUE return details")
        // ⚠️ No step-def match found for: I click on the View or amend your returns link to view the OVERDUE return details

      Then("I should be on the page that says Your Economic Crime Levy returns")
        thenIShouldBeOnThePageThatSaysX("Your Economic Crime Levy returns")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I should see the return status as OVERDUE")
        whenIShouldSeeTheReturnStatusAsX("OVERDUE")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

    }

    Scenario("3.User is able to see their returns details for the previous and current financial years [return status=SUBMITTED]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000005")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000005")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I click on the View or amend your returns link to view the SUBMITTED return details")
        // ⚠️ No step-def match found for: I click on the View or amend your returns link to view the SUBMITTED return details

      Then("I should be on the page that says Your Economic Crime Levy returns")
        thenIShouldBeOnThePageThatSaysX("Your Economic Crime Levy returns")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I should see the return status as SUBMITTED")
        whenIShouldSeeTheReturnStatusAsX("SUBMITTED")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

    }

    Scenario("4. User that is registered for ECL can make a returns submission through ECL dashboard") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000005")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000005")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I provide the registration details to submit a return through ECL dashboard link")
        whenIProvideTheRegistrationDetailsToSubmitAReturnThroughECLDashboardLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("I should be on the page that says ECL registration details")
        thenIShouldBeOnThePageThatSaysX("ECL registration details")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("5. User that is registered for ECL can view their completed payments") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000005")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000005")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("I should be on the page that says You have no payments due.")
        thenIShouldBeOnThePageThatSaysX("You have no payments due.")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("6. User that is registered for ECL can view their overdue payments") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000007")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000007")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("I should be on the placeholder page that mentions an overdue payment for previousYearECL")
        thenIShouldBeOnThePlaceholderPageThatMentionsAnOverduePaymentForPreviousYearECL()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I should be on the page that says We are charging you interest on this payment. You owe £20,500.")
        thenIShouldBeOnThePageThatSaysX("We are charging you interest on this payment. You owe £20,500.")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("7. User is able to see their payment details for the previous and current financial years [ECL Reference Number=XMECL0000000007, payment status=OVERDUE, Amount=20500]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000007")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000007")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I click on the View your payments link to view the OVERDUE payment details")
        andIClickOnTheViewYourPaymentsLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("I should be on the page that says Your Economic Crime Levy payments")
        thenIShouldBeOnThePageThatSaysX("Your Economic Crime Levy payments")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I should see the OVERDUE payment amount 20500")
        andIShouldSeeTheXPaymentAmountX("OVERDUE", "20500")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I should see the payment status as OVERDUE")
        whenIShouldSeeThePaymentStatusAsX("OVERDUE")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

    }

    Scenario("7. User is able to see their payment details for the previous and current financial years [ECL Reference Number=XMECL0000000007, payment status=PARTIALLY PAID, Amount=2400]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000007")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000007")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I click on the View your payments link to view the PARTIALLY PAID payment details")
        andIClickOnTheViewYourPaymentsLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("I should be on the page that says Your Economic Crime Levy payments")
        thenIShouldBeOnThePageThatSaysX("Your Economic Crime Levy payments")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I should see the PARTIALLY PAID payment amount 2400")
        andIShouldSeeTheXPaymentAmountX("PARTIALLY PAID", "2400")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I should see the payment status as PARTIALLY PAID")
        whenIShouldSeeThePaymentStatusAsX("PARTIALLY PAID")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

    }

    Scenario("7. User is able to see their payment details for the previous and current financial years [ECL Reference Number=XMECL0000000005, payment status=PAID, Amount=14000]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000005")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000005")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I click on the View your payments link to view the PAID payment details")
        andIClickOnTheViewYourPaymentsLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("I should be on the page that says Your Economic Crime Levy payments")
        thenIShouldBeOnThePageThatSaysX("Your Economic Crime Levy payments")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      And("I should see the PAID payment amount 14000")
        andIShouldSeeTheXPaymentAmountX("PAID", "14000")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I should see the payment status as PAID")
        whenIShouldSeeThePaymentStatusAsX("PAID")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

    }

    Scenario("8. User is able to see the payment service page for make an ECL payment") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000007")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000007")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I click on the Make an ECL payment link to pay the OVERDUE payment")
        // ⚠️ No step-def match found for: I click on the Make an ECL payment link to pay the OVERDUE payment

      Then("I should be on the page that says Select an amount to pay")
        thenIShouldBeOnThePageThatSaysX("Select an amount to pay")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("9. User without overdue payment views their ECL dashboard and see the interest payment as the most urgent payment to be made") {
      Given("I am signed in to the account journey with my ECL reference as XMECL00000000010")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL00000000010")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I should be on the page that says You owe an interest payment. Interest will continue to be accrued if not paid.")
        thenIShouldBeOnThePageThatSaysX("You owe an interest payment. Interest will continue to be accrued if not paid.")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("10. User clicks View Payment for partially-paid interest") {
      Given("I am signed in to the account journey with my ECL reference as XMECL00000000014")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL00000000014")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I click on the View your payments link to view my interest charge")
        whenIClickOnTheViewYourPaymentsLinkToViewMyX("interest charge")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)
        // --- Other possible matches ---
        // andIClickOnTheViewYourPaymentsLink() [1.00] (AccountStepDefSteps.scala) pattern: I click on the View your payments link

      Then("the interest row should display the partial interest payment information under Payments you owe")
        thenTheInterestRowShouldDisplayThePartialInterestPaymentInformationUnderPaymentsYouOwe(null)  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

    }

    Scenario("11. User clicks View Payment for fully paid interest") {
      Given("I am signed in to the account journey with my ECL reference as XMECL00000000011")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL00000000011")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I should be on the page that says You have no payments due.")
        thenIShouldBeOnThePageThatSaysX("You have no payments due.")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I click on the View your payments link to view my fully paid interest")
        whenIClickOnTheViewYourPaymentsLinkToViewMyX("fully paid interest")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)
        // --- Other possible matches ---
        // andIClickOnTheViewYourPaymentsLink() [1.00] (AccountStepDefSteps.scala) pattern: I click on the View your payments link

      Then("I click on the Back link")
        thenIClickOnTheBackLink()  // auto-chosen (score=1.00, BaseStepsSteps.scala)

      Then("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I click on the View your payments link to view my fully paid interest")
        whenIClickOnTheViewYourPaymentsLinkToViewMyX("fully paid interest")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)
        // --- Other possible matches ---
        // andIClickOnTheViewYourPaymentsLink() [1.00] (AccountStepDefSteps.scala) pattern: I click on the View your payments link

      Then("the interest row should display the fully paid interest payment information under Payment History")
        thenTheInterestRowShouldDisplayTheFullyPaidInterestPaymentInformationUnderPaymentHistory(null)  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

    }

    Scenario("12. User clicks View Payment to see the overdue payment information") {
      Given("I am signed in to the account journey with my ECL reference as XMECL00000000012")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL00000000012")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I should be on the placeholder page that mentions an overdue payment for previousYearECL")
        thenIShouldBeOnThePlaceholderPageThatMentionsAnOverduePaymentForPreviousYearECL()  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

      When("I click on the View your payments link to view my overdue")
        whenIClickOnTheViewYourPaymentsLinkToViewMyX("overdue")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)
        // --- Other possible matches ---
        // andIClickOnTheViewYourPaymentsLink() [1.00] (AccountStepDefSteps.scala) pattern: I click on the View your payments link

      Then("the overdue row should display the overdue payment information under Payment you owe")
        thenTheOverdueRowShouldDisplayTheOverduePaymentInformationUnderPaymentYouOwe(null)  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I click make a payment link to pay the overdue payment")
        andIClickMakeAPaymentLinkToPayTheOverduePayment()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("I should be on the page that says Select an amount to pay")
        thenIShouldBeOnThePageThatSaysX("Select an amount to pay")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("13. User clicks View your Payment to ensure the penalty payment information is not displayed [ECL Reference Number=XMECL0000000003]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000003")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000003")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I click on the View your payments link")
        andIClickOnTheViewYourPaymentsLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("the penalty data should not be displayed")
        thenThePenaltyDataShouldNotBeDisplayed(null)  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

    }

    Scenario("13. User clicks View your Payment to ensure the penalty payment information is not displayed [ECL Reference Number=XMECL0000000029]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000029")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000029")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I click on the View your payments link")
        andIClickOnTheViewYourPaymentsLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("the penalty data should not be displayed")
        thenThePenaltyDataShouldNotBeDisplayed(null)  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

    }

    Scenario("13. User clicks View your Payment to ensure the penalty payment information is not displayed [ECL Reference Number=XMECL0000000027]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000027")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000027")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I click on the View your payments link")
        andIClickOnTheViewYourPaymentsLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("the penalty data should not be displayed")
        thenThePenaltyDataShouldNotBeDisplayed(null)  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

    }

    Scenario("13. User clicks View your Payment to ensure the penalty payment information is not displayed [ECL Reference Number=XMECL0000000026]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000026")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000026")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I click on the View your payments link")
        andIClickOnTheViewYourPaymentsLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("the penalty data should not be displayed")
        thenThePenaltyDataShouldNotBeDisplayed(null)  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

    }

    Scenario("13. User clicks View your Payment to ensure the penalty payment information is not displayed [ECL Reference Number=XMECL0000000025]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000025")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000025")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I click on the View your payments link")
        andIClickOnTheViewYourPaymentsLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("the penalty data should not be displayed")
        thenThePenaltyDataShouldNotBeDisplayed(null)  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

    }

    Scenario("13. User clicks View your Payment to ensure the penalty payment information is not displayed [ECL Reference Number=XMECL0000000024]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000024")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000024")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I click on the View your payments link")
        andIClickOnTheViewYourPaymentsLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("the penalty data should not be displayed")
        thenThePenaltyDataShouldNotBeDisplayed(null)  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

    }

    Scenario("13. User clicks View your Payment to ensure the penalty payment information is not displayed [ECL Reference Number=XMECL0000000028]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000028")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000028")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I click on the View your payments link")
        andIClickOnTheViewYourPaymentsLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      Then("the penalty data should not be displayed")
        thenThePenaltyDataShouldNotBeDisplayed(null)  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

    }

    Scenario("14. User clicks View your Payment to see the Penalty payment information is not displayed [ECL Reference Number=XMECL0000000027]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000027")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000027")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I click on the View your payments link")
        andIClickOnTheViewYourPaymentsLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I should be on the page that displays You have not made any Economic Crime Levy payments.")
        thenIShouldBeOnThePageThatDisplaysX("You have not made any Economic Crime Levy payments.")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("14. User clicks View your Payment to see the Penalty payment information is not displayed [ECL Reference Number=XMECL0000000026]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000026")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000026")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I click on the View your payments link")
        andIClickOnTheViewYourPaymentsLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I should be on the page that displays You have not made any Economic Crime Levy payments.")
        thenIShouldBeOnThePageThatDisplaysX("You have not made any Economic Crime Levy payments.")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("14. User clicks View your Payment to see the Penalty payment information is not displayed [ECL Reference Number=XMECL0000000025]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000025")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000025")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I click on the View your payments link")
        andIClickOnTheViewYourPaymentsLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I should be on the page that displays You have not made any Economic Crime Levy payments.")
        thenIShouldBeOnThePageThatDisplaysX("You have not made any Economic Crime Levy payments.")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("14. User clicks View your Payment to see the Penalty payment information is not displayed [ECL Reference Number=XMECL0000000024]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000024")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000024")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I click on the View your payments link")
        andIClickOnTheViewYourPaymentsLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I should be on the page that displays You have not made any Economic Crime Levy payments.")
        thenIShouldBeOnThePageThatDisplaysX("You have not made any Economic Crime Levy payments.")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }

    Scenario("14. User clicks View your Payment to see the Penalty payment information is not displayed [ECL Reference Number=XMECL0000000028]") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000028")
        givenIAmSignedInToTheAccountJourneyWithMyECLReferenceAsX("XMECL0000000028")  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      When("I am on the ECL account dashboard")
        whenIAmOnTheECLAccountDashboard()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I click on the View your payments link")
        andIClickOnTheViewYourPaymentsLink()  // auto-chosen (score=1.00, AccountStepDefSteps.scala)

      And("I should be on the page that displays You have not made any Economic Crime Levy payments.")
        thenIShouldBeOnThePageThatDisplaysX("You have not made any Economic Crime Levy payments.")  // auto-chosen (score=1.00, RegistrationStepDefSteps.scala)

    }
  }
}
