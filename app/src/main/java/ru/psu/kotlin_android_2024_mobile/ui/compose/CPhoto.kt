package ru.psu.kotlin_android_2024_mobile.ui.compose

import android.content.res.Configuration
import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.psu.kotlin_android_2024_mobile.R

@Composable
fun CPhoto(
    onTakePhotoClick : ((Bitmap)->Unit) -> Unit
)
{
    val buttonColors = ButtonDefaults.buttonColors(
        contentColor = Color.White,
        containerColor = MaterialTheme.colorScheme.primary
    )
    val buttonShape = RoundedCornerShape(20)

    val defaultBitmap = ImageBitmap.imageResource(R.mipmap.logo)

    //https://developer.android.com/develop/ui/compose/libraries
    var bitmap by remember { mutableStateOf<ImageBitmap?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            bitmap = bitmap?:defaultBitmap,
            //bitmap = viewModel.bitmap?:defaultBitmap,
            contentDescription = stringResource(id = R.string.photo),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth(),
        )
        // Spacer to fill up the available space
        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier
                .height(60.dp)
                .padding(5.dp)
                .fillMaxWidth(),
            colors = buttonColors,
            shape = buttonShape,
            onClick = {
                onTakePhotoClick{newBitmap ->
                    bitmap = newBitmap.asImageBitmap()
                    //updateBitmap(newBitmap.asImageBitmap())
                }
            }) {
            Text("Take photo")
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
fun CPreviewPhoto()
{
    CPhoto {}
}