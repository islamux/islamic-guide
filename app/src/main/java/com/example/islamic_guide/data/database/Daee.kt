import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Daee(
    @PrimaryKey val id: Int = 0,
    val name: String?,
    val description: String?,
    val youtubeLink: String?,
)
