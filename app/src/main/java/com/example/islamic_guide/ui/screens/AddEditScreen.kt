import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.height
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import com.example.islamic_guide.model.Daee

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditScreen(onSave: (Daee) -> Unit) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var youtube by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("إضافة / تعديل داعية") }) }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            TextField(value = name, onValueChange = { name = it }, label = { Text("الاسم") })
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = description, onValueChange = { description = it }, label = { Text("الوصف") })
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = youtube, onValueChange = { youtube = it }, label = { Text("رابط YouTube") })
            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                onSave(Daee(0, name, description, youtube))
            }) {
                Text("حفظ")
            }
        }
    }
}