#!/bin/sh
# minimal wrapper fallback - use system gradle if wrapper jar missing
DIR=$(dirname "$0")
if [ -f "$DIR/gradle/wrapper/gradle-wrapper.jar" ]; then
  exec java -classpath "$DIR/gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"
else
  exec gradle "$@"
fi
