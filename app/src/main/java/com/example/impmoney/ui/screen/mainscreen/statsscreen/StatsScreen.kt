package com.example.mymoney.ui.theme.bottombarscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.impmoney.ui.screen.appbar.TabComponentOfMoney
import com.example.impmoney.ui.screen.appbar.TopBarDecorStats
import com.example.impmoney.ui.screen.mainscreen.statsscreen.PieChartYTTheme
import com.example.impmoney.ui.theme.blueWhite
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StatsScreen() {
    val pagerState = rememberPagerState()
    Scaffold(
        backgroundColor = blueWhite,
        topBar = { TopBarDecorStats() },
        bottomBar = {
            BottomAppBar(backgroundColor = Color.LightGray) {
                Text(text = "heloo")
            }
        },
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TabComponentOfMoney(pagerState = pagerState)
            PieChartYTTheme()
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun MusicScreenPreview() {
    StatsScreen()
}