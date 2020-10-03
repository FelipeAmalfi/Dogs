package com.example.course2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DogBreed(
    val breedId: String?,
    val dogBreed: String?,
    val lifeSpan: String?,
    val breedGroup: String?,
    val breedFor: String?,
    val temperament: String?,
    val imageUrl: String?
) : Parcelable