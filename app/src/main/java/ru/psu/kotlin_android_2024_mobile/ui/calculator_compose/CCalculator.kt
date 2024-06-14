package ru.psu.kotlin_android_2024_mobile.ui.calculator_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.psu.kotlin_android_2024_mobile.R

@Composable
fun CalculatorBody(
    viewModel : CViewModelCalculatorCompose,
    modifier: Modifier = Modifier) {
    //    var op1 by rememberSaveable { mutableStateOf("") }
//    var op2 by rememberSaveable { mutableStateOf("") }
//    var result by rememberSaveable { mutableStateOf("") }

//    val viewModel: CViewModelCalculatorCompose = viewModel()

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
@Composable
fun CCalculator(viewModel: CViewModelCalculatorCompose)
{
    Box {
        Image(
            painter = painterResource(id = R.mipmap.logo),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier
                .size(120.dp)
                .padding(10.dp)
        )

        CalculatorBody(viewModel)
    }
}