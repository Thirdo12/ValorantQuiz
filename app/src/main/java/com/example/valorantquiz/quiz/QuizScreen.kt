@file:JvmName("QuestionKt")

package com.example.valorantquiz.quiz

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// Define the Question data class
data class QuizScreen(val questionText: String, val correctAnswer: String, val choices: List<String>)

// List of questions
val questions = listOf(
    QuizScreen("What is the ultimate ability of Jett?", "Blade Storm", listOf("Blade Storm", "Run It Back", "Resurrection", "Hunter's Fury")),
    QuizScreen("What is the ultimate ability of Phoenix?", "Run It Back", listOf("Run It Back", "Blade Storm", "Resurrection", "Hunter's Fury")),
    QuizScreen("What is the ultimate ability of Sage?", "Resurrection", listOf("Resurrection", "Run It Back", "Blade Storm", "Hunter's Fury"))
    // Add more questions as needed
)

@Composable
fun QuizScreen(navController: NavController) {
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf("") }
    var feedback by remember { mutableStateOf("") }

    val currentQuestion = questions[currentQuestionIndex]

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = currentQuestion.questionText,
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.headlineLarge
        )
        // Display choices as buttons
        currentQuestion.choices.forEach { choice ->
            Button(
                onClick = { selectedAnswer = choice },
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(choice)
            }
        }
        Button(
            onClick = {
                feedback = if (selectedAnswer.equals(currentQuestion.correctAnswer, ignoreCase = true)) {
                    "Correct!"
                } else {
                    "Wrong answer. Try again!"
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Submit")
        }
        Text(
            text = feedback,
            modifier = Modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.bodyLarge
        )

        if (feedback == "Correct!" && currentQuestionIndex < questions.size - 1) {
            Button(
                onClick = {
                    currentQuestionIndex++
                    selectedAnswer = ""
                    feedback = ""
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Next Question")
            }
        }

        Button(
            onClick = { navController.navigate("image") },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Go to Image Activity")
        }
    }
}