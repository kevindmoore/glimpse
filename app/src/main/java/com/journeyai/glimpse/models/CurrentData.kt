package com.journeyai.glimpse.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChipInfo(val label: String, val selected: Boolean = false) : Parcelable

@Parcelize
data class CurrentData(
    val currentChipInfo: List<ChipInfo> = mutableListOf(),
    var currentImageCategoryResponse: ImageCategoryResponse? = null,
    var currentJournalEntryResponse: JournalEntryResponse? = null
) : Parcelable