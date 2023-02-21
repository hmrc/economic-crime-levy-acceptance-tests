**This is a template README.md.  Be sure to update this with project specific content that describes your ui test project.**

# economic-crime-levy-acceptance-tests
UI test suite for the `economic-crime-levy` using WebDriver , `cucumber` and `scalatest`.  

## Running the tests

Prior to executing the tests ensure you have:
 - Docker - to run mongo and browser (Chrome or Firefox) inside a container 
 - Appropriate [drivers installed](#installing-local-driver-binaries) - to run tests against locally installed Browser
 - Installed/configured [service manager](https://github.com/hmrc/service-manager).  

Run the following command to start services locally:

    docker run --rm -d --name mongo -d -p 27017:27017 mongo:4.0
    sm --start ECONOMIC_CRIME_LEVY_ALL -r --wait 100

Using the `--wait 100` argument ensures a health check is run on all the services started as part of the profile. `100` refers to the given number of seconds to wait for services to pass health checks.

Then execute the `run_registration.sh` script for Registration and `run_returns.sh` script for Returns :

    ./run_registration.sh <browser-driver> <environment> 
    ./run_returns.sh <browser-driver> <environment>

The `run_registration.sh` and `run_returns.sh` scripts defaults to using `chrome` in the `local` environment.  For a complete list of supported param values, see:
 - `src/test/resources/application.conf` for **environment** 
 - [webdriver-factory](https://github.com/hmrc/webdriver-factory#2-instantiating-a-browser-with-default-options) for **browser-driver**

## Running tests against a containerised browser - on a developer machine

The script `./run_browser_with_docker.sh` can be used to start a Chrome or Firefox container on a developer machine. 
The script requires `remote-chrome` or `remote-firefox` as an argument.

Read more about the script's functionality [here](run_browser_with_docker.sh).

To run against a containerised Chrome browser:

```bash
./run_browser_with_docker.sh remote-chrome 
./run_registration.sh remote-chrome local
```

`./run_browser_with_docker.sh` is **NOT** required when running in a CI environment. 

#### Running the tests against a test environment

To run the tests against an environment set the corresponding `host` environment property as specified under
 `<env>.host.services` in the [application.conf](/src/test/resources/application.conf). 

For example, to execute the `run_registration.sh` script using Chrome remote-webdriver against QA environment 

    ./run_registration.sh remote-chrome qa

## Running ZAP tests

ZAP tests can be automated using the HMRC Dynamic Application Security Testing approach. Running 
automated ZAP tests should not be considered a substitute for manual exploratory testing using OWASP ZAP.

#### Tagging tests for ZAP

It is not required to proxy every journey test via ZAP. The intention of proxying a test through ZAP is to expose all the
 relevant pages of an application to ZAP. So tagging a subset of the journey tests or creating a 
 single ZAP focused journey test is sufficient.

#### Configuring the browser to proxy via ZAP 

Setting the system property `zap.proxy=true` configures the browser specified in `browser` property to proxy via ZAP. 
This is achieved using [webdriver-factory](https://github.com/hmrc/webdriver-factory#proxying-trafic-via-zap).

#### Executing a ZAP test

The shell script `run_zap_tests.sh` is available to execute ZAP tests. The script proxies a set of journey tests, 
tagged as `ZapTests`, via ZAP.  

For example, to execute ZAP tests locally using a Chrome browser

```
./run_zap_test.sh chrome local
```

To execute ZAP tests locally using a remote-chrome browser

```
./run_browser_with_docker.sh remote-chrome 
./run_zap_test.sh remote-chrome local
``` 

`./run_browser_with_docker.sh` is **NOT** required when running in a CI environment.

### Running tests using BrowserStack
If you would like to run your tests via BrowserStack from your local development environment please refer to the [webdriver-factory](https://github.com/hmrc/webdriver-factory/blob/main/README.md/#user-content-running-tests-using-browser-stack) project.

## Installing local driver binaries

This project supports UI test execution using Firefox (Geckodriver) and Chrome (Chromedriver) browsers. 

See the `drivers/` directory for some helpful scripts to do the installation work for you.  They should work on both Mac and Linux by running the following command:

    ./installGeckodriver.sh <operating-system> <driver-version>
    or
    ./installChromedriver <operating-system> <driver-version>

- *<operating-system>* defaults to **linux64**, however it also supports **macos**
- *<driver-version>* defaults to **0.21.0** for Gecko/Firefox, and the latest release for Chrome.  You can, however, however pass any version available at the [Geckodriver](https://github.com/mozilla/geckodriver/tags) or [Chromedriver](http://chromedriver.storage.googleapis.com/) repositories.

**Note 1:** *You will need to ensure that you have a recent version of Chrome and/or Firefox installed for the later versions of the drivers to work reliably.*

**Note 2** *These scripts use sudo to set the right permissions on the drivers so you will likely be prompted to enter your password.*


## Running accessibility tests
You can run the accessibility test for either the registration or the returns frontend service.

1. Keep the registration (or the returns) frontend service up and running the way you would normally do (for example via its `sbt run` command line)


2. Then run the _"dockerized"_ accessibility assessment service:
    ```sh
    $ docker container run \
          --name "accessibility-assessment" \
          --detach --restart unless-stopped \
          --publish 6010:6010 \
          --env TARGET_IP='host.docker.internal' \
          artefacts.tax.service.gov.uk/accessibility-assessment:latest
    ```
   Be aware that's a _"stateful"_ service. You may want to read more about it. See https://github.com/hmrc/accessibility-assessment
   > NOTE  
   > You may need an Intel x86_64 architecture as the Docker image for ARM may not be available yet.


3. Now time to run the test with the right arguments:
   ```sh
   $ cd $WORKSPACE/economic-crime-levy-acceptance-tests
   $ sbt \
        -Dbrowser="chrome" \
        -Denvironment="local" \
        -Daccessibility.test="true"  \
        "testOnly uk.gov.hmrc.test.ui.cucumber.runner.RunRegistration"
   ```
   > NOTE  
   > You may need to install Google Chrome and the WebDriver for Chrome as be above instructions (or read https://chromedriver.chromium.org/downloads)


4. Once the above accessibility test completes, request the assessment service to assess (collect and assemble) the report pages:
   ```sh
   $ curl --verbose \
          --request POST \
          "http://localhost:6010/api/assess-pages"
   ```
   Since that's a _"stateful"_ service, after a short while, query for the status:
   ```sh
   $ curl --verbose \
          --request GET \
          "http://localhost:6010/api/status"
   ```
   Keep querying until the status turns into `REPORT_READY`


5. Finally extract the HTML report from the assessment service container
   ```sh
   $ docker container cp \
       accessibility-assessment:/home/seluser/output/accessibility-assessment-report.html \
      ./target
   ```
   and open it using any browser you like.


6. (Optional) In case you want to repeat the accessibility test again, reset the accessibility service to its initial state (it will remove previously collected pages and generated reports):
   ```sh
   $ curl --verbose \
          --request POST \
          "http://localhost:6010/api/app/reset"
   ```


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