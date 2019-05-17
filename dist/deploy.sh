#!/bin/sh
BASEDIR=$(pwd)
docker stack rm poc
#sleep 10
set -a
if [ -e $BASEDIR/app.properties ]; then
source $BASEDIR/app.properties
fi

docker stack deploy -c docker-compose-stack-single.yml --with-registry-auth poc
sleep 20s

echo "Waiting till First and Second are up http://${DOMAIN:-localhost}"
urls="http://${DOMAIN:-localhost}:8883/first/tests"

retries=30
for i in $urls
do
  until curl "$i" -w %{http_code}\\n -fkLs -o /dev/null || [[ "$retries" -lt 0 ]];
  do
    sleep 10s
    let retries--
  done
  if [[ "$retries" -lt 0 ]];
  then
        exit 1
  fi
done
echo "First and Second are up"
