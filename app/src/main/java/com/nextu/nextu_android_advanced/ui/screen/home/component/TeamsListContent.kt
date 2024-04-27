package com.nextu.nextu_android_advanced.ui.screen.home.component

import TeamCard
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nextu.nextu_android_advanced.model.Team

@Composable
fun TeamsListContent(
    teams: List<Team>,
    navigateToTeamDetail: (id: String) -> Unit,
) {

    // La grille avec les équipes
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        items(teams.size) { index ->
            val team = teams[index].teamInfo
            TeamCard(
                team = team,
                navToTeamDetail = { id -> navigateToTeamDetail(id) }
            )
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun ProductListContentPreview() {
    NextU_android_advancedTheme {
        Column {
            ProductListContent(
                listOf(Category("All")), listOf(
                    Product(
                        category = "Coffee",
                        description = "A rich blend of premium coffee beans sourced from Colombia and Ethiopia, roasted to perfection.",
                        id = 123456,
                        image = "https://tinyurl.com/vtymn7w5",
                        price = 9.99,
                        rating = Rating(count = 256, rate = 4.5),
                        title = "Premium Blend Coffee"
                    ), Product(
                        category = "Coffee",
                        description = "A rich blend of premium coffee beans sourced from Colombia and Ethiopia, roasted to perfection.",
                        id = 123456,
                        image = "https://tinyurl.com/vtymn7w5",
                        price = 9.99,
                        rating = Rating(count = 256, rate = 4.5),
                        title = "Premium Blend Coffee"
                    )
                ),
                {},
                {},
                state.teams
            )
        }
    }
}*/