package com.example.impmoney.ui.screen.mainscreen.accountscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.impmoney.ui.screen.appbar.TopBarAccountTheme
import com.example.impmoney.ui.theme.blueWhite
import com.example.impmoney.ui.theme.orange

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AccountScreen() {
    Scaffold(
        backgroundColor = blueWhite,
        topBar = { TopBarAccountTheme() }
    ) {
        Column {
            NumberUnderText()

            Moneytext()

            BankText()

            CardBankText()
        }
    }
}

@Composable
fun NumberUnderText() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .height(50.dp)
                .weight(1f), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                fontSize = 12.sp,
                text = "Assets",
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(5.dp)
            )

            Text(
                text = "0",
                color = Color.Blue,
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = Modifier
                .height(50.dp)
                .weight(1f), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                fontSize = 12.sp,
                text = "Liabilities",
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(5.dp)

            )

            Text(
                text = "0",
                color = Color.Red,
                textAlign = TextAlign.Center
            )
        }

        Column(
            modifier = Modifier
                .height(50.dp)
                .weight(1f), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                fontSize = 12.sp,
                text = "Total",
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(5.dp)

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
fun Moneytext() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(42.dp),
        horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "Tiền mặt",
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 16.dp), fontWeight = FontWeight.Normal
        )
        Text(
            text = "0 đ",
            color = orange,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 16.dp)
        )
    }

    Button(
        onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Tiền mặt",
                fontSize = 12.sp,
                color = Color.Black, fontWeight = FontWeight.Normal
            )
            Text(
                text = "0 đ",
                color = orange,
                fontSize = 14.sp,
            )
        }
    }
}

@Composable
fun BankText() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(42.dp),
        horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "Tài khoản ngân hàng",
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
        Text(
            text = "0 đ",
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier.padding(end = 16.dp)
        )
    }

    Button(
        onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Tài khoản ngân hàng",
                fontSize = 12.sp,
                color = Color.Black, fontWeight = FontWeight.Normal
            )
            Text(
                text = "0 đ",
                color = Color.Black,
                fontSize = 14.sp, fontWeight = FontWeight.Normal
            )
        }
    }
}

@Composable
fun CardBankText() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(14.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Balance Payable",
            fontSize = 12.sp,
            modifier = Modifier.padding(end = 28.dp)
        )
        Text(
            text = "Outst. Balance",
            color = Color.Black,
            fontSize = 12.sp,
            modifier = Modifier.padding(end = 16.dp)
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(28.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = "Thẻ tín dụng",
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
        Text(
            text = "0 đ",
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 70.dp)
        )
        Text(
            text = "0 đ",
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 16.dp)
        )
    }

    Button(
        onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black,
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Thẻ tín dụng",
                fontSize = 12.sp,
                color = Color.Black, fontWeight = FontWeight.Normal
            )
            Text(
                text = "0 đ",
                color = Color.Black,
                fontSize = 14.sp, fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(start = 65.dp)
            )

            Text(
                text = "0 đ",
                color = Color.Black,
                fontSize = 14.sp, fontWeight = FontWeight.Normal
            )
        }
    }
}


@Preview
@Composable
fun preview() {
    AccountScreen()
}