import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("details/{daeeId}") { backStackEntry ->
            val daeeId = backStackEntry.arguments?.getInt("daeeId") ?: 0
            val viewModel: DaeeViewModel = viewModel()
            val daee = viewModel.getDaeeById(daeeId) ?: Daee(name = "", description = "", youtubeLink = "")
            DetailsScreen(daee = daee)
        }
        composable("add") {
            val viewModel: DaeeViewModel = viewModel()
            AddEditScreen(onSave = { daee -> viewModel.addDaee(daee) })
        }
    }
}