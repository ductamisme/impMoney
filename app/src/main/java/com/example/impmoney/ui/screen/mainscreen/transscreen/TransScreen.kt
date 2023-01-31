package com.example.impmoney.ui.screen.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.impmoney.data.TabBarNavgationItemTrans
import com.example.impmoney.ui.screen.appbar.TabComponentOfTime
import com.example.impmoney.ui.screen.appbar.TopBarDecorTrans
import com.example.impmoney.ui.theme.blueWhite
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TransScreen() {
    val tabs = listOf(
        TabBarNavgationItemTrans.Daily,
        TabBarNavgationItemTrans.Calendar,
        TabBarNavgationItemTrans.Weekly,
        TabBarNavgationItemTrans.Monthly,
        TabBarNavgationItemTrans.Total
    )

    val pagerState = rememberPagerState()
    Scaffold(
        backgroundColor = blueWhite,
        topBar = { TopBarDecorTrans() },
        bottomBar = {
            BottomAppBar(backgroundColor = Color.LightGray) {
                Text(text = "heloo")
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
            }
        }
    ) {
        Column() {
            TabComponentOfTime(pagerState = pagerState)
            NumberUnderText()
            TabsContent(tabs = tabs, pagerState = pagerState)
        }
    }
}
// this very important for tab bar because it help tab bar work
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(tabs: List<TabBarNavgationItemTrans>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabs.size) { page ->
        tabs[page].screen()
    }
}

// this code help tab bar see
@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun TabsContentPreview() {
    val tabs = listOf(
        TabBarNavgationItemTrans.Daily,
        TabBarNavgationItemTrans.Calendar,
        TabBarNavgationItemTrans.Weekly,
        TabBarNavgationItemTrans.Monthly,
        TabBarNavgationItemTrans.Total
    )
    val pagerState = rememberPagerState(initialPage = tabs.size)
    TabsContent(tabs = tabs, pagerState = pagerState)
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    TransScreen()
}

// income + expenses + total
@Composable
fun NumberUnderText() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .height(40.dp)
                .weight(1f), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                fontSize = 12.sp,
                text = "Income",
                color = Color.Black,
                textAlign = TextAlign.Center,
            )

            Text(
                text = "0",
                color = Color.Blue,
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = Modifier
                .height(40.dp)
                .weight(1f), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                fontSize = 12.sp,
                text = "Expenses",
                color = Color.Black,
                textAlign = TextAlign.Center,
            )

            Text(
                text = "0",
                color = Color.Red,
                textAlign = TextAlign.Center
            )
        }

        Column(
            modifier = Modifier
                .height(40.dp)
                .weight(1f), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                fontSize = 12.sp,
                text = "Total",
                color = Color.Black,
                textAlign = TextAlign.Center,
            )

            Text(
                text = "0",
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun DailyScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(blueWhite)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Daily View",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DailyScreenPreview() {
    DailyScreen()
}

@Composable
fun CalenderScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(blueWhite)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Calender View",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalenderScreenPreview() {
    CalenderScreen()
}

@Composable
fun WeeklyScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(blueWhite)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Weekly View",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WeeklyScreenPreview() {
    WeeklyScreen()
}

@Composable
fun MonthlyScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(blueWhite)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Monthly View",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MontlyScreenPreview() {
    MonthlyScreen()
}

@Composable
fun TotalScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(blueWhite)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Total View",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TotalScreenPreview() {
    TotalScreen()
}
