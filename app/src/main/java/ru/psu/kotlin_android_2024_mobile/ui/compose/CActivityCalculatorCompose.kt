package ru.psu.kotlin_android_2024_mobile.ui.compose

import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.BundleCompat


class CActivityCompose : ComponentActivity() {
    private lateinit var resultLauncher : ActivityResultLauncher<Intent>

    private var onBitmapReadyHandler : (Bitmap) -> Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CApp(
                onTakePhotoClick = ::onTakePhotoClick,
            )
        }
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    // There are no request codes
                    val data: Intent? = result.data
                    val extras = data?.extras

                    val bitmap = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        data?.getParcelableExtra("data", Bitmap::class.java)
                    } else {
                        extras?.let {
                            BundleCompat.getParcelable(
                                it, "data",
                                Bitmap::class.java
                            )
                        }

                    }

                    bitmap?.let {
                        onBitmapReadyHandler(it)
                    }
                }
            }
    }

    private fun onTakePhotoClick(
        onBitmapReady : (Bitmap) -> Unit
    )
    {
        onBitmapReadyHandler = onBitmapReady
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultLauncher.launch(intent)
    }
}