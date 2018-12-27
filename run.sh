#!/bin/bash


./gradlew clean buildDocker
docker-compose -f docker-compose-system.yml up  -d
docker-compose up -d