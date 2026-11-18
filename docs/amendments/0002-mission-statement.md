<!-- kit: governance v0.1.0 -->
# 0002 — Missions

- **Status:** proposed
- **Date:** 2026-11-16
- **Proposed by:** Grok Bot (agent), at the maintainer's request
- **Ratified by:**
- **Affects:** constitution §1; PRD.md §1.1; FMOB-008
- **Supersedes:** none
- **Related:** [PRD.md](../../PRD.md) §1.1

## Context

Constitution §1 was a single mission sentence or short paragraph, not one direction statement with exactly three numbered missions. The fleet rule is that every repo's constitution §1 uses that form, adopted through a numbered amendment the maintainer ratifies by merging. Mission 1 is the maintainer's own wording, adapted to this repo: provide data, tools, resources and transparency for all stakeholders, practitioners in the domain, and the general public. The ambition is the direction, not a claim that the work is already finished.

The earlier §1 text was:

> The fleet console in your pocket: shared Kotlin logic for Android and iOS showing bot runs, CI status and PRs waiting on review. It is a learning-first portfolio project in the bamr87 fleet: Mobile front end for the hub console, harness registry and fleet activity log; signs in through zer0-id.

## Amendment

Retitle constitution §1 **Missions**. Replace the body of §1 with the following. Any invariants or other normative rules that already lived outside §1 are unchanged.

fleet-mobile's direction is to become the ultimate open home for all things mobile fleet operations — data, tools, resources and transparency, gathered in one place that anyone can inspect and reuse.

1. **Provide data, tools, resources and transparency for all stakeholders, operators, mobile practitioners and the general public.** Operators, mobile developers, and the general public are first-class audiences. The aim is a shared, open commons: the same sources, the same tools, and the same trail of evidence for everyone.
2. **Make the fleet's bot runs, CI status and PRs waiting on review visible from a phone, with shared Kotlin logic for Android and iOS.** What you see on the device should match the console, and stay auditable.
3. **Put that console in every operator's pocket, signed in through zer0-id.** Serve it as a mobile front end for the hub console, the harness registry and the fleet activity log — an open toolkit for working with all things mobile fleet operations.

These missions set the course; they do not claim the work is finished. They serve the existing constitution and PRD purpose: the fleet console in your pocket. The earlier mission paragraph is absorbed into these three. Every feature must trace to them.

_Source: [../PRD.md](../PRD.md) §1.1._

## Consequences

Agents and reviewers judge fit against these three missions before inventing scope, treating them as the direction of the repo rather than a description of what already ships. The same text is added as PRD.md §1.1 so the constitution's `_Source:` line stays accurate. The PRD purpose, goals, feature catalog and invariants outside this addition are unchanged except for a new catalog entry (FMOB-008) and a regenerated feature-catalog block where the repo already has one. This PR also aligns the README and AGENTS.md one-liners with the missions and links them to constitution §1.
