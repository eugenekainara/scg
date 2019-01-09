#!/bin/bash


./gradlew clean build -x test


java -jar eureka-server/build/libs/eureka-server*.jar &>/dev/null &
EUREKA_PID=$!

java -jar sample-application/build/libs/sample-application*.jar &>/dev/null &
SAMPLE_PID=$!

java -jar gateway-server/build/libs/gateway-server*.jar > log &
GATEWAY_PID=$!

echo "wait for initialization"
until curl "http://localhost:8881/sample/tests" -w %{http_code}\\n -s -o /dev/null -L --insecure | grep -E "(200|500)" || [[ "$retries" -lt 0 ]];
do
sleep 5s
done

./gradlew :sample-application:test

kill $EUREKA_PID $SAMPLE_PID $GATEWAY_PID
