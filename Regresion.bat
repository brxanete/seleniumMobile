@echo off
gradle clean test --tests "appmobile.runners.RunnerNoReset" -Dappium.noReset=true && gradle test --tests "appmobile.runners.RunnerReset" -Dappium.noReset=false
gradle aggregate

