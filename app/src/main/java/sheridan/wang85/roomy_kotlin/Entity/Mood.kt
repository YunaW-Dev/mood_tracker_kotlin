package sheridan.wang85.roomy_kotlin.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mood_table")
data class Mood(
        val name: String,
        val intensity: Boolean,

) {
    @PrimaryKey(autoGenerate = true)
    val id = 0

}