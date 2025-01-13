import androidx.compose.foundation.layout.Column    
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import android.net.Uri
import android.content.Intent


@Composable
@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
fun DetailsScreen(daee: Daee) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(daee.name ?: "Unknown") }) }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            Text(text = daee.name ?: "Unknown", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = daee.description ?: "No description available")
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "روابط التواصل:", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            val context = LocalContext.current
            IconButton(onClick = {
                daee.youtubeLink?.let { url ->
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                }
            }) {
                Icon(Icons.Default.PlayArrow, contentDescription = "YouTube")
            }
        }
    }
}