# fleet-mobile

> Kotlin Multiplatform app to monitor the bamr87 fleet's bots, CI and PRs from a phone.

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

```bash
gradle :shared:jvmTest
```

## How it grows

The roadmap lives in [PRD.md](PRD.md) and [features/features.yml](features/features.yml) (ids `FMOB-NNN`, most `status: planned`). Work arrives as pull requests from the hub's evolution and fan-out loops, the `@claude` handler, or the local `evolve` lane (off until `EVOLVE_ENABLED=true`). A human merges every PR. Rules: [docs/constitution.md](docs/constitution.md) · agent guide: [AGENTS.md](AGENTS.md).

## License

[MIT](LICENSE)
