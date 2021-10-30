package com.example.fblithoframework.jetpack_compose.ComposeAcitivities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.fblithoframework.Response.FormDataItem
import com.example.fblithoframework.Response.Repository
import com.example.fblithoframework.jetpack_compose.JavaCustomComponents.*
import com.example.fblithoframework.jetpack_compose.ui.theme.FbLithoFrameworkTheme

class ComposeWithAndroidViews : ComponentActivity() {

    lateinit var itemsList:List<FormDataItem>
    lateinit var repository: Repository
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repository = Repository(this)
        itemsList = repository.sortedFormData
        
        setContent {
            //LazyColumn = Recyclerview
            LazyColumn(contentPadding = PaddingValues(10.dp), modifier = Modifier.fillMaxWidth()) {

                for (item in itemsList){
                    item() {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            when(item.fieldInputType){
                                "TEXT"->    {
                                    var editTextView = MyCustomEditTextView(this@ComposeWithAndroidViews);
                                    editTextView.setData(item.fieldParameterLabel, item.stringValue);
                                    AndroidView({editTextView}, modifier = Modifier.fillMaxWidth())
                                }
                                "NUMERIC"-> {
                                    var numericView = MyCustomNumericView(this@ComposeWithAndroidViews);
                                    numericView.setData(item.fieldParameterLabel, item.stringValue);
                                    AndroidView({numericView}, modifier = Modifier.fillMaxWidth())
                                }
                                "TIME"->    {
                                    var customTimeView = MyCustomTimeView(this@ComposeWithAndroidViews);
                                    customTimeView.setData(item.fieldParameterLabel, item.stringValue);
                                    AndroidView({customTimeView}, modifier = Modifier.fillMaxWidth())
                                }
                                "DATE"->    {
                                    var customDateView = MyCustomDateView(this@ComposeWithAndroidViews);
                                    customDateView.setData(item.fieldParameterLabel, item.stringValue);
                                    AndroidView({customDateView}, modifier = Modifier.fillMaxWidth())
                                }
                                "PHOTOS"->  {
                                    var photoView = MyCustomPhotoView(this@ComposeWithAndroidViews);
                                    photoView.setData(item.fieldParameterLabel, item.stringValue);
                                    AndroidView({photoView}, modifier = Modifier.fillMaxWidth())
                                }
                                "GPS"->     {
                                    var gpsView = MyCustomGpsView(this@ComposeWithAndroidViews);
                                        gpsView.setData(item.fieldParameterLabel, item.stringValue);
                                    AndroidView({gpsView}, modifier = Modifier.fillMaxWidth())
                                }
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
fun DefaultPreview() {

}