package com.example.valorantquiz.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.valorantquiz.R

// Define data class for Agent
data class Agent(val name: String, val imageResId: Int)

@Composable
fun ListScreen(navController: NavController) {
    val agents = listOf(
        Agent("Jett", R.drawable.jett),
        Agent("Phoenix", R.drawable.phoenix),
        Agent("Sage", R.drawable.sage),
        Agent("Sova", R.drawable.sova),
        Agent("Reyna", R.drawable.reyna),
        Agent("Astra", R.drawable.astra),
        Agent("Breach", R.drawable.breach),
        Agent("Brimstone", R.drawable.brimstone),
        Agent("Cypher", R.drawable.cypher),
        Agent("Killjoy", R.drawable.killjoy),
        Agent("Omen", R.drawable.omen),
        Agent("Raze", R.drawable.raze),
        Agent("Skye", R.drawable.skye),
        Agent("Viper", R.drawable.viper),
        Agent("Yoru", R.drawable.yoru)
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Agents List", style = MaterialTheme.typography.headlineLarge)
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(agents) { agent ->
                AgentItem(agent = agent)
            }
        }

        Button(
            onClick = { navController.navigate("design") },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Go to Design Activity")
        }
    }
}

@Composable
fun AgentItem(agent: Agent) {
    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = agent.imageResId),
            contentDescription = "Agent Image",
            modifier = Modifier.size(48.dp)
        )
        Text(
            text = agent.name,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}
