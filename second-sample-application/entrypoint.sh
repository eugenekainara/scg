#!/bin/bash
exec java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Dtest.value=FromSystem -Djava.security.egd=file:/dev/./urandom -jar /second-sample-application.jar