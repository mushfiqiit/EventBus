#!/usr/bin/env bash
# Runs the NullAway nullability check (see NULLAWAY.md) and splits the
# output into two files:
#   nullaway-report.txt   - full Gradle build log
#   nullaway-warnings.txt - just the NullAway findings, one per line
set -uo pipefail
cd "$(dirname "$0")"

REPORT_FILE="nullaway-report.txt"
WARNINGS_FILE="nullaway-warnings.txt"

./gradlew clean nullAwayCheck --console=plain >"$REPORT_FILE" 2>&1
build_status=$?

grep -E '\[NullAway\]' "$REPORT_FILE" >"$WARNINGS_FILE"
warning_count=$(wc -l <"$WARNINGS_FILE" | tr -d ' ')

echo "Full build log:       $REPORT_FILE"
echo "NullAway warnings:    $WARNINGS_FILE ($warning_count found)"

exit $build_status