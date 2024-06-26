package ru.psu.kotlin_android_2024_mobile.ui.compose

import android.graphics.Bitmap
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.ViewModel

class CViewModelPhoto : ViewModel() {
    var bitmap by mutableStateOf<ImageBitmap?>(null)
        private set
    fun setBitmap(newBitmap : Bitmap)
    {
        bitmap = newBitmap.asImageBitmap()
    }
}