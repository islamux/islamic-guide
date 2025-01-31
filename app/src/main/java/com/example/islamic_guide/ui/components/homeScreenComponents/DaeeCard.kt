package com.example.islamic_guide.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.islamic_guide.model.Daee

@Composable
fun DaeeCard(daee: Daee, onClick: () -> Unit) {
    androidx.compose.material3.Card(
            modifier =
                    Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable(onClick = onClick),
            elevation =
                    androidx.compose.material3.CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors =
                    androidx.compose.material3.CardDefaults.cardColors(
                            containerColor =
                                    MaterialTheme.colorScheme.surface, // Use theme surface color
                            contentColor =
                                    MaterialTheme.colorScheme.onSurface // Use theme text color
                    )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                    text = daee.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = daee.description, style = MaterialTheme.typography.bodyMedium, maxLines = 2)
        }
    }
}
