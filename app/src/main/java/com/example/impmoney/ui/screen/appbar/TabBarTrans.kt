package com.example.impmoney.ui.screen.appbar

import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabComponentOfTime(pagerState: PagerState) {
    val list = listOf(
        "Daily",
        "Calender",
        "Weekly",
        "Monthly",
        "Total"
    )

    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        contentColor = Color.Gray,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.Gray
            )
        }
    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {     // on below line we are specifying the scope.
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(
                        list[index],
                        color =
                        if (pagerState.currentPage == index) Color.Black else Color.LightGray,
                        fontSize = 9.sp,
                        textAlign = TextAlign.Center,
                    )
                },
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun TopBarDropDownSelect() {
    val pagerState = rememberPagerState()
    TabComponentOfTime(pagerState = pagerState)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabComponentOfMoney(pagerState: PagerState) {
    val list = listOf(
        "Income",
        "Expenses"
    )

    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        contentColor = Color.Gray,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.Gray
            )
        }
    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {     // on below line we are specifying the scope.
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(
                        list[index],
                        color =
                        if (pagerState.currentPage == index) Color.Black else Color.LightGray,
                        fontSize = 9.sp,
                        textAlign = TextAlign.Center,
                    )
                },
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun TabBarIncomeAndExpendses() {
    val pagerState = rememberPagerState()
    TabComponentOfMoney(pagerState = pagerState)
}
