package com.example.course2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.course2.model.DogBreed

class DetailsViewModel: ViewModel() {


    val selectedDog = MutableLiveData<DogBreed>()

    fun setDog(dog: DogBreed) {
        selectedDog.value = dog
    }

}