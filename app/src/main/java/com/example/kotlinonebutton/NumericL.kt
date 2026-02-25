import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumericPad() {
    // Struktur data untuk tombol (Label Utama, Sub-label)
    val buttons = listOf(
        "num lock" to "scr lock", "/" to "", "*" to "", "-" to "",
        "7" to "home", "8" to "↑", "9" to "pgup",
        "4" to "←", "5" to "", "6" to "→",
        "1" to "end", "2" to "↓", "3" to "pgdn",
        "0" to "insert", "." to "delete"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Bagian Kiri (Grid 4 Kolom untuk tombol numpad)
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.weight(4f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                count = buttons.size,
                span = { index ->
                    // Tombol "0" mengambil 2 kolom
                    if (buttons[index].first == "0") {
                        GridItemSpan(2)
                    } else {
                        GridItemSpan(1)
                    }
                }
            ) { index ->
                val (main, sub) = buttons[index]

                NumpadButton(
                    mainText = main,
                    subText = sub,
                    modifier = Modifier
                        .height(64.dp)
                        .fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Bagian Kanan (Tombol + dan Enter yang tinggi)
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            NumpadButton(
                mainText = "+",
                subText = "",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            NumpadButton(
                mainText = "↵",
                subText = "enter",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun NumpadButton(
    mainText: String,
    subText: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
            .clickable { /* Handle Click */ }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = mainText,
                fontSize = if (mainText.length > 3) 10.sp else 18.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = if (mainText.length > 3) 12.sp else 18.sp
            )
            if (subText.isNotEmpty()) {
                Text(
                    text = subText,
                    fontSize = 10.sp,
                    color = Color.Gray
                )
            }
        }
    }
}