package com.example.emovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.emovie.ui.screen.main.MainModel
import com.example.emovie.ui.router.Router
import com.example.emovie.ui.screen.components.dialogs.CustomImageDialog
import com.example.emovie.ui.theme.MubiTheme
import com.example.emovie.ui.theme.Primary
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainComponent()
        }
    }
}

@Composable
fun MainComponent(mainModel: MainModel = viewModel()) {

    CustomImageDialog(
        show = mainModel.state.networkErrorStatus != null ,
        title = "Error",
        message = mainModel.state.networkErrorStatus?.message ?: "",
        onDismiss = { mainModel.setNetworkErrorStatus(null) }
    )

    val systemUiController = rememberSystemUiController()
    MubiTheme {
        systemUiController.setSystemBarsColor(color = Primary)
        Surface(color = Primary) {
            Router(mainModel)
        }
    }
}