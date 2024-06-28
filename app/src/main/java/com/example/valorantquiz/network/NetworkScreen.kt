package com.example.valorantquiz.network

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

@Composable
fun NetworkScreen(navController: NavController) {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.example.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(ApiService::class.java)

    var response by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        response = try {
            val result = service.getAgents()
            result.joinToString(", ") { it.name }
        } catch (e: Exception) {
            "Error fetching data"
        }
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Network Data")
        Text(response,  modifier = Modifier.padding(top = 16.dp))

        Button(onClick = { navController.navigate("database") }, modifier = Modifier.padding(top = 16.dp)) {
            Text("Go to Database Activity")
        }
    }
}

interface ApiService {
    @GET("agents")
    suspend fun getAgents(): List<Agent>
}

data class Agent(val name: String)