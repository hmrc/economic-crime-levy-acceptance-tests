#!/bin/bash -e

BROWSER=$1
ENVIRONMENT=$2

sbt clean -Dbrowser="${BROWSER:=chrome}" -Dbrowser.usePreviousVersion=true -Denvironment="${ENVIRONMENT:=staging}" "testOnly uk.gov.hmrc.test.ui.cucumber.runner.RunAll" testReport

