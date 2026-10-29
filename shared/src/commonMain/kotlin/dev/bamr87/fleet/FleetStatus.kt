package dev.bamr87.fleet

enum class CiState { PASSING, FAILING, UNKNOWN }

data class RepoStatus(val name: String, val ci: CiState, val openPrs: Int)

fun needsAttention(repos: List<RepoStatus>): List<RepoStatus> =
    repos.filter { it.ci == CiState.FAILING || it.openPrs > 0 }
