#!/bin/bash
exec java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Djava.security.egd=file:/dev/./urandom -jar /config-server.jar