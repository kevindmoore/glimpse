package com.journeyai.glimpse.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JournalEntryRequest(
    val user_id: String, val start_date: String, val end_date: String,
    val tags: List<String>,
    val temperature: Float = 0.1f,
)