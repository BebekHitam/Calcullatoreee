package com.example.kotlinonebutton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun theFront() {

    var text1 by remember { mutableStateOf("Text 1") }
    var text2 by remember { mutableStateOf("Text 2") }
    var text3 by remember { mutableStateOf("Text 3") }
    var text4 by remember { mutableStateOf("Text 4") }
    var text5 by remember { mutableStateOf("Text 5") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        // ===== Row Text =====
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {


            Text("Text1", Modifier.weight(1f), textAlign = TextAlign.Center)
            Text("...", Modifier.weight(1f), textAlign = TextAlign.Center)
            Text("Text2", Modifier.weight(1f), textAlign = TextAlign.Center)
            Text("=", Modifier.weight(1f), textAlign = TextAlign.Center)
            Text("Text3", Modifier.weight(1f), textAlign = TextAlign.Center)
        }

        // ===== Row Button =====
        Row(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val buttonModifier = Modifier
                .weight(1f)
                .aspectRatio(1f)

            Button(
                onClick = { text2 = "-" },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
            ) {
                Text("*", fontSize = 20.sp)
            }

            Button(
                onClick = { text2 = "+" },
                modifier =  buttonModifier
            ) {
                Text("+", fontSize = 20.sp)
            }

            Button(
                onClick = { text2 = "*" },
                modifier = buttonModifier
            ) {
                Text("-", fontSize = 20.sp)
            }

        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val buttonModifier = Modifier
                .weight(1f)
                .aspectRatio(1f)

            Button(
                onClick = { text2 = "1" },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
            ) {
                Text("1", fontSize = 20.sp)
            }

            Button(
                onClick = { text2 = "2" },
                modifier =  buttonModifier
            ) {
                Text("2", fontSize = 20.sp)
            }

            Button(
                onClick = { text2 = "3" },
                modifier = buttonModifier
            ) {
                Text("3", fontSize = 20.sp)
            }

        }


    }
}
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun TwoRowsThreeColumnsPreview() {
    MaterialTheme {
        theFront()
    }
}
