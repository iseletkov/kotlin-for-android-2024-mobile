package ru.psu.kotlin_android_2024_mobile.ui.compose.chat

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CChat() {
    val buttonColors = ButtonDefaults.buttonColors(
        contentColor = Color.White,
        containerColor = MaterialTheme.colorScheme.primary
    )
    val buttonShape = RoundedCornerShape(20)

    val viewModel : CViewModelChat = viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn (
            modifier = Modifier
                .weight(1f, fill = true)
        )
        {
            items(viewModel.messages) { message ->
                Text(message)
            }
        }
        OutlinedTextField(
            value = viewModel.message,
            onValueChange = { value -> viewModel.updateMessage(value) },
            label = { Text("Сообщение") },
            singleLine = false,
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth(),
           // colors = textFieldColors
        )
        Button(
            modifier = Modifier
                .height(60.dp)
                .padding(5.dp)
                .fillMaxWidth(),
            colors = buttonColors,
            shape = buttonShape,
            onClick = {
                viewModel.sendMessage()
            }) {
            Text("Отправить")
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
fun CPreviewChat()
{
    CChat()
}