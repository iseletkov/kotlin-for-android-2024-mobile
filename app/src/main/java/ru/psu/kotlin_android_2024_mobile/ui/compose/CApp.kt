package ru.psu.kotlin_android_2024_mobile.ui.compose

import android.content.res.Configuration
import android.graphics.Bitmap
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.psu.kotlin_android_2024_mobile.R
import ru.psu.kotlin_android_2024_mobile.ui.theme.CAppTheme





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CScaffold(
    onTakePhotoClick : ((Bitmap)->Unit) -> Unit,
    modifier: Modifier = Modifier
)
{
    val navController = rememberNavController()
    // observe the backstack
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    // observe current route to change the icon
    // color,label color when navigated
    val currentRoute = navBackStackEntry?.destination?.route
    val viewModelCalculator: CViewModelCalculatorCompose = viewModel()
    val pages = listOf(
        CPageInfo("calculator", "Калькулятор",
            painterResource(R.drawable.baseline_calculate_24)
        ) {CCalculator(viewModelCalculator)},
        CPageInfo("converter", "Конвертер величин",
            painterResource(R.drawable.baseline_scale_24)
        ) {CConverter()},
        CPageInfo("timer", "Таймер",
            painterResource(R.drawable.baseline_timer_24)
        ) {CTimer()},
        CPageInfo(
            "photo",
            "Вызов камеры",
            painterResource(R.drawable.baseline_photo_camera_24)
        ) {CPhoto(onTakePhotoClick)}
    )
    val currentPage = pages
        .firstOrNull { it.path == currentRoute }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(currentPage?.name?:"Проблема")
                }
            )
        },
        bottomBar = {
            CBottomNavigationBar(
                navController = navController,
                pages = pages
            )
        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = { presses++ }) {
//                Icon(Icons.Default.Add, contentDescription = "Add")
//            }
//        }
    )
    { padding ->
        NavHost(
            navController = navController,
            // set the start destination as home
            startDestination = pages[3].path,

            // Set the padding provided by scaffold
            modifier = Modifier.padding(paddingValues = padding),

            builder = {
                pages.forEach {pageInfo ->
                    composable(pageInfo.path) {
                        pageInfo.content()
                    }
                }
            })
    }
}

@Composable
fun CApp(
    onTakePhotoClick : ((Bitmap)->Unit) -> Unit
)
{
    CAppTheme(
        dynamicColor = false
    )
    {
        CScaffold(onTakePhotoClick)
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
fun CPreview()
{
    CApp {}
}