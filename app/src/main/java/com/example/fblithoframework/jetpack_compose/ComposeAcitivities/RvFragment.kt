package com.example.fblithoframework.jetpack_compose.ComposeAcitivities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.fblithoframework.R
import com.example.fblithoframework.jetpack_compose.JavaCustomComponents.*
import androidx.compose.runtime.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RvFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val customTimeView = MyCustomTimeView(requireContext())
        customTimeView.setData("text", "text")
        viewList.add(customTimeView)

        return ComposeView(requireContext()).apply {
            setContent {
                    //LazyColumn = Recyclerview
                        val list:List<View> by remember {
                            mutableStateOf(viewList)
                        }

                    LazyColumn(contentPadding = PaddingValues(10.dp), modifier = Modifier.fillMaxWidth()) {

                        items(list ){ v->
                                    Row(modifier = Modifier.fillMaxWidth()) {
                                        AndroidView({v}, modifier = Modifier.fillMaxWidth())
                                    }
                        }


                    }
            }
        }
    }

    companion object{
        var viewList:MutableList<View> = ArrayList()

        fun addView(view:View){
            viewList.add(view)
        }
    }

}

