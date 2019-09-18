#!/usr/bin/env bash

echo "Stopping project environment"

if [[ "$OSTYPE" == "cygwin" ]]; then
  taskkill /IM "java.exe" /F
  taskkill /IM "node.exe" /F
fi

if [[ "$OSTYPE" == "darwin"* ]]; then
  killall java
fi

rm project-started

echo "Project environment fully stopped"

