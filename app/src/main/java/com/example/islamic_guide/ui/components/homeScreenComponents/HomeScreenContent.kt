import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.islamic_guide.model.Daee

@Composable
fun HomeScreenContent(navController: NavHostController, daeeList: List<Daee>) {
    Scaffold(
            topBar = { HomeTopAppBar() },
            floatingActionButton = { AddDaeeButton(navController) }
    ) { innerPadding -> DaeeList(innerPadding, daeeList, navController) }
}
