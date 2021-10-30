package com.example.fblithoframework

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

class ComposeComposables {


    class TextFieldState{
        var name:String by mutableStateOf("")
        var pass:String by mutableStateOf("")

    }

    companion object{

        var textFieldState:TextFieldState = TextFieldState()

        @Composable
        fun MyText(name: String) {
            Row() {
                Text(text =  name)
            }
        }
        
        @Composable
        fun MyTextField(){
            val textFiledState:TextFieldState = remember { textFieldState }
            Row(modifier = Modifier.padding(4.dp)) {
                OutlinedTextField(value = textFiledState.name, onValueChange = { textFiledState.name = it.trim()})
            }
        }
        @Composable
        fun MyPasswordField(){
            val textFiledState:TextFieldState = remember { textFieldState }
            Row(modifier = Modifier.padding(4.dp)) {
                OutlinedTextField(value = textFiledState.pass, onValueChange = { textFiledState.pass = it.trim()}, visualTransformation = PasswordVisualTransformation('*'),keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )
            }
        }

        @Composable
        fun MyLoginButton(context:Context){
            OutlinedButton(onClick = {
                                if(textFieldState.name.equals("pravin") && textFieldState.pass.equals("123")){
                                    Toast.makeText(context, "Login Successfull", Toast.LENGTH_SHORT).show()
                                }else{
                                    Toast.makeText(context, "Login Failed  try pravin and 123", Toast.LENGTH_SHORT).show()
                                }
                             },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan,contentColor = Color.Black),
                modifier = Modifier.fillMaxWidth().padding(10.dp), shape = CircleShape,
                elevation = ButtonDefaults.elevation(5.dp), enabled = true,
                ) {
                Text(text = "Log In")
            }
        }
                
    }
}