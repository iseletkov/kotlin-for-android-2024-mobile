package ru.psu.kotlin_android_2024_mobile.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.psu.kotlin_android_2024_mobile.R

@Composable
fun CConverter()
{
    Box {
        Image(
            painter = painterResource(id = R.mipmap.logo),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier
                .size(120.dp)
                .padding(10.dp)
        )

        Text(
            text = "Это конвертер"
        )
    }
}