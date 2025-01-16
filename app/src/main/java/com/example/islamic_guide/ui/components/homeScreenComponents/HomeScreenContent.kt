import androidx.compose.runtime.Composable
import androidx.compose.material3.Scaffold
import androidx.navigation.NavHostController

@Composable
 fun HomeScreenContent(navController: NavHostController, daeeList: List<Daee>) {
    Scaffold(
        topBar = { HomeTopAppBar() },
        floatingActionButton = { AddDaeeButton(navController) }
    ) { innerPadding ->
        DaeeList(innerPadding, daeeList, navController)
    }
}