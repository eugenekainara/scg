#!/bin/bash
./gradlew clean buildDocker -x test
cd dist/
./deploy.sh