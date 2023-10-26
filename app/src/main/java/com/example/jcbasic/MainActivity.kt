package com.example.jcbasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jcbasic.ui.theme.JetPackComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ColContainer()
                }
            }
        }
    }
}

@Composable
fun ColContainer(){
    Column(modifier = Modifier.padding(15.dp)){
        Greeting(name = "Android")
        GreetingWithMaxLine(name = "Android")
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        // or Spacer(modifier = Modifier.height(15)))
        MultipleStyleInText()
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        ParagraphText()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello ${stringResource(id = R.string.app_name)} $name!",
        modifier = modifier,
//        color = Color.Red,
        fontSize = 30.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold, //FontWeight(200),
        textAlign = TextAlign.End,
        fontFamily = FontFamily.Cursive,
        textDecoration = TextDecoration.LineThrough, // gạch xuyên qua chữ (line-through) hoặc gạch chân (underline)

        // chỉ có hiệu lực khi các thông số color, fontSize ... không khai báo
        // dùng khi muốn định nghĩa style cho toàn bộ CÁC TEXT
        // tăng tính thống nhất, dễ sửa đổi
        style = TextStyle(
            color = Color.Green
        )
    )
}

@Composable
fun GreetingWithMaxLine(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello, ${stringResource(id = R.string.github_action)}",
        color = Color.Red,
        textAlign = TextAlign.Start,
        maxLines = 2, // real: 4 lines,
        overflow = TextOverflow.Ellipsis, // show that texts go on
    )
}

@Composable
fun MultipleStyleInText(){
    // SpanStyle: áp dụng cho từng ký tự một
    Text(text = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
            append("Họ và tên: ")
        }
        withStyle(style = SpanStyle(color = Color.Blue)){
            append("Nguyễn Văn A ")
        }
        append("(ghi bằng bút bi xanh)")
    })
}

@Composable
fun ParagraphText(){
    // ParagraphStyle: áp dụng cho cả đoạn văn dài
    Text(text = buildAnnotatedString {
        withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)){
            append("This is the trigger of the workflow. In our case the workflow is triggered when a push occurs but other options include pull_request, merge e.t.c basically any of the Github Actions (Hence the name). You can set up several in one page too but it best practice to have one per workflow file.")
        }
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackComposeBasicTheme {
        ColContainer()
    }
}