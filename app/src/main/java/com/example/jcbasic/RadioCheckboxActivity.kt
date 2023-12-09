package com.example.jcbasic

import android.graphics.drawable.Icon
import android.os.Bundle
import com.example.jcbasic.ui.theme.JetPackComposeBasicTheme
import androidx.compose.ui.Modifier
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
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
fun PureRadioButton(){
    Column {
        RadioButton(
            selected = true,
            onClick = { /*TODO*/ },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Green,
                disabledSelectedColor = Color.Gray
            )
        )
        RadioButton(
            selected = false,
            onClick = { /*TODO*/ },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Green,
                disabledSelectedColor = Color.Gray
            )
        )
        RadioButton(
            enabled = false,
            selected = true,
            onClick = { /*TODO*/ },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Green,
                disabledSelectedColor = Color.Gray
            )
        )
    }
}

@Composable
fun RadioButtonWithText(){
    var isSelected by remember {
        mutableStateOf(false)
    };
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.selectable(
            selected = isSelected,
            onClick = { isSelected = !isSelected },
            role = Role.RadioButton
        )
    ) {
        RadioButton(
            selected = isSelected,
            onClick = {},
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Black,
                disabledSelectedColor = Color.Gray,
            )
        )
        Text(text = "Manually", modifier = Modifier.padding(start = 10.dp) )
        Text(text = " ${isSelected}" )
    }
}

@Composable
fun IconRadioButton(){
    var isSelected by remember{
        mutableStateOf(false)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.selectable(
            selected = isSelected,
            onClick = {isSelected = !isSelected},
            role = Role.RadioButton
        )
    ){
        val iconRadio = if(isSelected) Icons.Default.CheckCircle else Icons.Filled.CheckCircle
        Icon(iconRadio, contentDescription = null)
        Text(text = "Radio Button $isSelected", modifier = Modifier.padding(start = 10.dp))
    }
}

@Composable
fun RadioCheckboxColumn(){
    Column(modifier = Modifier.padding(15.dp)){
        PureRadioButton()
        Spacer(modifier = Modifier.height(10.dp))
        RadioButtonWithText()
        Spacer(modifier = Modifier.height(10.dp))
        IconRadioButton()
    }
}

@Preview(showBackground = true)
@Composable
fun RadioCheckboxPreview() {
    JetPackComposeBasicTheme {
        RadioCheckboxColumn()
    }
}