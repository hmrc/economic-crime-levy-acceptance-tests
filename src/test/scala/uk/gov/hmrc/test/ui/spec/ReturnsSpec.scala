package uk.gov.hmrc.test.ui.spec

import org.scalatest.matchers.should.Matchers
import org.scalatest.featurespec.AnyFeatureSpec
import uk.gov.hmrc.test.ui.spec.BaseSpec


class ReturnsSpec extends BaseSpec with Matchers {

  Feature("Submit ECL Return") {

    Scenario("User that is registered for ECL starts a return submission") {
      Given("I am signed in to the return journey")
      When("I provide the details to submit the economic crime levy return")
      Then("I should be on the page that says Return submitted")
      And("I should see my ecl return number is ECL return number and the amount to pay is Amount you need to pay")
    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=10200000, Expected content=You need to pay £10,000]") {
      Given("I am signed in to the return journey")
      When("I enter 12 month accounting period revenue 10200000 and select Yes for my AML-regulated activity for the full financial year")
      Then("I should be on the page that says You need to pay £10,000")
    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=35999999, Expected content=You need to pay £10,000]") {
      Given("I am signed in to the return journey")
      When("I enter 12 month accounting period revenue 35999999 and select Yes for my AML-regulated activity for the full financial year")
      Then("I should be on the page that says You need to pay £10,000")
    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=36000000, Expected content=You need to pay £36,000]") {
      Given("I am signed in to the return journey")
      When("I enter 12 month accounting period revenue 36000000 and select Yes for my AML-regulated activity for the full financial year")
      Then("I should be on the page that says You need to pay £36,000")
    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=999999999, Expected content=You need to pay £36,000]") {
      Given("I am signed in to the return journey")
      When("I enter 12 month accounting period revenue 999999999 and select Yes for my AML-regulated activity for the full financial year")
      Then("I should be on the page that says You need to pay £36,000")
    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=1000000000, Expected content=You need to pay £500,000]") {
      Given("I am signed in to the return journey")
      When("I enter 12 month accounting period revenue 1000000000 and select Yes for my AML-regulated activity for the full financial year")
      Then("I should be on the page that says You need to pay £500,000")
    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the non-full financial year [UK Revenue=10200000, AMLDays=60, Expected content=You need to pay £1,643.83]") {
      Given("I am signed in to the return journey")
      When("I enter 12 month accounting period revenue 10200000 and select No for my AML-regulated activity for the full financial year")
      And("I enter the number of days 60 I carried out AML regulated activity during the financial year")
      Then("I should be on the page that says You need to pay £1,643.83")
    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the non-full financial year [UK Revenue=999999999, AMLDays=204, Expected content=You need to pay £20,120.54]") {
      Given("I am signed in to the return journey")
      When("I enter 12 month accounting period revenue 999999999 and select No for my AML-regulated activity for the full financial year")
      And("I enter the number of days 204 I carried out AML regulated activity during the financial year")
      Then("I should be on the page that says You need to pay £20,120.54")
    }

    Scenario("Return submission for 12 month accounting period and AML-regulated activity for the non-full financial year [UK Revenue=1000000000, AMLDays=330, Expected content=You need to pay £452,054.79]") {
      Given("I am signed in to the return journey")
      When("I enter 12 month accounting period revenue 1000000000 and select No for my AML-regulated activity for the full financial year")
      And("I enter the number of days 330 I carried out AML regulated activity during the financial year")
      Then("I should be on the page that says You need to pay £452,054.79")
    }

    Scenario("Return submission for non 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=10000000, APDays=182, Expected content=You need to pay £10,000]") {
      Given("I am signed in to the return journey")
      When("I select No for my accounting period 12 months and enter the length of my accounting period as 182 days")
      And("I enter my UK revenue 10000000 for the accounting period and select Yes for my AML-regulated activity for the full financial year")
      Then("I should be on the page that says You need to pay £10,000")
    }

    Scenario("Return submission for non 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=8000000, APDays=73, Expected content=You need to pay £36,000]") {
      Given("I am signed in to the return journey")
      When("I select No for my accounting period 12 months and enter the length of my accounting period as 73 days")
      And("I enter my UK revenue 8000000 for the accounting period and select Yes for my AML-regulated activity for the full financial year")
      Then("I should be on the page that says You need to pay £36,000")
    }

    Scenario("Return submission for non 12 month accounting period and AML-regulated activity for the full financial year [UK Revenue=1300000000, APDays=450, Expected content=You need to pay £500,000]") {
      Given("I am signed in to the return journey")
      When("I select No for my accounting period 12 months and enter the length of my accounting period as 450 days")
      And("I enter my UK revenue 1300000000 for the accounting period and select Yes for my AML-regulated activity for the full financial year")
      Then("I should be on the page that says You need to pay £500,000")
    }

    Scenario("Return submission for non 12 month accounting period and AML-regulated activity for the non-full financial year [UK Revenue=10000000, APDays=113, AMLDays=198, Expected content=You need to pay £5,424.65]") {
      Given("I am signed in to the return journey")
      When("I select No for my accounting period 12 months and enter the length of my accounting period as 113 days")
      And("I enter my UK revenue 10000000 for the accounting period and select No for my AML-regulated activity for the full financial year")
      And("I enter the number of days 198 I carried out AML regulated activity during the financial year")
      Then("I should be on the page that says You need to pay £5,424.65")
    }

    Scenario("Return submission for non 12 month accounting period and AML-regulated activity for the non-full financial year [UK Revenue=31000000, APDays=284, AMLDays=300, Expected content=You need to pay £29,589.04]") {
      Given("I am signed in to the return journey")
      When("I select No for my accounting period 12 months and enter the length of my accounting period as 284 days")
      And("I enter my UK revenue 31000000 for the accounting period and select No for my AML-regulated activity for the full financial year")
      And("I enter the number of days 300 I carried out AML regulated activity during the financial year")
      Then("I should be on the page that says You need to pay £29,589.04")
    }

    Scenario("Return submission for non 12 month accounting period and AML-regulated activity for the non-full financial year [UK Revenue=350000000, APDays=91, AMLDays=256, Expected content=You need to pay £350,684.93]") {
      Given("I am signed in to the return journey")
      When("I select No for my accounting period 12 months and enter the length of my accounting period as 91 days")
      And("I enter my UK revenue 350000000 for the accounting period and select No for my AML-regulated activity for the full financial year")
      And("I enter the number of days 256 I carried out AML regulated activity during the financial year")
      Then("I should be on the page that says You need to pay £350,684.93")
    }

    Scenario("User wants to go to check your answers page directly without providing any of the previous pages details") {
      Given("I am signed in to the return journey")
      When("I go to the return submission check your answers page directly without providing answers for any of the previous page questions")
      Then("I should be on the page that says The answers you provided are not valid")
    }

    Scenario("User wants to change their ECL contact details before submitting the returns") {
      Given("I am signed in to the return journey")
      When("I click on the change link to modify my contact details")
      Then("I should be on the page that says Check your answers")
    }

    Scenario("User wants to change their ECL accounting period before submitting the returns") {
      Given("I am signed in to the return journey")
      When("I click on the change link to modify my economic crime levy accounting period")
      Then("I should be on the page that says Check your answers")
      Then("I click on the Back link")
      Then("I should be on the page that says Amount of Economic Crime Levy you need to pay")
      Then("I click the Save and continue button")
      Then("I should be on the page that says Check your answers")
    }

    Scenario("User wants to change their ECL accounting period length before submitting the returns") {
      Given("I am signed in to the return journey")
      When("I click on the change link to modify my accounting period length")
      Then("I should be on the page that says Check your answers")
    }

    Scenario("User wants to change their ECL UK revenue before submitting the returns") {
      Given("I am signed in to the return journey")
      When("I click on the change link to modify my uk revenue")
      Then("I should be on the page that says Check your answers")
    }

    Scenario("User wants to change their AML-regulated activity for the full financial year before submitting the returns") {
      Given("I am signed in to the return journey")
      When("I click on the change link to modify my AML-regulated activity for the full financial year")
      Then("I should be on the page that says Check your answers")
    }

    Scenario("User wants to change their AML-regulated activity length before submitting the returns") {
      Given("I am signed in to the return journey")
      When("I click on the change link to modify my AML-regulated activity length")
      Then("I should be on the page that says Check your answers")
    }

    Scenario("Return submission for users who falls in the small band size (less than 10.2M)") {
      Given("I am signed in to the return journey")
      When("I enter 12 month accounting period revenue is 10199999 that falls in the small band size")
      Then("I should be on the page that says You do not need to pay the Economic Crime Levy (ECL)")
    }

    Scenario("User wants to change their UK revenue (greater than or equal to 10.2M) from amount due page") {
      Given("I am signed in to the return journey")
      When("I click on the change link to edit my uk revenue from amount due page and select Yes for my AML-regulated activity for the full financial year")
      Then("I should be on the page that says You need to pay £10,000")
    }

    Scenario("User wants to change the accounting period from amount due page for their UK revenue less than 10.2M") {
      Given("I am signed in to the return journey")
      When("I click on the change link to edit my accounting period and select Yes for my AML-regulated activity for the full financial year")
      Then("I should be on the page that says You need to pay £10,000")
    }

    Scenario("User is on the amount due page with content explaining how it was calculated [Expected content=Amount of Economic Crime Levy you need to pay]") {
      Given("I am signed in to the return journey")
      When("I enter the information required to calculate the amount due")
      Then("I should be on the page that says Amount of Economic Crime Levy you need to pay")
    }

    Scenario("User is on the amount due page with content explaining how it was calculated [Expected content=Your band size]") {
      Given("I am signed in to the return journey")
      When("I enter the information required to calculate the amount due")
      Then("I should be on the page that says Your band size")
    }

    Scenario("User is on the amount due page with content explaining how it was calculated [Expected content=How we worked this out]") {
      Given("I am signed in to the return journey")
      When("I enter the information required to calculate the amount due")
      Then("I should be on the page that says How we worked this out")
    }

    Scenario("User is on the amount due page with content explaining how it was calculated [Expected content=How the size bands affect what you need to pay]") {
      Given("I am signed in to the return journey")
      When("I enter the information required to calculate the amount due")
      Then("I should be on the page that says How the size bands affect what you need to pay")
    }

    Scenario("User is on the amount due page with content explaining how it was calculated [Expected content=What you need to do next]") {
      Given("I am signed in to the return journey")
      When("I enter the information required to calculate the amount due")
      Then("I should be on the page that says What you need to do next")
    }

    Scenario("User that is registered for ECL starts for a nil return submission") {
      Given("I am signed in to the return journey")
      When("I provide the details for a return submission")
      Then("I should be on the page that says Return submitted")
      And("I should see the amount to pay is Amount you need to pay: £0")
    }

    Scenario("User cancels amendments to the submitted economic crime levy return") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000007")
      When("I provide the details to amend the submitted economic crime levy return")
      And("I decide to cancel this amendments")
      Then("I should be on the page that says Your Economic Crime Levy account")
    }

    Scenario("User amends the submitted returns via ECL account dashboard") {
      Given("I am signed in to the account journey with my ECL reference as XMECL0000000007")
      When("I provide the details to amend the submitted economic crime levy return")
      And("the amended return information should display under Amended answers on the Check your answers page")
      And("I should be on the page that says Economic Crime Levy return amendment requested")
    }

    Scenario("User can save progress in the return submission journey and resume later") {
      Given("I am signed in to the return journey")
      When("I provide some details for the economic crime levy return submission and experience a system timeout")
      And("I return to the service to complete the the return submission")
      Then("I should be on the page that says Your answers have been saved")
      And("I should be able to resume the submission from where I left off")
      Then("I should be on the page that says Return submitted")
    }
  }
}
