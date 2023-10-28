package com.example.jcbasic

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jcbasic.ui.theme.JetPackComposeBasicTheme

class ImageActivity :  ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ColImageContainer()
                }
            }
        }
    }
}

@Composable
fun ColImageContainer(){
    Column(modifier = Modifier.padding(15.dp)){
        BannerImageComposer()
        
    }
}

@Composable
fun BannerImageComposer(){

}

@Preview(showBackground = true)
@Composable
fun ImagePreview() {
    JetPackComposeBasicTheme {
        ColImageContainer()
    }
}