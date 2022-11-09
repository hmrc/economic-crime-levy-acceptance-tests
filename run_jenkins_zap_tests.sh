#!/usr/bin/env bash

sbt -Dbrowser=remote-chrome -Dzap.proxy=true -Denvironment=local "testOnly uk.gov.hmrc.test.ui.cucumber.runner.RunZap"