#!/bin/bash -e

BROWSER=chrome
BROWSER_TYPE=$1
ENV=$2

DRIVER=

if  [ "$BROWSER" = "headless-chrome" ] || [ "$BROWSER" = "chrome" ] ; then
    DRIVER="-Dwebdriver.chrome.driver=/usr/local/bin/chromedriver"
elif [ "$BROWSER" = "firefox" ]; then
    DRIVER="-Dwebdriver.gecko.driver=/usr/local/bin/geckodriver"
fi


# Scalafmt checks have been separated from the test command to avoid OutOfMemoryError in Jenkins
sbt scalafmtCheckAll scalafmtSbtCheck

sbt -Dbrowser="${BROWSER_TYPE:=$BROWSER}" -Denvironment="${ENV:=local}" "testOnly uk.gov.hmrc.test.ui.cucumber.runner.RunRegistration"
