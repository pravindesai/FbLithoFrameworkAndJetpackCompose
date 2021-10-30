package com.example.fblithoframework.jetpack_compose.ComposeAcitivities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fblithoframework.ComposeComposables

class ComposeTestViewsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Surface(color = MaterialTheme.colors.background) {
                    Column{
                        ActivityPreview()
                    }

            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ActivityPreview() {

Column(modifier = Modifier
    .fillMaxSize()
    .padding(7.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,

) {
    Card(elevation = 10.dp, modifier = Modifier.padding(10.dp), border = BorderStroke(1.dp, Color.Black)){
        Column(modifier = Modifier.padding(10.dp)) {
            Row() {
                Column(modifier = Modifier.fillMaxWidth().weight(1f).align(CenterVertically)) {
                    ComposeComposables.MyText(name = "Name : ")
                }
                Column(modifier = Modifier.fillMaxWidth().weight(3f)) {
                    ComposeComposables.MyTextField();
                }
            }
            Row {

                Column(modifier = Modifier.fillMaxWidth().weight(1f).align(CenterVertically)) {
                    ComposeComposables.MyText(name = "Password : ")
                }
                Column(modifier = Modifier.fillMaxWidth().weight(3f)) {
                    ComposeComposables.MyPasswordField()
                }

            }
            ComposeComposables.MyLoginButton(LocalContext.current)
        }
    }
}

}