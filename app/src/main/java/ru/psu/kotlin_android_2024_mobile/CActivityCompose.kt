package ru.psu.kotlin_android_2024_mobile

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ru.psu.kotlin_android_2024_mobile.ui.theme.Kotlinandroid2024mobileTheme

class CActivityCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlinandroid2024mobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScaffold()
                }
            }
        }
    }
}

fun onButton1Click(
    context: Context,
    op1: String
)
{


    Toast.makeText(
        context,
        op1,
        Toast.LENGTH_LONG
    ).show()
}


@Composable
fun CalculatorBody(padding: PaddingValues, modifier: Modifier = Modifier) {
    var op1 by rememberSaveable { mutableStateOf("") }
    var op2 by rememberSaveable { mutableStateOf("") }
    var result by rememberSaveable { mutableStateOf("") }
    //val context = LocalContext.current
    val rowHeight = dimensionResource(R.dimen.RowHeight)
    Column(
        modifier = Modifier
            .padding(padding)
    )
    {
        TextField(
            value = op1,
            onValueChange = { op1 = it },
            label = { Text("Операнд 1") },
            singleLine = true,
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
        )
        TextField(
            value = op2,
            onValueChange = { op2 = it },
            label = { Text("Операнд 2") },
            singleLine = true,
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
        )

        Row(
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,

        )
        {
            // Сложение
            Button(
                onClick = {
                    result = (op1.toDouble()+op2.toDouble()).toString()
                }
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_add_24),
                    contentDescription = "Localized description",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )

                Text(stringResource(R.string.Add))

            }

            // Разность
            Button(
                onClick = {
                    result = (op1.toDouble()+op2.toDouble()).toString()

                }) {
                Text("Filled")
            }
        }

        Text(
            text = result,
            modifier = Modifier.height(rowHeight)
        )
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold(
    modifier: Modifier = Modifier
)
{
    var presses by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Top app bar")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { presses++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    )
    { innerPadding ->
        CalculatorBody(innerPadding )
    };
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kotlinandroid2024mobileTheme {
        MyScaffold()
    }
}