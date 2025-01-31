package com.example.islamic_guide.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.islamic_guide.viewmodel.DaeeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(daeeId: Int) {
    val viewModel: DaeeViewModel = viewModel()
    val daee = viewModel.getDaeeById(daeeId)
    val context = LocalContext.current

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        daee?.let {
            Scaffold(topBar = { DetailsTopAppBar(it.name) }) { innerPadding ->
                Column(
                        modifier = Modifier.padding(innerPadding).padding(16.dp).fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Profile Section with larger text
                    Box(modifier = Modifier.padding(vertical = 16.dp)) {
                        Text(
                                text = it.name,
                                style =
                                        MaterialTheme.typography.headlineMedium.copy(
                                                fontSize = 32.sp
                                        ),
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme.primary
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Description Card with larger text
                    Card(
                            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Text(
                                text = it.description,
                                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
                                modifier = Modifier.padding(16.dp),
                                textAlign = TextAlign.Justify
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // YouTube Button - Keep LTR for English text
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                        Button(
                                onClick = {
                                    val intent =
                                            Intent(Intent.ACTION_VIEW, Uri.parse(it.youtubeLink))
                                    context.startActivity(intent)
                                },
                                modifier = Modifier.fillMaxWidth(0.8f).height(48.dp),
                                shape = MaterialTheme.shapes.medium
                        ) {
                            Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                        imageVector = Icons.Default.PlayArrow,
                                        contentDescription = "Play",
                                        modifier = Modifier.padding(end = 8.dp).size(24.dp)
                                )
                                Text(
                                        "Watch on YouTube",
                                        style =
                                                MaterialTheme.typography.labelLarge.copy(
                                                        fontSize = 16.sp
                                                )
                                )
                            }
                        }
                    }
                }
            }
        }
                ?: run {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text(
                                "Daee not found",
                                style = MaterialTheme.typography.headlineMedium,
                                color = MaterialTheme.colorScheme.error
                        )
                    }
                }
    }
}
