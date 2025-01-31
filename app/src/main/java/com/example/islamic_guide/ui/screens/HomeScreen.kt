package com.example.islamic_guide.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.islamic_guide.viewmodel.DaeeViewModel

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: DaeeViewModel) {
    val daeeList = viewModel.daeeList.collectAsState().value

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Scaffold(
                topBar = {
                    TopAppBar(
                            title = { Text("الدعاة") },
                            colors =
                                    TopAppBarDefaults.topAppBarColors(
                                            containerColor =
                                                    MaterialTheme.colorScheme.primaryContainer,
                                            titleContentColor =
                                                    MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = { navController.navigate("add") }) {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    }
                }
        ) { paddingValues ->
            LazyColumn(
                    modifier =
                            Modifier.fillMaxSize()
                                    .padding(paddingValues)
                                    .background(
                                            MaterialTheme.colorScheme.background
                                    ), // Use theme background color
                    contentPadding = PaddingValues(16.dp)
            ) {
                items(daeeList) { daee ->
                    DaeeCard(
                            daee = daee,
                            onClick = { navController.navigate("details/${daee.id}") }
                    )
                }
            }
        }
    }
}
