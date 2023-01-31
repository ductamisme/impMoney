package com.example.impmoney.ui.screen.mainscreen.moreScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.impmoney.data.MoreScreenIcon
import com.example.impmoney.ui.screen.appbar.TopBarMoreTheme
import com.example.impmoney.ui.theme.blueWhite


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MoreScreen() {
    val itemRowOne = listOf(
        MoreScreenIcon.Configuration,
        MoreScreenIcon.Style,
        MoreScreenIcon.FeedBack,
    )
    val itemRowTwo = listOf(
        MoreScreenIcon.Account,
        MoreScreenIcon.PCManager,
        MoreScreenIcon.Help,
    )
    val itemRowThree = listOf(
        MoreScreenIcon.Passcode,
        MoreScreenIcon.BackUp,
        MoreScreenIcon.Recommend
    )

    Scaffold(
        topBar = { TopBarMoreTheme() },
        backgroundColor = blueWhite
    ) {

        Spacer(modifier = Modifier.padding(14.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                itemRowOne.forEach() { item ->
                    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(108.dp)) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = item.title,
                                modifier = Modifier.size(30.dp)

                            )
                            Text(text = item.title)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                itemRowTwo.forEach() { item ->
                    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(108.dp)) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = item.title,
                                modifier = Modifier.size(30.dp)
                            )
                            Text(text = item.title)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            )  {
                itemRowThree.forEach() { item ->
                    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(108.dp)) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = item.title,
                                modifier = Modifier.size(30.dp)

                            )
                            Text(text = item.title)
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun TestMainMoreScreen() {
    MoreScreen()
}