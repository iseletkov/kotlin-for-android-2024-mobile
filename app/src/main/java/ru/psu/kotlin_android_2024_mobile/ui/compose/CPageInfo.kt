package ru.psu.kotlin_android_2024_mobile.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

data class CPageInfo (
    val path : String,
    val name : String,
    val icon : Painter,
    val content : @Composable () -> Unit
)