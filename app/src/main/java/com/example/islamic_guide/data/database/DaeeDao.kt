import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.OnConflictStrategy

import kotlinx.coroutines.flow.Flow

@Dao
interface DaeeDao {
    @Query("SELECT * FROM duaat")
    fun getAllDuaat(): Flow<List<Daee>>

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insertDaee(daee: Daee)

     @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insertAllDaee(daee: List<Daee>)


    @Delete
    suspend fun deleteDaee(daee: Daee)



}