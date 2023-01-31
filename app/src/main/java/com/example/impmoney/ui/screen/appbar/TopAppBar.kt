package com.example.impmoney.ui.screen.appbar

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mymoney.R

@Composable
fun TopBarDecorTrans(
) {
    TopAppBar(
        backgroundColor = Color.White,
        title = {},
        navigationIcon = {
            KeyBoardArrowLeft()
//            Text(text = "this time", modifier = Modifier.width(50.dp))
            KeyBoardArrowRight()
        },
        actions = {
            StarItemIcon()
            SearchItemIcon()
            SelectItemIcon()
        }
    )
}

@Preview
@Composable
fun TopbarTransTheme() {
    TopBarDecorTrans()
}

@Composable
fun TopBarDecorStats() {
    TopAppBar(
        backgroundColor = Color.White,
        title = {},
        navigationIcon = {
            KeyBoardArrowLeft()
//            Text(text = "this time", modifier = Modifier.width(50.dp))
            KeyBoardArrowRight()
        },
        actions = {
            DropDownMenu()

        }
    )
}

@Composable
fun DropDownMenu() {
    var expanded by remember { mutableStateOf(false) }

    val list = listOf("Weekly", "Monthly", "Annually", "Period")

    var selectedItem by remember { mutableStateOf("Monthly") }

    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }
    Column(
    ) {
        Box() {
            TextButton(onClick = { expanded = true }) {
                Row() {
                    Text(
                        text = "$selectedItem",
                        color = colorResource(id = R.color.black),
                        fontSize = 12.sp
                    )
                    Icon(icon, contentDescription = "", tint = Color.Black)
                }
            }
        }

        DropdownMenu(
            expanded = expanded, onDismissRequest = { expanded = false },
//            modifier = Modifier.width(with(LocalDensity.current) { textFiledSize.width.toDp() })
        ) {
            list.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedItem = label
                    expanded = false
                }) {
                    Text(text = label)
                }
            }
        }

    }
}

@Preview
@Composable
fun TopbarStatsTheme() {
    TopBarDecorStats()
}

@Composable
fun TopBarAccountTheme() {
    TopAppBar(
        backgroundColor = Color.White,
        title = {},
        navigationIcon = {
            Text(text = "Accounts", textAlign = TextAlign.Center, fontSize = 16.sp)
        },
        actions = {
            StatusItemIcon()
            DropMenuMoveVert()
        }
    )
}

@Composable
fun TopBarMoreTheme() {
    TopAppBar(
        backgroundColor = Color.White,
        title = {},
        navigationIcon = {
            Text(text = "Setings", textAlign = TextAlign.Center, fontSize = 18.sp)
        },
        actions = { Text(text = "4.6.33.AD", color = Color.Gray)}
    )
}

@Preview
@Composable
fun test4(){
    TopBarMoreTheme()
}

@Composable
fun StatusItemIcon() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.Home,
            contentDescription = "status"
        )
    }
}

@Preview
@Composable
fun test() {
    TopBarAccountTheme()
}

@Composable
fun DropMenuMoveVert() {

    val listItems = arrayOf("Add", "Show/Hide", "Delete", "Modify Orders")

//    val disabledItem = 1

    val contextForToast = LocalContext.current.applicationContext

    var expanded by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.Center
    ) {

        // options button
        IconButton(onClick = {
            expanded = true
        }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Open Options"
            )
        }

        // drop down menu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            // adding items
            listItems.forEachIndexed { itemIndex, itemValue ->
                DropdownMenuItem(
                    onClick = {
                        Toast.makeText(contextForToast, itemValue, Toast.LENGTH_SHORT)
                            .show()
                        expanded = false
                    },
//                    enabled = (itemIndex != disabledItem)
                ) {
                    Text(text = itemValue)
                }
            }
        }
    }
}

@Composable
fun SelectItemIcon() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.List,
            contentDescription = stringResource(id = R.string.select)
        )
    }
}

@Composable
fun SearchItemIcon() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.select)
        )
    }
}

@Composable
fun StarItemIcon() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = stringResource(id = R.string.select)
        )
    }
}

@Composable
fun KeyBoardArrowLeft() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.KeyboardArrowLeft,
            contentDescription = stringResource(id = R.string.select)
        )
    }
}

@Composable
fun KeyBoardArrowRight() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.KeyboardArrowRight,
            contentDescription = stringResource(id = R.string.select)
        )
    }
}