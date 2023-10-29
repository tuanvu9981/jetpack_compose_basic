package com.example.jcbasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
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
        // Ảnh bị cắt khi vượt quá kích cỡ
        BannerImageComposer(ContentScale.Crop)
        Spacer(modifier = Modifier.height(10.dp))

        // Ảnh thu nhỏ lại cả dài lẫn rộng để vừa với kích cỡ
        BannerImageComposer(ContentScale.Fit)
        Spacer(modifier = Modifier.height(10.dp))

        // Icon vector
        VectorImageComposer()
        Spacer(modifier = Modifier.height(10.dp))

        // Painter
        CustomedPainter()
        Spacer(modifier = Modifier.height(10.dp))

        // Circle Avatar
        BuildCircleAvatar()
        Spacer(modifier = Modifier.height(10.dp))

        ShadowImage()
        Spacer(modifier = Modifier.height(10.dp))

        // URL image need emulator or physical devices
        // RenderURLImage()
    }
}

@Composable
fun BannerImageComposer(paramContentScale: ContentScale){
    // hiển thị ảnh màu
    Image(
        painterResource(id = R.drawable.doraemon),
        contentDescription = "Doraemon",
        contentScale = paramContentScale, // FIT, COVER, CONTAIN
        
        // old modifier: set height and fill width
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth(),

        alignment = Alignment.BottomEnd,
        // alignment bottom end will make image right-align (row)
        // and crop image at the top, left the bottom

    )
}

@Composable
fun ShadowImage(){
    Image(
        painterResource(id = R.drawable.doraemon),
        contentDescription = "Doraemon",

        modifier = Modifier
            .height(150.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(size = 8.dp)
            ),

        // aspectRatio(2f) will adjust the ratio between height and width
    )
}

@Composable
fun VectorImageComposer(){
    // hiển thị icon
    Image(
        imageVector = Icons.Filled.AccountBox,
        contentDescription = "Account Icon",
    )
}

@Composable
fun CustomedPainter(){
    Image(
        ColorPainter(color = Color.Green),
        contentDescription = "green color",
        modifier = Modifier.size(30.dp),
    )
}

@Composable
fun BuildCircleAvatar(){
    // 1st writing
    /*
    Image(
        painterResource(id = R.drawable.avatar),
        contentDescription = "Circle Avatar",
        modifier = Modifier.border(
            BorderStroke(2.dp, color = Color.Black),
            shape = CircleShape
        ).size(80.dp),

        // Nếu chỉ viết đến đây, avatar sẽ là ảnh hình chữ nhật
        // được 1 hình tròn đè lên, tuy vậy sẽ bị thừa ra 4 góc vuông
        contentScale = ContentScale.Crop
    )
    */

    // 2nd writing
    Surface(
        modifier = Modifier
            .border(
                BorderStroke(2.dp, color = Color.Black),
                shape = CircleShape
                // without shape, border will be square
            )
            .size(120.dp)
            .clip(shape = CircleShape),
        // without clip, image will be square
    ){
        Image(
            painterResource(id = R.drawable.avatar),
            contentDescription = "Circle Avatar",
        )
    }

}

@Composable
fun RenderURLImage(){
    Image(
        rememberAsyncImagePainter(model = "remote_URL"),
        contentDescription = "URL Image",
    )

    // Cho phép placeholder (trước khi ảnh URL load xong thì cho ảnh local vào)
    // Cho phép image error catcher (ảnh lỗi thì sẽ show ảnh nào thay thế ...)
}

@Preview(showBackground = true)
@Composable
fun ImagePreview() {
    JetPackComposeBasicTheme {
        ColImageContainer()
    }
}