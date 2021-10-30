package com.example.fblithoframework.jetpack_compose.ComposeAcitivities

import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fblithoframework.ComposeComposables
import com.example.fblithoframework.R
import com.example.fblithoframework.Response.FormDataItem
import com.example.fblithoframework.Response.Repository
import com.example.fblithoframework.jetpack_compose.ui.theme.ui.theme.FbLithoFrameworkTheme
import com.example.fblithoframework.jetpack_compose.ui.theme.ui.theme.Shapes

class ComposeDynamicUIActivity : ComponentActivity() {
    lateinit var itemsList:List<FormDataItem>
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repository = Repository(this)
        itemsList = repository.sortedFormData
        //Log.e("**ComposeDui", "onCreate: "+itemsList )

        setContent {
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn(contentPadding = PaddingValues(10.dp)) {
//                        DynamicActivityPreview()
                        for (item in itemsList){
                                item() {
                                    when(item.fieldInputType){
                                        "TEXT"->    TextView(formDataItem = item)
                                        "NUMERIC"-> NumericView(formDataItem = item)
                                        "TIME"->    TimeView(formDataItem = item)
                                        "DATE"->    DateView(formDataItem = item)
                                        "PHOTOS"->  PhotoView(formDataItem = item)
                                        "GPS"->     GpsView(formDataItem = item)
                                    }
                                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                                           modifier = Modifier.padding(start = 30.dp, end = 30.dp).fillMaxWidth()) {
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Divider(color = Color.Gray, modifier = Modifier.height(0.5.dp).fillMaxWidth())
                                        Spacer(modifier = Modifier.height(8.dp))
                                    }

                                }
                        }
                    }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DynamicActivityPreview() {
    var formDataItem = FormDataItem("1", "03/17/2021", 501, 15, 982, 6334, 1451, "Task Management","Date" )

    Column(
        Modifier
            .fillMaxWidth()
            .padding(2.dp)) {
            DateView(formDataItem = formDataItem)
            TimeView(formDataItem = formDataItem)
            TextView(formDataItem = formDataItem)
            GpsView(formDataItem = formDataItem)
            PhotoView(formDataItem = formDataItem)
            NumericView(formDataItem = formDataItem)
    }
}

@Composable
fun DateView(formDataItem: FormDataItem){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(1.dp)) {
            Row(Modifier.fillMaxWidth()) {
                Text(text = formDataItem.fieldParameterLabel, modifier = Modifier
                    .weight(1f)
                    .size(30.dp), fontSize = 18.sp )
                Text(text = formDataItem.stringValue,modifier = Modifier.weight(1f), Color.Blue, fontSize = 17.sp)
            }
    }
}

@Composable
fun TimeView(formDataItem: FormDataItem){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(1.dp)) {
            Row(Modifier.fillMaxWidth()) {
                Text(text = formDataItem.fieldParameterLabel, modifier = Modifier
                    .weight(1f)
                    .size(30.dp), fontSize = 18.sp )
                Text(text = formDataItem.stringValue, modifier = Modifier
                    .weight(1f), Color.Blue, fontSize = 17.sp)
            }
    }
}

@Composable
fun TextView(formDataItem: FormDataItem){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(1.dp)) {
            Row(Modifier.fillMaxWidth()) {
                Text(text = formDataItem.fieldParameterLabel, modifier = Modifier
                    .weight(1f), fontSize = 18.sp)
            }
            Row(verticalAlignment = CenterVertically,
            modifier = Modifier.padding(5.dp)) {
                var text by remember { mutableStateOf(formDataItem.stringValue) }
                OutlinedTextField(value = text,
                    onValueChange = { text = it},
                    modifier = Modifier.weight(5f),shape = RoundedCornerShape(22.dp))
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_cancel_24), contentDescription = null, modifier = Modifier.padding(4.dp).clickable { text = "" })

            }
    }
}

@Composable
fun GpsView(formDataItem: FormDataItem){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(1.dp)) {
            Row(Modifier.fillMaxWidth()) {
                Text(text = formDataItem.fieldParameterLabel, modifier = Modifier
                    .weight(1f)
                    .size(30.dp), fontSize = 18.sp)
            }
            Row(verticalAlignment = CenterVertically,
            modifier = Modifier.padding(5.dp)) {
                var text by remember { mutableStateOf(formDataItem.stringValue) }
                OutlinedTextField(value = text,
                    onValueChange = { text = it},
                    modifier = Modifier.weight(5f),shape = RoundedCornerShape(22.dp))
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_gps_fixed_24),
                        contentDescription = null,
                        modifier = Modifier.padding(4.dp).clickable { })
            }
    }
}

@Composable
fun PhotoView(formDataItem: FormDataItem){

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)) {
            Row(Modifier.fillMaxWidth()) {

                Text(text = formDataItem.fieldParameterLabel, modifier = Modifier
                    .weight(1f)
                    .size(30.dp), fontSize = 18.sp)
            }
            Row(verticalAlignment = CenterVertically,
                modifier = Modifier.padding(5.dp)) {
                var text by remember { mutableStateOf(formDataItem.stringValue) }
                OutlinedTextField(value = text,
                    onValueChange = { text = it},
                    modifier = Modifier.weight(5f),shape = RoundedCornerShape(22.dp))
                Icon(painter = painterResource(id = R.drawable.ic_baseline_camera_alt_24), contentDescription = null,
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable { })

            }
        }
}

@Composable
fun NumericView(formDataItem: FormDataItem){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(1.dp)) {
            Row(Modifier.fillMaxWidth()) {
                Text(text = formDataItem.fieldParameterLabel, modifier = Modifier
                    .weight(1f)
                    .size(30.dp), fontSize = 18.sp)
            }
            Row(verticalAlignment = CenterVertically,
            modifier = Modifier.padding(5.dp)) {
                var text by remember { mutableStateOf(formDataItem.stringValue) }
                OutlinedTextField(value = text,
                    onValueChange = { text = it},
                    modifier = Modifier.weight(5f),shape = RoundedCornerShape(22.dp))
            }
    }
}
