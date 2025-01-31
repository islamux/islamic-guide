package com.example.islamic_guide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.islamic_guide.navigation.AppNavHost
import com.example.islamic_guide.ui.theme.IslamicGuideTheme
import com.example.islamic_guide.viewmodel.DaeeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IslamicGuideTheme { // Apply the custom blue theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    val viewModel: DaeeViewModel = viewModel()
                    val navController = rememberNavController()

                    AppNavHost(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    // Force RTL layout direction
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        IslamicGuideTheme { // Apply the custom blue theme
            Surface(modifier = Modifier.fillMaxSize()) { content() }
        }
    }
}
