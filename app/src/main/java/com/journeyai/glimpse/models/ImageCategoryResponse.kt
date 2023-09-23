package com.journeyai.glimpse.models

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ImageCategoryResponse(
    val data: List<ImageCategoryList> = listOf()
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class ImageCategoryList(val image_id: String, val tags: List<String>) : Parcelable