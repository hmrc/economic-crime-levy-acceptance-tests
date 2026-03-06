#!/bin/bash -e

BROWSER=$1
ENVIRONMENT=$2

sbt clean -Dbrowser="${BROWSER:=chrome}" -Dbrowser.option.headless=false -Dbrowser.usePreviousVersion=true -Denvironment="${ENVIRONMENT:=local}" "testOnly uk.gov.hmrc.test.ui.spec.ReturnsSpec" testReport

