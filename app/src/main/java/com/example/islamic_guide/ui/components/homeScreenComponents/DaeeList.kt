import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.islamic_guide.model.Daee

@Composable
fun DaeeList(innerPadding: PaddingValues, daeeList: List<Daee>, navController: NavHostController) {
    LazyColumn(
            modifier =
                    Modifier.padding(innerPadding)
                            .fillMaxSize()
                            .background(
                                    brush =
                                            Brush.verticalGradient(
                                                    colors =
                                                            listOf(
                                                                    Color(0xFFB2EBF2),
                                                                    Color(0xFF80DEEA)
                                                            )
                                            )
                            )
    ) {
        items(daeeList.size) { index ->
            val daee = daeeList[index]
            DaeeItem(daee = daee, onClick = { navController.navigate("details/${daee.id}") })
        }
    }
}
