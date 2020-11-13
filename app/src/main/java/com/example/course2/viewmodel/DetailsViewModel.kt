package com.example.course2.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.course2.model.DogBreed
import com.example.course2.model.DogDatabase
import kotlinx.coroutines.launch

class DetailsViewModel(application: Application): BaseViewModel(application) {

    val selectedDog = MutableLiveData<DogBreed>()

    fun setDog(dogUuid: Int) {
        launch {
            val dao = DogDatabase(getApplication()).dogDao()
            selectedDog.value = dao.getDog(dogUuid)
        }
    }

}