package com.example.islamic_guide.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.islamic_guide.model.Daee

class DaeeViewModel : ViewModel() {
    // In-memory data store
    private val _daeeList = MutableStateFlow<List<Daee>>(emptyList())
    val daeeList: StateFlow<List<Daee>> = _daeeList.asStateFlow()

    init {
        // Initialize with mock data
        _daeeList.value = mockData()
    }

    fun addDaee(daee: Daee) {
        viewModelScope.launch {
            _daeeList.value = _daeeList.value + daee
        }
    }

    fun getDaeeById(id: Int): Daee? {
        return _daeeList.value.find { it.id == id }
    }

    // Mock data for initial setup
    private fun mockData(): List<Daee> {
        return listOf(
            Daee(
                id = 1,
                name = "أحمد ديدات",
                description = "داعية إسلامي متخصص في مقارنة الأديان، مؤسس IPCI.",
                //youtubeLink = "https://youtube.com/ahmaddeedat"
                youtubeLink = "https://www.youtube.com/@Deedat10"
            ),
            Daee(
                id = 2,
                name = "ذاكر نايك",
                description = "داعية هندي، متخصص في مقارنة الأديان والإعجاز العلمي.",
                //youtubeLink = "https://youtube.com/zakirnaik"
                youtubeLink = "https://www.youtube.com/@Drzakirchannel"
            ),
            Daee(
                id = 3,
                name = "يوسف إستس",
                description = "قسيس أمريكي اعتنق الإسلام وأصبح داعية عالميًا.",
                youtubeLink = "https://youtube.com/yusufestes"
            )
        )
    }
}