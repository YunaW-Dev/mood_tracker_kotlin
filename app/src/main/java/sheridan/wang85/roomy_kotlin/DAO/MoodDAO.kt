package sheridan.wang85.roomy_kotlin.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import sheridan.wang85.roomy_kotlin.Entity.Mood
import sheridan.wang85.roomy_kotlin.R

@Dao
interface MoodDAO {

    @Query("SELECT * FROM mood_table")
    fun getAll(): List<Mood>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(mood: Mood)
    
    @Query("DELETE FROM mood_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM mood_table ORDER BY intensity ASC")
    fun getAllwithFlow(): Flow<List<Mood>>
}