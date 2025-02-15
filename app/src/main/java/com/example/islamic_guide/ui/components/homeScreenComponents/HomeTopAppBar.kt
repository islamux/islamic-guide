import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

@Composable
 fun HomeTopAppBar() {
    TopAppBar(
        title = { Text("دليل الدعاة الإسلامي", color = Color.White) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}