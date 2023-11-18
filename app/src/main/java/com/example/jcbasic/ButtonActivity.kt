package com.example.jcbasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.jcbasic.ui.theme.JetPackComposeBasicTheme
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import okhttp3.internal.wait


class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    // định nghĩa style cho cả ứng dụng
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ColButtonContainer()
                }
            }
        }
    }
}

@Composable
fun ColButtonContainer(){
    Column(modifier = Modifier
        .padding(15.dp)
        .clickable {
            // Modifier có method clickable
            // Cho phép bất kỳ Composable nào có thể click được
            // Image, Text, ... đều có thể clickable
        }){

        Row {
            SimpleButton()
            Spacer(modifier = Modifier.width(10.dp))
            DisableButton()
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row {
            AddToCartButton()
            Spacer(modifier = Modifier.width(10.dp))
            StrokeButton()
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row {
            ElevationSimpleButton()
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text="Outlined ボタン")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row {
            TextButton(onClick = { /*TODO*/ }) {
                Text(text="Text Button")
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Phone, contentDescription = "Calling")
            }
        }

        OnClickButton()
        PressTypesButton()

    }
}

@Composable()
fun PressTypesButton(){
    var textContent = remember {
        mutableStateOf("")
    }
    Column{
        Text("Text content: ${textContent.value}", style = TextStyle(color = Color.Green))
        Text(text = "Click to see", modifier = Modifier.pointerInput(Unit){
            detectTapGestures(
                onDoubleTap = {
                    textContent.value = "Double Tap"
                },

                onLongPress = {
                    textContent.value = "Long Press"
                },

                onPress = {
                    textContent.value = "Press"
                },

                onTap = {
                    textContent.value = "Tap"
                }
            )
        })
    }

}

@Composable()
fun OnClickButton(){
    var count = remember {
        mutableStateOf(0)
    }
    Row() {
        Button(
            onClick = {
                count.value++
            },
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(text="Click to increase")
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(text="Clicked times: ${count.value}")
    }
}

@Composable()
fun ElevationSimpleButton(){
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black,
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp,
        )
        // độ nổi bóng (shadow) so với bề mặt xung quanh, mặc định 10dp

    ){
        Text(text="Elevation Button")
    }
}

@Composable()
fun SimpleButton(){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red, //replace backgroundColor
            contentColor = Color.White // text button color
        )
    ) {
        Text(text = "Click me", style = TextStyle(
            color = Color.Black // Quy định mạnh hơn content color ở phía trên
        ))
    }
}

@Composable()
fun DisableButton(){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = Color.Gray, // background color khi bị vô hiệu hóa
            disabledContentColor = Color.Black // màu của chữ khi button bị vô hiệu hóa
        ),
        enabled = false, // thuộc tính khiến button bị vô hiệu hóa
    ) {
        Text(text = "Disable Button", )
    }
}

@Composable()
fun AddToCartButton(){
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Magenta,
            contentColor = Color.White, // áp dụng luôn cho cả Icon và Text bên trong button
        ),
        shape = RoundedCornerShape(5.dp)
        // thuộc tính shape điều khiển hình dạng của Button
        // mặc định là hình chữ nhật nhưng bo góc quá đà ...
        // 5.dp là bo góc tròn cho hình chữ nhật vừa phải cho tất cả các chiều
        // có thể căn chỉnh topStart, topEnd ... để lựa chọn góc nào muốn căn

    ){
        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
        Text(text="Add to cart")

        // default của Button là các element con theo chiều ngang
        // Để custom theo chiều dọc thì cần bọc Icon và Text vào Column(){...}

    }
}

@Composable()
fun StrokeButton(){
    Button(
        onClick = {},
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(
            width = 2.dp,
            color=Color.Blue
        ),
        // thuộc tính border giúp điều khiển đường viền ngoài của button
        // xem màu sắc ra sao, dày mỏng thế nào ...

        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent, // style outlined
            contentColor = Color.Blue,
        )
    ){
        Text(text="Stroke Button")
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    JetPackComposeBasicTheme {
        ColButtonContainer()
    }
}