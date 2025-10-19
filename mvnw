#!/usr/bin/env sh
set -e
MVNW_REPOURL="https://repo.maven.apache.org/maven2"
BASE_DIR=$(dirname "$0")
wrapperJar="$BASE_DIR/.mvn/wrapper/maven-wrapper.jar"
if [ ! -f "$wrapperJar" ]; then
  echo "Downloading Maven Wrapper..."
  mkdir -p "$BASE_DIR/.mvn/wrapper"
  curl -fsSL "$MVNW_REPOURL/io/takari/maven-wrapper/0.5.6/maven-wrapper-0.5.6.jar" -o "$wrapperJar" || true
fi
exec "$(dirname "$0")/mvnw.cmd" "$@" 2>/dev/null || mvn "$@"
