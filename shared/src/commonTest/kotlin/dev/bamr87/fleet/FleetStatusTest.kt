package dev.bamr87.fleet

import kotlin.test.Test
import kotlin.test.assertEquals

class FleetStatusTest {
    @Test
    fun flagsFailingAndOpenPrs() {
        val repos = listOf(
            RepoStatus("a", CiState.PASSING, 0),
            RepoStatus("b", CiState.FAILING, 0),
            RepoStatus("c", CiState.PASSING, 2),
        )
        assertEquals(listOf("b", "c"), needsAttention(repos).map { it.name })
    }
}
