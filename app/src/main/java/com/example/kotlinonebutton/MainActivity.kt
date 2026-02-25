package com.example.kotlinonebutton

import NumericPad
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            MaterialTheme{
                Box(modifier = Modifier.fillMaxSize()
                    .systemBarsPadding()){
                    //CalculatorLayout()
                    NumericView()
                }

                //previewTwo()
                //menuScreen(

//                    topTexts = listOf("satu", "dua", "tiga"),
//                    bottomLabels = listOf("OK", "Simpan", "Batal"),
//                    onBottomButtonsClick = listOf(
//                        { /* TODO: handle OK */ },
//                        { /* TODO: handle Simpan */ },
//                        { /* TODO: handle Batal */ }
//
//                    )
                //)
            }
        }

//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}