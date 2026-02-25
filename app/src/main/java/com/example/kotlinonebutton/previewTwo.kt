package com.example.kotlinonebutton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun previewTwo(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp) // Memberi jarak antar kolom
    ) {
        // Kolom Pertama
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Judul Kiri", style = MaterialTheme.typography.titleMedium)
            Text(text = "Ini adalah deskripsi untuk kolom bagian kiri yang mungkin cukup panjang.")
        }

        // Kolom Kedua
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Judul Kanan", style = MaterialTheme.typography.titleMedium)
            Text(text = "Ini adalah deskripsi untuk kolom bagian kanan. Keduanya akan sejajar.")
        }
    }
}


@Composable
private fun TwoRowsThreeColumnsPreview() {
    MaterialTheme {
        previewTwo()
    }
}
