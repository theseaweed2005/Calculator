package com.example.calculator

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.ui.theme.Pinkie2
import com.example.calculator.ui.theme.Black04
import com.example.calculator.ui.theme.CarnPnk
import java.time.format.TextStyle


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
fun txtbox(number: String, modifier: Modifier = Modifier) {
    Text(
        text = number,
        modifier = modifier.padding(16.dp),
        fontSize = 60.sp,
        fontWeight = FontWeight.Bold
    )
}


@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {
    var number by remember { mutableStateOf("") }
    var firstNumber by remember { mutableStateOf("") }
    var operation by remember { mutableStateOf<String?>(null) }

    val buttonModifier = Modifier
        .padding(4.dp)
        .size(80.dp)
    val buttonShape = RoundedCornerShape(16.dp)



    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {

        txtbox(number = number, modifier = Modifier.align(Alignment.End))
        Row {
            Button(
                onClick = { number = "" },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Pinkie2),
                shape = buttonShape
            ) {
                Text(text = "C", fontSize = 30.sp)
            }
            Button(
                onClick = {
                  //  if (number.isEmpty() || number.last() == '(') {
                 //       number += "("
                 //   } else {
                  //      number += ")"
                  //  }
                    number = "Don't"
                },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Pinkie2),
                shape = buttonShape
            ) {
                Text(text = "()", fontSize = 30.sp)
            }

            Button(onClick = {
                if (number.isNotEmpty()) {
                    number = (number.toDouble() / 100).toString()
                }
            },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Pinkie2),
                shape = buttonShape
            ) {
                Text(text = "%", fontSize = 30.sp)
            }
            Button(onClick = {
                firstNumber = number
                operation = "/"
                number = ""
            },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Pinkie2),
                shape = buttonShape
            ) {
                Text(text = "÷", fontSize = 30.sp)
            }
        }

        Row {
            Button(onClick = { number += "7" },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Black04),
                shape = buttonShape
            ) {
                Text(text = "7", fontSize = 30.sp)
            }
            Button(onClick = { number += "8" },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Black04),
                shape = buttonShape
            ) {
                Text(text = "8", fontSize = 30.sp)
            }
            Button(onClick = { number += "9" },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Black04),
                shape = buttonShape
            ) {
                Text(text = "9", fontSize = 30.sp)
            }
            Button(onClick = {
                firstNumber = number
                operation = "*"
                number = ""
            },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Pinkie2),
                shape = buttonShape
            ) {
                Text(text = "x", fontSize = 30.sp)
            }
        }

        Row {
            Button(onClick = { number += "4" },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Black04),
                shape = buttonShape
            ) {
                Text(text = "4", fontSize = 30.sp)
            }
            Button(onClick = { number += "5" },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Black04),
                shape = buttonShape
            ) {
                Text(text = "5", fontSize = 30.sp)
            }
            Button(onClick = { number += "6" },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Black04),
                shape = buttonShape
            ) {
                Text(text = "6", fontSize = 30.sp)
            }
            Button(onClick = {
                firstNumber = number
                operation = "-"
                number = ""
            },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Pinkie2),
                shape = buttonShape
            ) {
                Text(text = "-", fontSize = 30.sp)
            }
        }

        Row {
            Button(onClick = { number += "1" },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Black04),
                shape = buttonShape
            ) {
                Text(text = "1", fontSize = 30.sp)
            }
            Button(onClick = { number += "2" },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Black04),
                shape = buttonShape
            ) {
                Text(text = "2", fontSize = 30.sp)
            }
            Button(onClick = { number += "3" },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Black04),
                shape = buttonShape
            ) {
                Text(text = "3", fontSize = 30.sp)
            }
            Button(onClick = {
                firstNumber = number
                operation = "+"
                number = ""
            },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Pinkie2),
                shape = buttonShape
            ) {
                Text(text = "+", fontSize = 30.sp)
            }
        }

        Row {
            Button(onClick = {
                if (!number.contains(".")) {
                    number += "."
                }
            },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Pinkie2),
                shape = buttonShape
            ) {
                Text(text = ".", fontSize = 50.sp)
            }
            Button(onClick = { number += "0" },
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(containerColor = Black04),
                shape = buttonShape
            ) {
                Text(text = "0", fontSize = 30.sp)
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
            },

                modifier = Modifier
                .padding(4.dp)
                .size(200.dp, 80.dp),
                colors = ButtonDefaults.buttonColors(containerColor = CarnPnk),
                shape = buttonShape
            ) {
                Text(text = "=", fontSize = 50.sp)
            }
        }
    }
}
