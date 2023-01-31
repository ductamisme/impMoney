package com.example.impmoney.ui.screen.mainscreen.statsscreen

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.impmoney.ui.theme.*
import com.example.mymoney.ui.theme.*
import kotlin.math.PI
import kotlin.math.atan2

@Composable
fun PieChartYTTheme() {
    NewPieChart(
        input = listOf(
            PieChartInput(
                color = LightBlue,
                value = 55,
                description = "necessity"
            ),
            PieChartInput(
                color = Purple200,
                value = 10,
                description = "financial freedom"
            ),
            PieChartInput(
                color = Purple500,
                value = 10,
                description = "educations"
            ),
            PieChartInput(
                color = Teal200,
                value = 10,
                description = "enjoys"
            ),
            PieChartInput(
                color = green,
                value = 10,
                description = "give"
            ),
            PieChartInput(
                color = orange,
                value = 5,
                description = "long term saving"
            ),
        ),
//        centerText = "100% total salary"
    )
}


@Composable
fun NewPieChart(
    radius: Float = 300f,
    innerRadius: Float = 200f,
    transParentWidth: Float = 42f,
    input: List<PieChartInput>,
    centerText: String = ""
) {
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    var inputList by remember {
        mutableStateOf(input)
    }

    var isCenterTapped by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier, contentAlignment = Alignment.Center) {
        Canvas(
            modifier = Modifier
                .size(300.dp)// determined the true space user can tap
                .pointerInput(true) {
                    detectTapGestures(
                        // check when the user clicked in the circle or not
                        onTap = { offset ->
                            val tapAngleInDegrees = (-atan2(
                                x = circleCenter.y - offset.y,
                                y = circleCenter.x - offset.x
                            ) * (180f / PI).toFloat() - 90f).mod(360f)

                            val centerClicked = if (tapAngleInDegrees < 90) {
                                offset.x < circleCenter.x + innerRadius && offset.y < circleCenter.y + innerRadius
                            } else if (tapAngleInDegrees < 180) {
                                offset.x > circleCenter.x - innerRadius && offset.y < circleCenter.y + innerRadius
                            } else if (tapAngleInDegrees < 270) {
                                offset.x > circleCenter.x - innerRadius && offset.y > circleCenter.y - innerRadius
                            } else {
                                offset.x < circleCenter.x + innerRadius && offset.y > circleCenter.y - innerRadius
                            }

                            //determined the specific item user clicked
                            if (centerClicked) {
                                inputList = inputList.map {
                                    it.copy(isTapped = !isCenterTapped)
                                }
                                isCenterTapped = !isCenterTapped
                            } else {
                                val anglePerValue = 360f / input.sumOf {
                                    it.value
                                }

                                var currentAngle = 0f
                                inputList.forEach() { pieChartInput ->
                                    currentAngle += pieChartInput.value * anglePerValue

                                    if (tapAngleInDegrees < currentAngle) {
                                        val description = pieChartInput.description

                                        inputList = inputList.map {
                                            if (description == it.description) {
                                                it.copy(isTapped = !it.isTapped)
                                            } else {
                                                it.copy(isTapped = false)
                                            }
                                        }
                                        return@detectTapGestures
                                    }
                                }
                            }
                        }
                    )
                }

        ) {
            val width = size.width
            val height = size.height

            circleCenter = Offset(x = width / 2f, y = height / 2f)

            val totalValue = input.sumOf {
                it.value
            }

            val anglePerValue = 360f / totalValue
            var currentStartAngle = 0f

            inputList.forEach() { PieChartInput ->
                val scale = if (PieChartInput.isTapped) 1.1f else 1.0f
                val angleToDraw = PieChartInput.value * anglePerValue

                scale(scale) {
                    drawArc(
                        color = PieChartInput.color,
                        startAngle = currentStartAngle,
                        sweepAngle = angleToDraw,
                        useCenter = true,
                        size = Size(
                            width = radius * 2f,
                            height = radius * 2f
                        ),
                        topLeft = Offset(
                            x = (width - radius * 2f) / 2f,
                            y = (height - radius * 2f) / 2f
                        )
                    )
                    currentStartAngle += angleToDraw
                }
                // how can we see percent in canvas
                var rotateAngle = currentStartAngle - angleToDraw / 2f - 90f
                var factor = 1f
                if (rotateAngle > 90f) {
                    rotateAngle = (rotateAngle + 180).mod(360f)
                    factor = -0.92f
                }
                val percentage = (PieChartInput.value / totalValue.toFloat() * 100).toInt()

                drawContext.canvas.nativeCanvas.apply {
                    if (percentage > 3) {
                        rotate(rotateAngle) {
                            drawText(
                                "$percentage %",
                                circleCenter.x,
                                circleCenter.y + (radius - (radius - innerRadius) / 2f) * factor,
                                Paint().apply {
                                    textSize = 12.sp.toPx()
                                    textAlign = Paint.Align.CENTER
                                    color = white.toArgb()
                                }
                            )
                        }
                    }
                }// how can we see percent in canvas

                //this is 3 block code to implement some singleLine to separate
                if (PieChartInput.isTapped) {
                    val tabRotation = currentStartAngle - angleToDraw - 90f
                    rotate(tabRotation) {
                        drawRoundRect(
                            topLeft = circleCenter,
                            size = Size(4f, radius * 1.1f),// when user chose 1 topic this is the border side shorter
                            color = blueWhite,
                            cornerRadius = CornerRadius(1f, 1f)
                        )
                    }
                    rotate(tabRotation + angleToDraw) {
                        drawRoundRect(
                            topLeft = circleCenter,
                            size = Size(4f, radius * 1.1f),// when user chose 1 topic this is the border side longer
                            color = blueWhite,
                            cornerRadius = CornerRadius(1f, 1f)
                        )
                    }
                    rotate(rotateAngle) {
                        drawContext.canvas.nativeCanvas.apply {
                            drawText(
                                "${PieChartInput.description}",//: ${PieChartInput.value}"
                                circleCenter.x,
                                circleCenter.y + radius * 1.3f * factor,
                                Paint().apply {
                                    textSize = 12.sp.toPx()
                                    textAlign = Paint.Align.CENTER
                                    color = Color.Black.toArgb()// color of top
                                    isFakeBoldText = true
                                }
                            )
                        }
                    }
                }
            }

            if (inputList.first().isTapped) {
                rotate(-90f) {
                    drawRoundRect(
                        topLeft = circleCenter,
                        size = Size(4f, radius * 1.1f),// modifier border of each pie chart
                        color = blueWhite,
                        cornerRadius = CornerRadius(1f, 1f)
                    )
                }
            }
            //this is 3 block code to implement some singleLine to separate
            drawContext.canvas.nativeCanvas.apply {
                drawCircle(
                    circleCenter.x,
                    circleCenter.y,
                    innerRadius,
                    Paint().apply {
                        color = white.toArgb()// this is the code modifier color of the inner circle
//                        setShadowLayer(5f, 0f, 0f, Color.White.toArgb())
                        // exactly like it name it make the inner circle have shadow
                    }
                )
            }
            // the inner circle
            drawCircle(
                color = Color.White.copy(0.1f),
                radius = innerRadius * transParentWidth / 2f
            )
        }

        Text(
            centerText, modifier = Modifier
                .width(Dp(innerRadius / 1.5f))
                .padding(25.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}


data class PieChartInput(
    val color: Color,
    val value: Int,
    val description: String,
    val isTapped: Boolean = false
)

@Preview
@Composable
fun test() {
    PieChartYTTheme()
}