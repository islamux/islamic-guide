import androidx.compose.runtime.Composable
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
@Composable
@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
 fun DetailsTopAppBar(daeeName: String?) {
    TopAppBar(
        title = { Text(daeeName ?: "Unknown") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}