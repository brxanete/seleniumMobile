@echo off
gradle clean test --tests "appmobile.runners.RunnerNoReset" -Dappium.noReset=true && gradle test --tests "appmobile.runners.RunnerAndroid" -Dappium.noReset=false
gradle aggregate

