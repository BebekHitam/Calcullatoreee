package com.example.kotlinonebutton

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun NumericView(
    viewModel: CalcViewModel =  viewModel()
){
    val result: Double by viewModel.result.collectAsStateWithLifecycle()
    val numClicked: Double by viewModel.result.collectAsStateWithLifecycle()
    val operator = viewModel.operators
    val textA = viewModel.textA
    val textB = viewModel.textB
    val activePosition = viewModel.activePosition

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){ Row(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 16.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
        Text(
            text = textA,
            modifier = Modifier.clickable{
                viewModel.currentActivePosition(1)
            } ,
            fontWeight = if (activePosition == 1) FontWeight.Bold else FontWeight.Normal,
            color = if (activePosition == 1) Color.Blue else Color.Black
        )
        Text(
            text = operator
        )
        Text(
            text = textB,
            modifier = Modifier.clickable{
                viewModel.currentActivePosition(2)
            },
            fontWeight = if (activePosition == 2) FontWeight.Bold else FontWeight.Normal,
            color = if (activePosition == 2) Color.Blue else Color.Black
        )
        Text(
            text = "="
        )
        Text(text = result.toString(),
            style = MaterialTheme.typography.bodyLarge)
    }

        //row kedua ada disini, taruh operator
        //ku mau coba menggunakan array
        val operators = listOf<String>("+", "-", "/", "*")

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp)
            .padding(bottom = 16.dp), horizontalArrangement = Arrangement.spacedBy(16.dp,
            Alignment.CenterHorizontally)) {
            operators.forEach { syimbol ->
                CustomButtonA(
                    symbol = syimbol,
                    onClick = {viewModel.onOperatorClick(it) }
                )
            }
        }

        //row selanjutnya copy dari atas, tapi sekarang angka
        val numC = listOf<String>("1", "2", "3", ".")
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp)
            .padding(bottom = 16.dp), horizontalArrangement = Arrangement.spacedBy(16.dp,
            Alignment.CenterHorizontally)) {
            numC.forEach { numC ->
                CustomButtonA(
                    symbol = numC,
                    onClick = {viewModel.onNumClick(it) }
                )
            }
        }
        val numB = listOf<String>("4", "5", "6", ".")
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp)
            .padding(bottom = 16.dp), horizontalArrangement = Arrangement.spacedBy(16.dp,
            Alignment.CenterHorizontally)) {
            numB.forEach { numB ->
                CustomButtonA(
                    symbol = numB,
                    onClick = {viewModel.onNumClick(it) }
                )
            }
        }
        val numA = listOf<String>("7", "8", "9", "0")
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp)
            .padding(bottom = 16.dp), horizontalArrangement = Arrangement.spacedBy(16.dp,
            Alignment.CenterHorizontally)) {
            numA.forEach { numA ->
                CustomButtonA(
                    symbol = numA,
                    onClick = {viewModel.onNumClick(it) }
                )
            }
        }

        val controlChara = listOf<String>("X", "x", "C", "<")

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp)
            .padding(bottom = 16.dp), horizontalArrangement = Arrangement.spacedBy(16.dp,
            Alignment.CenterHorizontally)) {
            CustomButtonA(
                symbol = "⌫",
                onClick = { viewModel.onBackspace() },
                backgroundColor = Color.Gray
            )
            CustomButtonA(
                symbol = "=",
                onClick = { viewModel.hitung() },
                backgroundColor = Color.Yellow
            )

        }



    }


}