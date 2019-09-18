#!/usr/bin/env bash

if [ -f "project-started" ]; then
  echo "Project environment is already started. Stop it before starting it again."
  echo "Use ./stop.sh or ./restart.sh"
  exit 0
fi

echo "Starting project environment"

mvn clean install package > ./project.log
mvn spring-boot:run > ./project.log

echo "Project environment started"
echo "Log at project.log"

touch project-started

tail -f ./project.log