#!/bin/bash
sleep 10
exec java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Dreactor.netty.http.server.accessLogEnabled=true -Djava.security.egd=file:/dev/./urandom -jar /gateway-server.jar