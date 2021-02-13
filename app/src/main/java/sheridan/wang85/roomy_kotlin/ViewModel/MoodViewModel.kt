package sheridan.wang85.roomy_kotlin.ViewModel

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import sheridan.wang85.roomy_kotlin.Entity.Mood
import sheridan.wang85.roomy_kotlin.Repository.MoodRepository

class MoodViewModel(private val repository: MoodRepository) : ViewModel() {
    //2 vers of aslivedata
    val allMoods: LiveData<List<Mood>> = repository.allMoods.asLiveData()

    fun insert(mood: Mood) = viewModelScope.launch{
        repository.insert(mood)
    }
}

class MoodViewModelFavtory(private val repository: MoodRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoodViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
            return MoodViewModel(repository) as T
        }
        throw IllegalArgumentException("error in viewmodelfactory")
    }
}