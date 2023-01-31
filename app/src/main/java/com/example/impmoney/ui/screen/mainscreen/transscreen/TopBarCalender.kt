package com.example.impmoney.ui.screen.mainscreen.transscreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Calender() {
    var pickedDate by remember {
        mutableStateOf(LocalDate.now())
    }

    var pickedTime by remember {
        mutableStateOf(LocalTime.NOON)
    }

    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter.ofPattern("MMM dd yyyy").format(pickedDate)
        }
    }

    val formattedTime by remember {
        derivedStateOf {
            DateTimeFormatter.ofPattern("hh:mm").format(pickedTime)
        }
    }

    val dateDialogState = rememberMaterialDialogState()
    val timeDialogState = rememberMaterialDialogState()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { dateDialogState.show() }) {
            Text(text = "pick date")
        }

        Text(text = formattedDate)

        Spacer(modifier = Modifier.padding(30.dp))

        Button(onClick = { timeDialogState.show() }) {
            Text(text = "pick time")
        }

        Text(text = formattedTime)
    }
    MaterialDialog(
        dialogState = dateDialogState,
        buttons = {
            positiveButton(text = "Ok") {
//                Toast.makeText(
//                    context,
//                    "Clicked ok",
//                    Toast.LENGTH_LONG
//                ).show()
            }
            negativeButton(text = "Cancel")
        }
    ) {
        datepicker(initialDate = LocalDate.now(), title = "pick date", allowedDateValidator = {
            it.dayOfMonth % 2 == 1
        }) {
            pickedDate = it
        }
    }
    MaterialDialog(
        dialogState = timeDialogState,
        buttons = {
            positiveButton(text = "Ok") {
//                Toast.makeText(
//                    context,
//                    "Clicked ok",
//                    Toast.LENGTH_LONG
//                ).show()
            }
            negativeButton(text = "Cancel")
        }
    ) {
        timepicker(
            initialTime = LocalTime.NOON,
            title = "pick time",
            timeRange = LocalTime.MIDNIGHT..LocalTime.NOON
        ) {
            pickedTime = it
        }
    }
}

//var mBase: Context
//    get() {
////        TODO()
//    }
//    set(value) {}
//
//fun getApplicationContext(): Context? {
//    return mBase?.applicationContext
//}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun Test() {
    Calender()
}