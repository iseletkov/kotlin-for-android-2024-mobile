package ru.psu.kotlin_android_2024_mobile.ui.calculator_compose

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.psu.kotlin_android_2024_mobile.R
import ru.psu.kotlin_android_2024_mobile.ui.theme.CalculatorTheme

class CActivityCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme(
                dynamicColor = false
            ) {
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




@Composable
fun CalculatorBody(modifier: Modifier = Modifier) {
    //    var op1 by rememberSaveable { mutableStateOf("") }
//    var op2 by rememberSaveable { mutableStateOf("") }
//    var result by rememberSaveable { mutableStateOf("") }

    val viewModel: CViewModelCalculatorCompose = viewModel()

    //val context = LocalContext.current
    val rowHeight = dimensionResource(R.dimen.RowHeight)

    val buttonColors = ButtonDefaults.buttonColors(
        contentColor = Color.White,
        containerColor = MaterialTheme.colorScheme.primary
//        containerColor = primary
    )
    val buttonShape = RoundedCornerShape(20)

    val textFieldColors = OutlinedTextFieldDefaults.colors(
        unfocusedBorderColor = MaterialTheme.colorScheme.primary,
//                focusedBorderColor = Color.Yellow,
        unfocusedTextColor = MaterialTheme.colorScheme.primary,
        focusedTextColor = MaterialTheme.colorScheme.primary,
        focusedLabelColor= MaterialTheme.colorScheme.primary,
        unfocusedLabelColor= MaterialTheme.colorScheme.primary,
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
    )

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,

    )
    {


        OutlinedTextField(
            value = viewModel.op1,
            onValueChange = { value -> viewModel.updateOperand1(value) },
            label = { Text("Операнд 1") },
            singleLine = true,
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            colors = textFieldColors
        )
        OutlinedTextField(
            value = viewModel.op2,
            onValueChange = { value -> viewModel.updateOperand2(value) },
            label = { Text("Операнд 2") },
            singleLine = true,
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            colors = textFieldColors
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
                modifier = Modifier
                    .padding(5.dp),
                colors = buttonColors,
                shape = buttonShape,
                onClick = {
                    viewModel.onButtonPlusClick()
                }
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_add_24),
                    contentDescription = "Localized description",
                    modifier = Modifier.size(ButtonDefaults.IconSize),
//                    tint = Color.Green
                )

                Text(stringResource(R.string.Add))

            }

            // Разность
            Button(
                modifier = Modifier
                    .padding(5.dp),
                colors = buttonColors,
                shape = buttonShape,
                onClick = {
                    viewModel.onButtonMinusClick()

                }) {
                Text("Filled")
            }
        }

        Text(
            text = viewModel.result,
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
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(stringResource(id = R.string.app_name))
                }
            )
        },
//        bottomBar = {
//            BottomAppBar(
//                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                contentColor = MaterialTheme.colorScheme.primary,
//            ) {
//                Text(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    textAlign = TextAlign.Center,
//                    text = "Bottom app bar",
//                )
//            }
//        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = { presses++ }) {
//                Icon(Icons.Default.Add, contentDescription = "Add")
//            }
//        }
    )
    { innerPadding ->
        Box (
            modifier = Modifier
                .padding(innerPadding)
        ){
            Image(
                painter = painterResource(id = R.mipmap.logo),
                contentDescription = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .size(120.dp)
                    .padding(10.dp)
            )

            CalculatorBody()
        }


    }
}
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,dpi=420,isRound=false,chinSize=0dp,orientation=portrait"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewDark",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,dpi=420,isRound=false,chinSize=0dp,orientation=portrait"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,dpi=420,isRound=false,chinSize=0dp,orientation=landscape"
)
@Composable
fun GreetingPreview() {
    CalculatorTheme(
        dynamicColor = false
    )
    {
        MyScaffold()
    }
}