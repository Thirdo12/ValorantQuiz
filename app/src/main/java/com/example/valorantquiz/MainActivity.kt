package com.example.valorantquiz

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.valorantquiz.quiz.QuizScreen
import com.example.valorantquiz.image.ImageScreen
import com.example.valorantquiz.list.ListScreen
import com.example.valorantquiz.design.DesignScreen
import com.example.valorantquiz.name.InputNameScreen
import com.example.valorantquiz.network.NetworkScreen
import com.example.valorantquiz.ui.theme.ValorantQuizTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantQuizTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "inputName") {
        composable("inputName") { InputNameScreen(navController) }
        composable("quiz") { QuizScreen(navController) }
        composable("image") { ImageScreen(navController) }
        composable("list") { ListScreen(navController) }
        composable("design") { DesignScreen(navController) }
        composable("network") { NetworkScreen(navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ValorantQuizTheme {
        Navigation()
    }
}
