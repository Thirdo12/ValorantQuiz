package com.example.valorantquiz.name

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun InputNameScreen(navController: NavController) {
    var playerName by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Enter Your Name")
        OutlinedTextField(
            value = playerName,
            onValueChange = { playerName = it },
            label = { Text("Your Name") },
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Button(
            onClick = {
                if (playerName.isNotBlank()) {
                    navController.navigate("quiz")
                } else {
                    Toast.makeText(navController.context, "Please enter your name", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Proceed to Quiz")
        }
    }
}