package com.example.valorantquiz.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.valorantquiz.R // Ensure R import for resources

@Composable
fun ImageScreen(navController: NavController) {
    // List of agent image resources
    val agentImages = listOf(
        R.drawable.astra,
        R.drawable.breach,
        R.drawable.brimstone,
        R.drawable.cypher,
        R.drawable.jett,
        R.drawable.killjoy,
        R.drawable.omen,
        R.drawable.phoenix,
        R.drawable.raze,
        R.drawable.reyna,
        R.drawable.sage,
        R.drawable.skye,
        R.drawable.sova,
        R.drawable.viper,
        R.drawable.yoru
        // Add more agent images as needed
    )

    var currentImageIndex by remember { mutableStateOf(0) }

    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = agentImages[currentImageIndex]),
            contentDescription = "Agent Image",
            modifier = Modifier.fillMaxWidth().height(200.dp)
        )
        Button(
            onClick = {
                currentImageIndex = (currentImageIndex + 1) % agentImages.size
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Next Agent")
        }

        Button(
            onClick = { navController.navigate("list") },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Go to List Activity")
        }
    }
}
