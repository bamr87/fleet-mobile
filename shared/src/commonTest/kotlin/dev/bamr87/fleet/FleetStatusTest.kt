package dev.bamr87.fleet

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class FleetStatusTest {
    private fun flagged(vararg repos: RepoStatus): List<String> =
        needsAttention(repos.toList()).map { it.name }

    @Test
    fun flagsFailingCiAndPrsAwaitingReview() {
        assertEquals(
            listOf("b", "c"),
            flagged(
                RepoStatus(name = "a", ci = CiState.PASSING, prsAwaitingReview = 0),
                RepoStatus(name = "b", ci = CiState.FAILING, prsAwaitingReview = 0),
                RepoStatus(name = "c", ci = CiState.PASSING, prsAwaitingReview = 2),
            ),
        )
    }

    @Test
    fun emptyFleetNeedsNoAttention() {
        assertEquals(emptyList<RepoStatus>(), needsAttention(emptyList()))
    }

    @Test
    fun unknownCiWithNothingAwaitingReviewIsNotFlagged() {
        assertEquals(
            emptyList<String>(),
            flagged(RepoStatus(name = "a", ci = CiState.UNKNOWN, prsAwaitingReview = 0)),
        )
    }

    @Test
    fun unknownCiWithPrsAwaitingReviewIsFlagged() {
        assertEquals(
            listOf("a"),
            flagged(RepoStatus(name = "a", ci = CiState.UNKNOWN, prsAwaitingReview = 1)),
        )
    }

    @Test
    fun failingCiIsFlaggedWithNoPullRequests() {
        assertEquals(
            listOf("a"),
            flagged(RepoStatus(name = "a", ci = CiState.FAILING, prsAwaitingReview = 0, openPrs = 0)),
        )
    }

    @Test
    fun openPrsNotAwaitingReviewDoNotFlagARepo() {
        // Drafts and already-reviewed pull requests count in openPrs, never in prsAwaitingReview.
        assertEquals(
            emptyList<String>(),
            flagged(RepoStatus(name = "a", ci = CiState.PASSING, prsAwaitingReview = 0, openPrs = 3)),
        )
    }

    @Test
    fun keepsInputOrder() {
        assertEquals(
            listOf("zeta", "alpha", "beta"),
            flagged(
                RepoStatus(name = "zeta", ci = CiState.FAILING, prsAwaitingReview = 0),
                RepoStatus(name = "alpha", ci = CiState.PASSING, prsAwaitingReview = 1),
                RepoStatus(name = "quiet", ci = CiState.PASSING, prsAwaitingReview = 0, openPrs = 2),
                RepoStatus(name = "beta", ci = CiState.FAILING, prsAwaitingReview = 4),
            ),
        )
    }

    @Test
    fun negativePrsAwaitingReviewIsRejected() {
        assertFailsWith<IllegalArgumentException> {
            RepoStatus(name = "a", ci = CiState.PASSING, prsAwaitingReview = -1)
        }
    }

    @Test
    fun negativeOpenPrsIsRejected() {
        assertFailsWith<IllegalArgumentException> {
            RepoStatus(name = "a", ci = CiState.PASSING, prsAwaitingReview = 0, openPrs = -1)
        }
    }
}
