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

@Composable
@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
fun DetailsScreen(daee: Daee) {
    var showWebView by remember { mutableStateOf(false) } // State to control WebView visibility

    Scaffold(
        topBar = { DetailsTopAppBar(daee.name) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            DaeeName(daee.name)
            Spacer(modifier = Modifier.height(8.dp))

            DaeeDescription(daee.description)
            Spacer(modifier = Modifier.height(16.dp))

            YouTubeLinkSection(daee)

            // Show WebView in a Dialog
            if (showWebView) {
                AlertDialog(
                    onDismissRequest = { showWebView = false },
                    title = { Text("YouTube") },
                    text = {
                        YouTubeWebView(
                            url = if (daee.name == "أحمد ديدات") {
                                "https://www.youtube.com/@Deedat10/videos"
                            } else {
                                daee.youtubeLink ?: ""
                            }
                        )
                    },
                    confirmButton = {
                        Button(onClick = { showWebView = false }) {
                            Text("Close")
                        }
                    }
                )
            }
        }
    }
}

