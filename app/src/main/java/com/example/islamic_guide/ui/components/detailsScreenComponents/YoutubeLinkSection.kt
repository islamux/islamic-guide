import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.islamic_guide.model.Daee

@Composable
fun YouTubeLinkSection(daee: Daee) {
    val context = LocalContext.current

    Text(
            text = "روابط التواصل:",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
    )
    Spacer(modifier = Modifier.height(8.dp))

    Box(
            modifier =
                    Modifier.fillMaxWidth()
                            .clickable { openYouTubeLink(context, daee) }
                            .padding(8.dp)
    ) { YouTubeLinkRow() }
}
