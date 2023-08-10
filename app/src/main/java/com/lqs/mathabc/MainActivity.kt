package com.lqs.mathabc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lqs.mathabc.ui.theme.MathABCTheme
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MathABCTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

//                    MathABC()
//                    PlusABC()
                    NumberABC()
                }
            }
        }
    }
}

@Composable
fun MathABC() {
    val current = LocalConfiguration.current
    val size = current.screenWidthDp.coerceAtMost(current.screenHeightDp) * 0.4f
    val spacer = size / 6
    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier.align(Alignment.CenterHorizontally)
        ) {
            Spacer(modifier = Modifier.width(spacer.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .size(size.dp),
                content = {
                    Text("➕", fontSize = TextUnit(size * 0.4f, TextUnitType.Sp))
                })
            Spacer(modifier = Modifier.width(spacer.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .size(size.dp),
                content = { Text("➖", fontSize = TextUnit(size * 0.4f, TextUnitType.Sp)) })
            Spacer(modifier = Modifier.width(spacer.dp))
        }
        Spacer(modifier = Modifier.height(spacer.dp))
        Row(
            Modifier.align(Alignment.CenterHorizontally)
        ) {
            Spacer(modifier = Modifier.width(spacer.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .size(size.dp),
                content = { Text("✖️", fontSize = TextUnit(size * 0.4f, TextUnitType.Sp)) })
            Spacer(modifier = Modifier.width(spacer.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .size(size.dp),
                content = { Text("➗", fontSize = TextUnit(size * 0.4f, TextUnitType.Sp)) })
            Spacer(modifier = Modifier.width(spacer.dp))
        }
    }
}

@Composable
fun PlusABC() {
    var num1 by remember { mutableStateOf(0) }
    var num2 by remember { mutableStateOf(0) }
    var status by remember { mutableStateOf(0) }
    LaunchedEffect(key1 = status) {
        num1 = Random.nextInt(10)
        num2 = Random.nextInt(10)
    }

    Text(text = "$num1 + $num2 = ?")


    Random.nextInt(20)
}

@Composable
fun NumberABC() {
    var num by remember { mutableStateOf(0) }
    var status by remember { mutableStateOf(0) }
    LaunchedEffect(key1 = status) {
        num = Random.nextInt(40) + 1
    }
    val current = LocalConfiguration.current
    val size = remember {
        (current.screenWidthDp / 13).coerceAtMost(current.screenHeightDp/8)
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(size.dp))
        Text(
            text = "我们一起来数数吧",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Box(modifier = Modifier.size(size.dp)) {
                Text(
                    text = "$num",
                    style = TextStyle(fontSize = 32.sp, color = Color(0xFF009688)),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            (1..10).forEach {
                Box(modifier = Modifier.size(size.dp)) {
                    Text(
                        text = "$it",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.align(Alignment.Center), color = Color.LightGray
                    )
                }
            }
        }
        val i = num / 10
        (1..i + 1).forEach { index ->
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clip(MaterialTheme.shapes.small)
                    .background(
                        if (index % 2 == 0) Color(0xFFD8F8C4) else Color(0xFFFFE0FA)
                    )
            ) {
                if (index <= i) {
                    Box(modifier = Modifier.size(size.dp)) {
                        Text(
                            text = "$index",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.align(Alignment.Center), color = Color.White
                        )
                    }
                    (1..10).forEach {
                        Box(modifier = Modifier.size(size.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.strawberry),
                                contentDescription = "",
                                modifier = Modifier.align(
                                    Alignment.Center
                                )
                            )
                        }
                    }
                } else {
                    val j = num % 10
                    if (j > 0) {

                        Box(modifier = Modifier.size(size.dp))
                        (1..10).forEach {
                            Box(modifier = Modifier.size(size.dp)) {
                                if (it <= j) {
                                    Image(
                                        painter = painterResource(id = R.drawable.strawberry),
                                        contentDescription = "",
                                        modifier = Modifier.align(
                                            Alignment.Center
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
        }

        Spacer(modifier = Modifier.weight(1f, true))

        Button(
            onClick = { status++ },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF009688))
        ) {
            Text(text = "太棒了,再来一次", style = MaterialTheme.typography.titleMedium)
        }
        Spacer(modifier = Modifier.height(30.dp))
    }


}