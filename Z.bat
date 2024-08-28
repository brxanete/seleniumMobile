@echo off
gradle clean test --tests "appmobile.runners.RunnerNoReset" -Dappium.noReset=true
gradle aggregate

