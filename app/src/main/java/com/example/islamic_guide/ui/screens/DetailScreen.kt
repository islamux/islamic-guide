import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.AlertDialog
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import android.net.Uri
import android.content.Intent
import android.content.Context
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.islamic_guide.viewmodel.DaeeViewModel

@Composable
@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
fun DetailsScreen(daeeId: Int) {
    val viewModel: DaeeViewModel = viewModel()
    val daee = viewModel.getDaeeById(daeeId)
    val context = LocalContext.current

    daee?.let {
        Scaffold(
            topBar = { DetailsTopAppBar(it.name) }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Profile Section
                Box(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                ) {
                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.headlineMedium,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Description Card
                androidx.compose.material3.Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = androidx.compose.material3.CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ) {
                    Text(
                        text = it.description,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(16.dp),
                        textAlign = TextAlign.Justify
                    )
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // YouTube Button
                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.youtubeLink))
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(48.dp),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Play",
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            "Watch on YouTube",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }
        }
    } ?: run {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Daee not found",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
private fun DetailsTopAppBar(title: String) {
    TopAppBar(
        title = { 
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )
}

