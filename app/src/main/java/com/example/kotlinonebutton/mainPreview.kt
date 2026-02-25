package com.example.kotlinonebutton


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun CalculatorLayout(
    viewModel: KalkulatorViewModel = viewModel()
) {

    val result: Double by viewModel.result.collectAsStateWithLifecycle()
    val inputCalc: String by viewModel.inputCalc.collectAsStateWithLifecycle()

    // State untuk menyimpan teks di setiap kolom
    var text1 by remember { mutableStateOf(inputCalc) }
    var text2 by remember { mutableStateOf("0") }
    var operator by remember { mutableStateOf("...") }
    var text3 by remember { mutableStateOf("=") }
    var text4 = result

    var activePosition by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Row pertama: TextView
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = inputCalc,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = if (activePosition == 1) FontWeight.Bold else FontWeight.Normal,
                color = if (activePosition == 1) Color.Blue else Color.Black
            )

            Text(
                text = "$operator  ",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = text2,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = if (activePosition == 2) FontWeight.Bold else FontWeight.Normal,
                color = if (activePosition == 2) Color.Blue else Color.Black
            )
            Text(
                text = text3,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = text4.toString(),
                style = MaterialTheme.typography.bodyLarge
            )
        }

        // Row kedua: 3 Custom Button
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 14.dp).padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            CustomOperatorButton(
                symbol = "⇄",
                onClick = {
                    activePosition = if (activePosition == 1) 2 else 1
                },
                backgroundColor = Color(0xFFFF9800)
            )
            CustomOperatorButton(
                symbol = "/",
                onClick = {
                    operator = "/"
                    // Tambahkan logika perhitungan di sini
                }
            )

            CustomOperatorButton(
                symbol = "*",
                onClick = {
                    operator = "*"
                    // Tambahkan logika perhitungan di sini
                }
            )

            CustomOperatorButton(
                symbol = "-",
                onClick = {
                    operator = "-"
                    // Tambahkan logika perhitungan di sini
                }
            )
        }

        Row (
            modifier = Modifier.fillMaxWidth().padding(top = 14.dp).padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            CustomOperatorButton(
                symbol = "7",
                onClick = {
                    onNumberInput(
                        number = "7",
                        activePosition = activePosition,
                        onUpdateText1 = { text1 = it },
                        onUpdateText2 = { text2 = it },
                        text1 = text1,
                        text2 = text2
                    )
                }
            )
            CustomOperatorButton(
                symbol = "8",
                onClick = {
                    onNumberInput(
                        number = "8",
                        activePosition = activePosition,
                        onUpdateText1 = { text1 = it },
                        onUpdateText2 = { text2 = it },
                        text1 = text1,
                        text2 = text2
                    )
                }
            )
            CustomOperatorButton(
                symbol = "9",
                onClick = {
                    onNumberInput(
                        number = "9",
                        activePosition = activePosition,
                        onUpdateText1 = { text1 = it },
                        onUpdateText2 = { text2 = it },
                        text1 = text1,
                        text2 = text2
                    )
                }
            )
            CustomOperatorButton(
                symbol = "+",
                onClick = {
                    viewModel.onEqualClicked(2.0, 3.0)
                    // Tambahkan logika perhitungan di sini
                }
            )
        }
        Row (
            modifier = Modifier.fillMaxWidth().padding(top = 14.dp).padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            CustomOperatorButton(
                symbol = "4",
                onClick = {
                    onNumberInput(
                        number = "4",
                        activePosition = activePosition,
                        onUpdateText1 = { text1 = it },
                        onUpdateText2 = { text2 = it },
                        text1 = text1,
                        text2 = text2
                    )
                }
            )
            CustomOperatorButton(
                symbol = "5",
                onClick = {
                    onNumberInput(
                        number = "5",
                        activePosition = activePosition,
                        onUpdateText1 = { text1 = it },
                        onUpdateText2 = { text2 = it },
                        text1 = text1,
                        text2 = text2
                    )
                }
            )
            CustomOperatorButton(
                symbol = "6",
                onClick = {
                    onNumberInput(
                        number = "6",
                        activePosition = activePosition,
                        onUpdateText1 = { text1 = it },
                        onUpdateText2 = { text2 = it },
                        text1 = text1,
                        text2 = text2
                    )
                }
            )
            CustomOperatorButton(
                symbol = "+",
                onClick = {
                    operator = "+"
                    // Tambahkan logika perhitungan di sini
                }
            )
        }
        Row (
            modifier = Modifier.fillMaxWidth().padding(top = 14.dp).padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            CustomOperatorButton(
                symbol = "1",
                onClick = {
                    onNumberInput(
                        number = "1",
                        activePosition = activePosition,
                        onUpdateText1 = { text1 = it },
                        onUpdateText2 = { text2 = it },
                        text1 = text1,
                        text2 = text2
                    )
                }
            )
            CustomOperatorButton(
                symbol = "2",
                onClick = {
                    onNumberInput(
                        number = "2",
                        activePosition = activePosition,
                        onUpdateText1 = { text1 = it },
                        onUpdateText2 = { text2 = it },
                        text1 = text1,
                        text2 = text2
                    )
                }
            )
            CustomOperatorButton(
                symbol = "3",
                onClick = {
                    onNumberInput(
                        number = "3",
                        activePosition = activePosition,
                        onUpdateText1 = { text1 = it },
                        onUpdateText2 = { text2 = it },
                        text1 = text1,
                        text2 = text2
                    )
                }
            )
            CustomOperatorButton(
                symbol = "Enter",
                onClick = {
                    operator = "="
                    // Tambahkan logika perhitungan di sini
                }
            )
        }
        Row (
            modifier = Modifier.fillMaxWidth().padding(top = 14.dp).padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            CustomOperatorButton(
                symbol = "C",
                onClick = {
                    text1 = "0"
                    text2 = "0"
                    text4 = 0.0
                    operator = "+"
                    activePosition = 1
                },
                backgroundColor = Color.Red
            )
            CustomOperatorButton(
                symbol = "0",
                onClick = {
                    onNumberInput(
                        number = "0",
                        activePosition = activePosition,
                        onUpdateText1 = { text1 = it },
                        onUpdateText2 = { text2 = it },
                        text1 = text1,
                        text2 = text2
                    )
                }
            )
            CustomOperatorButton(
                symbol = ".",
                onClick = {
                    onNumberInput(
                        number = ".",
                        activePosition = activePosition,
                        onUpdateText1 = { text1 = it },
                        onUpdateText2 = { text2 = it },
                        text1 = text1,
                        text2 = text2
                    )
                }
            )
            CustomOperatorButton(
                symbol = "Enter",
                onClick = {
                    operator = "="
                    // Tambahkan logika perhitungan di sini
                }
            )
        }
    }
}


@Composable
fun CustomOperatorButton(
    symbol: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFF4DD0E1)
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(64.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor // Warna cyan seperti di gambar
        )
    ) {
        Text(
            text = symbol,
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

fun onNumberInput(
    number: String,
    activePosition: Int,
    onUpdateText1: (String) -> Unit,
    onUpdateText2: (String) -> Unit,
    text1: String,
    text2: String
) {
    when (activePosition) {
        1 -> {
            onUpdateText1(
                if (text1 == "0") number else text1 + number
            )
        }
        2 -> {
            onUpdateText2(
                if (text2 == "0") number else text2 + number
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCalculatorLayout() {
    MaterialTheme {
        CalculatorLayout()
    }
}

