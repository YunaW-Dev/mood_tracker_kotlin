package sheridan.wang85.roomy_kotlin.Repository

import androidx.annotation.WorkerThread
import sheridan.wang85.roomy_kotlin.DAO.MoodDAO
import sheridan.wang85.roomy_kotlin.Entity.Mood

class MoodRepository(private val moodDAO: MoodDAO) {
    val allMoods = moodDAO.getAllwithFlow()

    @WorkerThread
    suspend fun insert(mood: Mood){
        moodDAO.insert(mood)
    }
}