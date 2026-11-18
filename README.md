# fleet-mobile

> fleet-mobile's direction is to become the ultimate open home for all things mobile fleet operations: data, tools, resources and transparency, with a Kotlin Multiplatform console for bot runs, CI and PRs, for everyone ([constitution](docs/constitution.md) §1).

The fleet console in your pocket: shared Kotlin logic for Android and iOS showing bot runs, CI status and PRs waiting on review.

**Status:** foundation (phase 1). Part of the [bamr87 fleet](https://github.com/bamr87/bamr87).

## Goals

- Shared KMP core that reads fleet status (hub _data / GitHub API)
- Compose Multiplatform UI for Android and iOS
- Push notifications for failing CI and PRs needing review

## Skills learned

- Kotlin Multiplatform architecture
- Compose Multiplatform UI
- Ktor client and serialization
- Mobile auth (OIDC with zer0-id)

## Fleet tie-in

Mobile front end for the hub console, harness registry and fleet activity log; signs in through zer0-id.

## Quick start

**Prerequisites:** JDK 17 or newer (CI uses Temurin 17) and a current Gradle on your `PATH`, installed with your package manager or [SDKMAN](https://sdkman.io/). The repo ships no Gradle wrapper and the fleet always tracks the latest release, so no Gradle version is pinned.

Build the shared module and run its tests exactly as CI does:

```bash
gradle --no-daemon :shared:jvmTest
```

Success ends with `BUILD SUCCESSFUL`. The HTML test report lands at `shared/build/reports/tests/jvmTest/index.html` and the JUnit XML results in `shared/build/test-results/jvmTest/`.

The tests live in `shared/src/commonTest/kotlin/dev/bamr87/fleet/` and run on the JVM target, the only target so far. To run a single test class:

```bash
gradle :shared:jvmTest --tests 'dev.bamr87.fleet.FleetStatusTest'
```

## How it grows

The roadmap lives in [PRD.md](PRD.md) and [features/features.yml](features/features.yml) (ids `FMOB-NNN`, most `status: planned`). Work arrives as pull requests from the hub's evolution and fan-out loops, the `@claude` handler, or the local `evolve` lane (off until `EVOLVE_ENABLED=true`). A human merges every PR. Rules: [docs/constitution.md](docs/constitution.md) · agent guide: [AGENTS.md](AGENTS.md).

## License

[MIT](LICENSE)
