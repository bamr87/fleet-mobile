package dev.bamr87.fleet

enum class CiState { PASSING, FAILING, UNKNOWN }

/**
 * One fleet repo as the console shows it.
 *
 * @property name the repository name.
 * @property ci the latest CI result of the repo's default branch.
 * @property prsAwaitingReview open, non-draft pull requests with no review decision yet.
 *   This is the count [needsAttention] uses.
 * @property openPrs every open pull request, drafts and already-reviewed ones included.
 *   Display only: [needsAttention] ignores it.
 * @throws IllegalArgumentException if [prsAwaitingReview] or [openPrs] is negative.
 */
data class RepoStatus(
    val name: String,
    val ci: CiState,
    val prsAwaitingReview: Int,
    val openPrs: Int = 0,
) {
    init {
        require(prsAwaitingReview >= 0) { "prsAwaitingReview must not be negative, was $prsAwaitingReview" }
        require(openPrs >= 0) { "openPrs must not be negative, was $openPrs" }
    }
}

/**
 * The repos that need the maintainer: CI is [CiState.FAILING], or at least one pull request
 * is awaiting review ([RepoStatus.prsAwaitingReview] > 0).
 *
 * Open pull requests that are drafts or already reviewed ([RepoStatus.openPrs]) do not flag a repo.
 * [CiState.UNKNOWN] does not flag a repo either, because an unknown CI result is not evidence of a failure.
 * The result keeps the input order.
 */
fun needsAttention(repos: List<RepoStatus>): List<RepoStatus> =
    repos.filter { it.ci == CiState.FAILING || it.prsAwaitingReview > 0 }
