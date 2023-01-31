package com.example.impmoney

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.impmoney.ui.screen.appbar.BottomDecor
import com.example.impmoney.ui.screen.mainscreen.TransScreen
import com.example.impmoney.ui.screen.mainscreen.accountscreen.AccountScreen
import com.example.impmoney.ui.screen.mainscreen.moreScreen.MoreScreen
import com.example.mymoney.R
import com.example.mymoney.ui.theme.bottombarscreen.StatsScreen


enum class MoneyScreen(@StringRes val title: Int) {
    Trans(title = R.string.trans),
    Stats(title = R.string.Stats),
    Account(title = R.string.Account),
    More(title = R.string.More)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomDecor(navController) },
    ) {
        NavHost(navController = navController, startDestination = MoneyScreen.Trans.name) {
            composable(route = MoneyScreen.Trans.name) {
                TransScreen()
            }
            composable(route = MoneyScreen.Stats.name) {
                StatsScreen()
            }
            composable(route = MoneyScreen.Account.name) {
                AccountScreen()
            }
            composable(route = MoneyScreen.More.name) {
                MoreScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun mainScreenTheme() {
    MainScreen()
}