package sheridan.wang85.roomy_kotlin.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import sheridan.wang85.roomy_kotlin.DAO.MoodDAO
import sheridan.wang85.roomy_kotlin.Entity.Mood

@Database(entities = arrayOf(Mood::class), version = 1, exportSchema = false)
public abstract class MoodRoomDatabase : RoomDatabase() {

    abstract fun moodDao(): MoodDAO

    companion object {

        @Volatile
        private var INSTANCE: MoodRoomDatabase? = null

        fun getDatabase(context: Context): MoodRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        MoodRoomDatabase::class.java,
                        "mood_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}