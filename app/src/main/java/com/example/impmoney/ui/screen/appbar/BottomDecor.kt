package com.example.impmoney.ui.screen.appbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.impmoney.data.BottomNavigationItem
import com.example.impmoney.ui.theme.orange

@Composable
fun BottomDecor(navController: NavHostController) {
    androidx.compose.material.BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.LightGray
    ) {
        val items = listOf(
            BottomNavigationItem.Trans,
            BottomNavigationItem.Stats,
            BottomNavigationItem.Account,
            BottomNavigationItem.More
        )
        BottomNavigation(
            contentColor = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Color.LightGray
        ) {
//            val backStackEntry by navController.currentBackStackEntryAsState()
//
//            val currentScreen = backStackEntry?.destination?.route

            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = { Text(text = item.title) },
                    selectedContentColor = orange,
                    unselectedContentColor = Color.Black.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = false,
                    onClick = {
                        navController.navigate(item.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    })
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomTheme() {

}