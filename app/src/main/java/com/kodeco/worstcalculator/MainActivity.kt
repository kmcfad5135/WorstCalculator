package com.kodeco.worstcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kodeco.worstcalculator.ui.theme.WorstCalculatorTheme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //Set the content
        setContent {
            WorstCalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WorstCalculator(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun WorstCalculator(modifier: Modifier = Modifier) {
    //Create variables for the inputs
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var answer by remember { mutableStateOf<String?>(null) }

    //Create a column to display fields vertically
    Column(
        modifier = modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        //Create a field for the first number
        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            placeholder = { Text("Enter First Number") }
        )
        //Create a field for the second number
        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            placeholder = { Text("Enter Second Number") }
        )
        //Create a button to initiate the calculation
        Button(onClick = {
            val n1 = num1.toInt()
            val n2 = num2.toInt()
            //Solve the multiplication problem
            val sum = n1 * n2
            answer = sum.toString()
        }){
            //Label the button
            Text("Calculate")
        }
        //Display the answer if the conditions are correct
        answer?.let{
            Text("The answer is $it")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WorstCalculatorPreview() {
    WorstCalculatorTheme {
        //Display the worst calculator
        WorstCalculator()
    }
}