package com.journeyai.glimpse.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageCategoryRequest(val user_id: String, val start_date: String, val end_date: String)