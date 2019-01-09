#!/bin/bash
for i in `echo $LINKED_SERVICES | tr "," " "`
do
  until 2>/dev/null < /dev/tcp/${i%%:*}/${i##*:}
  do
    sleep 1s
    echo "waiting for $i"
  done
  echo "connected to $i"
done

echo "Connected to $LINKED_SERVICES"

exec java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Dtest.value=FromSystem -Djava.security.egd=file:/dev/./urandom -jar /second-sample-application.jar