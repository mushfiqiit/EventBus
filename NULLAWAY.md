# Running NullAway on EventBus

This repo is set up to run [NullAway](https://github.com/uber/NullAway) (via
the [Error Prone](https://errorprone.info/) javac plugin) over the
production Java sources, to surface potential `NullPointerException` risks.

## What's configured

- Applied to `EventBus` (Gradle project `eventbus-java`) and
  `EventBusAnnotationProcessor` (Gradle project `eventbus-annotation-processor`)
  — the two pure-Java, non-Android modules.
- Only the `main` source set is checked (`compileJava`); test/perf/Android
  modules are untouched.
- Only the `NullAway` check runs — every other Error Prone bug-pattern check
  is disabled, so output is exclusively nullability findings.
- Annotated package prefix: `org.greenrobot.eventbus` (covers both modules).
- Severity is `WARN`, not `ERROR`, so findings are reported but don't fail
  the build. Bump it to `ERROR` in `gradle/nullaway.gradle` if you want
  nullability issues to break the build.

The shared config lives in [`gradle/nullaway.gradle`](gradle/nullaway.gradle)
and is applied from each module's `build.gradle`.

## Requirements

- **JDK 11 or newer** to run the build (the Error Prone/NullAway compiler
  plugins require it as a host JVM, even though the modules still target
  Java 8 bytecode). The project's own CI (`.github/workflows/gradle.yml`)
  already uses JDK 11.
- Network access to Maven Central and the Gradle Plugin Portal the first
  time you run it, to download the Error Prone / NullAway jars (they're then
  cached in `~/.gradle`).

## Running it

From the repo root:

```bash
# Run on both configured modules
./gradlew nullAwayCheck

# Or target a single module
./gradlew :eventbus-java:compileJava
./gradlew :eventbus-annotation-processor:compileJava
```

Gradle only re-runs `compileJava` (and reprints warnings) when something
changed. To force a full re-check and dump every current warning to a file:

```bash
./gradlew clean nullAwayCheck --console=plain > nullaway-report.txt 2>&1
grep '\[NullAway\]' nullaway-report.txt
```

Each finding looks like:

```
/path/to/File.java:42: warning: [NullAway] assigning @Nullable expression to @NonNull field
```

## Adjusting scope

- **Add a module**: give its `build.gradle` the same `plugins { ... }` block
  used in `EventBus/build.gradle` / `EventBusAnnotationProcessor/build.gradle`,
  then add `apply from: rootProject.file("gradle/nullaway.gradle")`, and add
  its `compileJava` task to the `nullAwayCheck` task's `dependsOn` in the root
  `build.gradle`.
- **Add another annotated package**: edit the `annotatedPackages` set in
  `gradle/nullaway.gradle`.
- **Fail the build on findings**: change `warn("NullAway")` to
  `error("NullAway")` in `gradle/nullaway.gradle`.
