**This is a template README.md.  Be sure to update this with project specific content that describes your ui test project.**

# economic-crime-levy-acceptance-tests
This repo contains all the acceptance tests which are defined in conjunction with the business using Given, When, Then statements written in Gherkin syntax. Also, we followed declarative style scenarios with the focus on the behaviour, not user actions. MDTP test approach document can be viewed [here](https://confluence.tools.tax.service.gov.uk/display/DTRG/Testing+Question+Pages+Pattern+Journeys)

## Running the acceptance tests

* Ensure that you have cloned docker-selenium-grid and have executed `./start.sh` to run the relevant containers

Start Mongo Docker container as follows

    docker run --rm -d --name mongo -d -p 27017:27017 mongo:4.0

Start ECONOMIC_CRIME_LEVY as follows

    sm2 --start ECONOMIC_CRIME_LEVY_ALL

Then execute the `run_registration.sh` script for Registration and `run_returns.sh` script for Returns :

* To see the journey tests happening, navigate to `http://localhost:4444`

## Running Security Tests

Security testing is done through the `UITestJobBuilder` in `build-jobs`

## Running Accessibility tests

Accessibility testing is also done through the `UITestJobBuilder`, and the report can be generated locally and in Jenkins by appending `testReport` when running the tests.

### Running BrowserStack tests

If you would like to run your tests via BrowserStack from your local development environment please refer to the [webdriver-factory](https://github.com/hmrc/webdriver-factory/blob/main/README.md/#user-content-running-tests-using-browser-stack) project.


## Scalafmt
 This repository uses [Scalafmt](https://scalameta.org/scalafmt/), a code formatter for Scala. The formatting rules configured for this repository are defined within [.scalafmt.conf](.scalafmt.conf).

 To apply formatting to this repository using the configured rules in [.scalafmt.conf](.scalafmt.conf) execute:

 ```
 sbt scalafmtAll
 ```

 To check files have been formatted as expected execute:

 ```
 sbt scalafmtCheckAll scalafmtSbtCheck
 ```

[Visit the official Scalafmt documentation to view a complete list of tasks which can be run.](https://scalameta.org/scalafmt/docs/installation.html#task-keys)