package com.example.islamic_guide.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopAppBar(title: String) {
    TopAppBar(
            title = {
                Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp)
                )
            },
            colors =
                    TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
    )
}
