package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculatorScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {
    var number by remember { mutableStateOf("") }
    var firstNumber by remember { mutableStateOf("") }
    var operation by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = number, modifier = Modifier.padding(bottom = 16.dp))

        Row {
            Button(onClick = { number = "" }) {
                Text(text = "C")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "+/-")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "%")
            }
            Button(onClick = {
                firstNumber = number
                operation = "/"
                number = ""
            }) {
                Text(text = "÷")
            }
        }

        Row {
            Button(onClick = { number += "7" }) {
                Text(text = "7")
            }
            Button(onClick = { number += "8" }) {
                Text(text = "8")
            }
            Button(onClick = { number += "9" }) {
                Text(text = "9")
            }
            Button(onClick = {
                firstNumber = number
                operation = "*"
                number = ""
            }) {
                Text(text = "x")
            }
        }

        Row {
            Button(onClick = { number += "4" }) {
                Text(text = "4")
            }
            Button(onClick = { number += "5" }) {
                Text(text = "5")
            }
            Button(onClick = { number += "6" }) {
                Text(text = "6")
            }
            Button(onClick = {
                firstNumber = number
                operation = "-"
                number = ""
            }) {
                Text(text = "-")
            }
        }

        Row {
            Button(onClick = { number += "1" }) {
                Text(text = "1")
            }
            Button(onClick = { number += "2" }) {
                Text(text = "2")
            }
            Button(onClick = { number += "3" }) {
                Text(text = "3")
            }
            Button(onClick = {
                firstNumber = number
                operation = "+"
                number = ""
            }) {
                Text(text = "+")
            }
        }

        Row {
            Button(onClick = { number += "0" }) {
                Text(text = "0")
            }
            Button(onClick = {
                if (!number.contains(".")) {
                    number += "."
                }
            }) {
                Text(text = ".")
            }
            Button(onClick = {
                if (operation != null && firstNumber.isNotEmpty() && number.isNotEmpty()) {
                    val result = when (operation) {
                        "+" -> firstNumber.toDouble() + number.toDouble()
                        "-" -> firstNumber.toDouble() - number.toDouble()
                        "*" -> firstNumber.toDouble() * number.toDouble()
                        "/" -> {
                            if (number.toDouble() != 0.0) {
                                firstNumber.toDouble() / number.toDouble()
                        } else {
                            "Erro"
                        }                        }
                        else -> 0.0
                    }
                    number = result.toString()
                    operation = null
                    firstNumber = ""
                } else {
                    number = "Error"
                }
            }) {
                Text(text = "=")
            }
        }
    }
}
