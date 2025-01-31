import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun AddDaeeButton(navController: NavHostController) {
    FloatingActionButton(
            onClick = { navController.navigate("add") },
            containerColor = MaterialTheme.colorScheme.secondary
    ) { Icon(Icons.Default.Add, contentDescription = "إضافة داعية", tint = Color.White) }
}
