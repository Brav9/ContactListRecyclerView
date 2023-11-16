package com.khalbro.contactlistrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    val id: Int,
    val phoneNumber: String,
    val isSelected: Boolean,
    val name: String,
    val surname: String
) : Parcelable