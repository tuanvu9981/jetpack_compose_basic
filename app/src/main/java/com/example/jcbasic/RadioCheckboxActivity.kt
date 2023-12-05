package com.example.jcbasic

import android.os.Bundle
import com.example.jcbasic.ui.theme.JetPackComposeBasicTheme
import androidx.compose.ui.Modifier
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class RadioCheckboxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RadioCheckboxColumn()
                }
            }
        }
    }
}

@Composable
fun RadioCheckboxColumn(){
    Column(modifier = Modifier.padding(15.dp)){

    }
}

@Preview(showBackground = true)
@Composable
fun RadioCheckboxPreview() {
    JetPackComposeBasicTheme {
        RadioCheckboxColumn()
    }
}