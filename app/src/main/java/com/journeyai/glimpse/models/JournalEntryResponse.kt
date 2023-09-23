package com.journeyai.glimpse.models

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class JournalEntryResponse(
    val data: List<JournalEntry> = listOf()
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class JournalEntry(val entry: String, val tag: String, val title: String) : Parcelable